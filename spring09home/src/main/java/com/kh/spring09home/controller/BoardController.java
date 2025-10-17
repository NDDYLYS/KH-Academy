package com.kh.spring09home.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;
import com.kh.spring09home.vo.BoardListVO;
import com.kh.spring09home.vo.BoardMentionVO;
import com.kh.spring09home.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final AttachmentService attachmentService;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private MemberDao memberDao;

    BoardController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

	@RequestMapping("/list")
	public String list(Model model, 
			@ModelAttribute PageVO pageVO) {
		
		List<BoardListVO> boardNoticeList = boardDao.selectListNotice(pageVO);
		model.addAttribute("noticeCount", boardNoticeList.size());
		List<BoardListVO> boardList = boardDao.selectListWithPaging(pageVO);
		
		List<BoardListVO> result = new ArrayList<>();
		result.addAll(boardNoticeList);
		result.addAll(boardList);
		model.addAttribute("boardList", result);		
		
		int dataCount = boardDao.count(pageVO);
		pageVO.setDataCount(dataCount);
		
		model.addAttribute("pageVO", pageVO);
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@RequestMapping("/list2")
	public String list2(Model model, 
			@ModelAttribute PageVO pageVO) {
		
		//List<BoardListVO> boardNoticeList = boardDao.selectListNotice(pageVO);
		//model.addAttribute("noticeCount", boardNoticeList.size());
		List<BoardMentionVO> boardList = boardDao.selectListWithMention(pageVO);
		model.addAttribute("boardList", boardList);		
		
		int dataCount = boardDao.count(pageVO);
		pageVO.setDataCount(dataCount);
		
		model.addAttribute("pageVO", pageVO);
		
		return "/WEB-INF/views/board/list2.jsp";
	}

	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/board/insert.jsp";
	}

	// 새글은 boardOrigin이 null이다
	// -> 그룹번호는 글번호, 상위글은 null,차수는 0
	// 답글은 boardOrigin이 null이 아니다
	// -> 그룹번호는 대상글의 글번호, 
	@PostMapping("/insert")
	public String insert(HttpSession session,
			@ModelAttribute BoardDto boardDto) {
		String loginId = (String)session.getAttribute("loginId");
		boardDto.setBoardWriter(loginId);
		
		// 검사를 통해 관리자가 아닌데 공지사항을 쓰려고 하면 차단한다
		String loginLevel = (String)session.getAttribute("loginLevel");
		if (loginLevel.equals("관리자") == false && boardDto.getBoardNotice().equals("Y"))
			throw new NeedPermissionException("공지글을 작성할 권한이 없습니다");
		
		int boardNo = boardDao.sequence();//번호를 생성해서
		boardDto.setBoardNo(boardNo);//게시글 정보에 합친다
		
		if (boardDto.getBoardOrigin() == null) 
		{
			boardDto.setBoardGroup(boardNo);
			//boardDto.setBoardOrigin(null);
			//boardDto.setBoardDepth(0);
		}
		else 
		{
			BoardDto findDto = boardDao.selectOne(boardDto.getBoardOrigin());
			boardDto.setBoardGroup(findDto.getBoardGroup());
			// boardDto.setBoardOrigin(findDto.getBoardNo()); // 생략 가능
			boardDto.setBoardDepth(findDto.getBoardDepth() + 1);
		}
		
		boardDao.insert(boardDto);
		return "redirect:/board/detail?boardNo=" + boardNo;
	}

	@RequestMapping("/detail")
	public String detail(HttpSession session,
			Model model, 
			@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
		
		if (boardDto.getBoardWriter() != null) 
		{			
			MemberDto memberDto = memberDao.selectOne(boardDto.getBoardWriter());
			model.addAttribute("memberDto", memberDto);
		}

		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/detail.jsp";
	}
	
//	@RequestMapping("/like")
//	public String like(Model model,
//			@RequestParam long boardNo) {
//		BoardDto boardDto = boardDao.selectOne(boardNo);
//		if (boardDto == null) 
//			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
//		model.addAttribute("boardDto", boardDto);
//		boardDao.like(boardNo);
//		return "/WEB-INF/views/board/detail.jsp";
//	}
	
	@GetMapping("/update")
	public String update(Model model,
			@RequestParam int boardNo)
	{
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/update.jsp";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto boardDto) 
	{
		BoardDto beforeDto = boardDao.selectOne(boardDto.getBoardNo());
		if (beforeDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");		
		
		Set<Integer> before = new HashSet<>();
		Document beforeDocument = Jsoup.parse(boardDto.getBoardContent());
		Elements beforeElements = beforeDocument.select(".custom-image");
		for(Element element : beforeElements) {
			int attachmentNo = Integer.parseInt(element.attr("data-pk"));
			before.add(attachmentNo);
		}
		
		Set<Integer> after = new HashSet<>();
		Document afterDocument = Jsoup.parse(boardDto.getBoardContent());
		Elements afterElements = afterDocument.select(".custom-image");
		for(Element element : afterElements) {
			int attachmentNo = Integer.parseInt(element.attr("data-pk"));
			before.add(attachmentNo);
		}
		
		Set<Integer> minus= new HashSet<>(before);
		minus.removeAll(after);
		for(int attachmentNo : minus)
			attachmentService.delete(attachmentNo);
		
		boardDao.update(boardDto);
		return "redirect:detail?boardNo=" + boardDto.getBoardNo();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo)
	{
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");		
		
		Document document = Jsoup.parse(boardDto.getBoardContent());
		Elements elements = document.select(".custom-image");
		for(Element element : elements) {
//			String src = element.attr("src");
//			int equal = src.lastIndexOf("=");
//			int attachmentNo = Integer.parseInt(src.substring(equal + 1));
			int attachmentNo = Integer.parseInt(element.attr("data-pk"));
			attachmentService.delete(attachmentNo);
		}
		
		boardDao.delete(boardNo);
		return "redirect:list";
	}
}

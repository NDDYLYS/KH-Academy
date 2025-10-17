package com.kh.spring09home.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dao.ReplyDao;
import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.dto.ReplyDto;
import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.vo.ReplyListVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private BoardDao boardDao;
	
	
//	@PostMapping("/list")
//	public List<ReplyDto> list(@RequestParam int replyTarget)
//	{
//		return replyDao.selectList(replyTarget);
//	}
//	
	@PostMapping("/list")
	public List<ReplyListVO> list(@RequestParam int replyTarget, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");//null일 수 있음(=비회원)
		
		BoardDto boardDto = boardDao.selectOne(replyTarget);//게시글 정보 조회
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 글");
		
		List<ReplyDto> list = replyDao.selectList(replyTarget);//우선 목록 조회를 하고
		List<ReplyListVO> result = new ArrayList<>();//비어있는 목록은 만든 뒤
		//하나씩 옮겨담아서 (list ---> result)
		for(ReplyDto replyDto : list) {
			boolean owner = loginId != null && replyDto.getReplyWriter() != null
											&& loginId.equals(replyDto.getReplyWriter());
			boolean writer = boardDto.getBoardWriter() != null
								&& replyDto.getReplyWriter() != null
								&& boardDto.getBoardWriter().equals(replyDto.getReplyWriter());
			
			result.add(ReplyListVO.builder()
						.replyNo(replyDto.getReplyNo())
						.replyWriter(replyDto.getReplyWriter())
						.replyTarget(replyDto.getReplyTarget())
						.replyContent(replyDto.getReplyContent())
						.replyWtime(replyDto.getReplyWtime())
						.replyEtime(replyDto.getReplyEtime())
						.owner(owner)
						.writer(writer)
					.build());
		}
		return result;
	}
	
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto,
			HttpSession session) 
	{
		int sequence = replyDao.sequence();
		replyDto.setReplyNo(sequence);
		String loginId = (String)session.getAttribute("loginId");
		replyDto.setReplyWriter(loginId);
		replyDao.insert(replyDto);
		boardDao.addReply(replyDto.getReplyTarget());
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam int replyNo, HttpSession session) 
	{
		String loginId = (String)session.getAttribute("loginId");
		ReplyDto findDto = replyDao.selectOne(replyNo);
		if (findDto == null)
			throw new TargetNotfoundException("존재하지 않는 댓글");		
		boolean owner = loginId.equals(findDto.getReplyWriter());
		if (owner == false)
			throw new NeedPermissionException("권한 부족");		
		
		replyDao.delete(replyNo);
		boardDao.removeReply(findDto.getReplyTarget());
	}
	
	@PostMapping("/edit")
	public void edit(@ModelAttribute ReplyDto replyDto, HttpSession session)
	{
		String loginId = (String)session.getAttribute("loginId");
		ReplyDto findDto = replyDao.selectOne(replyDto.getReplyNo());
		if (findDto == null)
			throw new TargetNotfoundException("존재하지 않는 댓글");		
		boolean owner = loginId.equals(findDto.getReplyWriter());
		if (owner == false)
			throw new NeedPermissionException("권한 부족");		
		
		replyDao.update(replyDto);
	}
}
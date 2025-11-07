package com.kh.spring09home.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.PokemonDao;
import com.kh.spring09home.dto.PokemonDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;
import com.kh.spring09home.vo.PageVO;

@Controller
@RequestMapping("/pokemon")
public class PokemonController 
{
	@Autowired
	private PokemonDao pokemonDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/add")
	public String add() 
	{
		return "/WEB-INF/views/pokemon/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		int pokemonNo = pokemonDao.sequence();
		pokemonDto.setPokemonNo(pokemonNo);
		pokemonDao.insert(pokemonDto);
		
		if(!attach.isEmpty()) 
		{
			int attachmentNo = attachmentService.save(attach);
			pokemonDao.connect(pokemonNo, attachmentNo);
		}
		
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() 
	{
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}
	
	// 목록 페이지 매핑
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute(value = "pageVO") PageVO pageVO) 
	{
		model.addAttribute("pokemonList", pokemonDao.selectListWithPaging(pageVO));
		pageVO.setDataCount(pokemonDao.count(pageVO));
		model.addAttribute("pageVO", pageVO); // @ModelAttribute에 value 설정시 생략 가능
		
		return "/WEB-INF/views/pokemon/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam int pokemonNo) 
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if (pokemonDto == null) 
		{
			//return "redirect:list"; // 에러페이지매핑
			//throw new RuntimeException("존재하지 않는 포켓몬 번호");
			throw new TargetNotfoundException("존재하지 않는 포켓몬 번호");
		}
		
		model.addAttribute("pokemonDto", pokemonDto);
		
		return "/WEB-INF/views/pokemon/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int pokemonNo)
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if (pokemonDto == null) 
		{
			//return "redirect:list"; // 에러페이지매핑
			//throw new RuntimeException("존재하지 않는 포켓몬 번호");
			throw new TargetNotfoundException("존재하지 않는 포켓몬 번호");
		}
		
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto,
			@RequestParam MultipartFile attach,
			@RequestParam(required = false) String remove) throws IllegalStateException, IOException 
	{
		PokemonDto findDto = pokemonDao.selectOne(pokemonDto.getPokemonNo());
		if (findDto == null)
			throw new TargetNotfoundException("포켓몬 파일이 없음");
		
		if (!attach.isEmpty())
		{
			try 
			{
				int attachmentNo = pokemonDao.findAttachment(pokemonDto.getPokemonNo());
				attachmentService.delete(attachmentNo);
			}
			catch(Exception e) { /*아무것도 안함*/ }
			
			int attachmentNo = attachmentService.save(attach);
			pokemonDao.connect(pokemonDto.getPokemonNo(), attachmentNo);
		}
		else 
		{
			if (remove != null) 
			{
				try 
				{
					int attachmentNo = pokemonDao.findAttachment(pokemonDto.getPokemonNo());
					attachmentService.delete(attachmentNo);
				}
				catch(Exception e) { /*아무것도 안함*/ }
			}				
		}
		
		pokemonDao.update(pokemonDto);
		return "redirect:detail?pokemonNo=" + pokemonDto.getPokemonNo();
	}
	
	// 첨부파일도 같이 삭제되도록 수정
	// attachmentService.delete 추가
	@RequestMapping("/remove")
	public String remove(@RequestParam int pokemonNo)
	{
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if (pokemonDto == null) 
		{
			throw new TargetNotfoundException("존재하지 않는 포켓몬 번호");
		}
		
		try 
		{
			int attachmentNo = pokemonDao.findAttachment(pokemonNo);
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) { /*아무것도 안함*/ }
		
		pokemonDao.delete(pokemonNo);
		return "redirect:list";
	}
	
	// 포켓몬 번호를 받아서 프로필 이미지 주소로 쫓아내는 매핑 구현
	@GetMapping("/image")
	public String image(@RequestParam int pokemonNo) 
	{
		try 
		{
			int attachmentNo = pokemonDao.findAttachment(pokemonNo);
			return "redirect:/attachment/download?attachmentNo=" + attachmentNo;			
		}
		catch(Exception e) 
		{
			return "redirect:/images/error/no-image.png";
		}
	}
}
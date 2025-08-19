package com.kh.spring06music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06music.dao.MusicDao;
import com.kh.spring06music.dto.MusicDto;

@RestController
@RequestMapping("/music")
public class MusicController 
{
	@Autowired
	private MusicDao musicDao;
	
	@RequestMapping("/create")
	public String create(@ModelAttribute MusicDto musicDto) 
	{
		musicDao.insert(musicDto);
		return "음원 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute MusicDto musicDto) 
	{
		boolean success = musicDao.update(musicDto);
		if (success)
			return "음원 수정 완료";
		else
			return "음원 수정 실패";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int musicNo) 
	{
		boolean success = musicDao.delete(musicNo);
		if (success)
			return "음원 삭제 완료";
		else
			return "음원 삭제 실패";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "") String column, 
			@RequestParam(required = false, defaultValue = "") String keyword) 
	{
		List<MusicDto> list = null;
		if (column.equals("") || keyword.equals(""))
			list = musicDao.selectList();
		else
			list = musicDao.selectSearch(column, keyword);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append("음원 수 : " + list.size() + "<br>");
		for(MusicDto solo : list)
		{
			buffer.append(solo);
			buffer.append("<br>");			
		}
		
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int musicNo) 
	{
		MusicDto musicDto = musicDao.selectOne(musicNo);
		if (musicDto == null)
			return "존재하지 않는 음원입니다.";
			
		StringBuffer buffer = new StringBuffer();
	
		buffer.append(musicDto);
		buffer.append("<br>");
		
		return buffer.toString();
	}
	
	@RequestMapping("/play")
	public String play(@RequestParam int musicNo) 
	{
		MusicDto musicDto = musicDao.selectOne(musicNo);
		if (musicDto == null)
			return "음원 정보가 없습니다.";
		
		long play = musicDto.getMusicPlay();
		musicDto.setMusicPlay(play + 1);
		this.edit(musicDto);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append(musicDto);
		return buffer.toString();
	}
	
	@RequestMapping("/like")
	public String like(@RequestParam int musicNo) 
	{
		MusicDto musicDto = musicDao.selectOne(musicNo);
		if (musicDto == null)
			return "음원 정보가 없습니다.";
		
		long like = musicDto.getMusicLike();
		musicDto.setMusicLike(like + 1);
		this.edit(musicDto);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append(musicDto);
		return buffer.toString();
	}
}

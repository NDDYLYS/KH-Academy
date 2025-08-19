package com.kh.spring06music.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06music.dto.MusicDto;
import com.kh.spring06music.mapper.MusicMapper;

@Repository
public class MusicDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MusicMapper musicMapper;
	
	public void insert(MusicDto musicDto) 
	{
		String sql = "insert into music (music_no, music_title, "
				+ "music_album, music_artist, music_add) "
				+ "values (music_seq.nextval, ?, ?, ?, systimestamp)";
		Object[] params = {
				musicDto.getMusicTitle(),
				musicDto.getMusicAlbum(),
				musicDto.getMusicArtist()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(MusicDto musicDto) 
	{                        
		String sql = "update music set music_title=?, "
				+ "music_album=?, music_artist=?, "
				+ "music_play=?, music_like=?, "
    			+ "music_edit=systimestamp where music_no=?";
    	Object[] params = {musicDto.getMusicTitle(),
    			musicDto.getMusicAlbum(), musicDto.getMusicArtist(),
    			musicDto.getMusicPlay(), musicDto.getMusicLike(),
    			musicDto.getMusicNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int musicNo) 
	{
		String sql = "delete music where music_no=?";
    	Object[] params = {musicNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<MusicDto> selectSearch(String column, String keyword)
	{
		Set<String> allowList = Set.of("music_title", 
				"music_album", "music_artist");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from music where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, music_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, musicMapper, params);
	}
	
	public List<MusicDto> selectList()
	{
		String sql = "select * from music order by music_no asc";
    	return jdbcTemplate.query(sql, musicMapper);
	}
	
	public MusicDto selectOne(int musicNo) 
	{
		String sql = "select * from music where music_no = ?";
		Object[] params = {musicNo};
		List<MusicDto> list = jdbcTemplate.query(sql, musicMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
}

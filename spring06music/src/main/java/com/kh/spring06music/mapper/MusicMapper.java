package com.kh.spring06music.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring06music.dto.MusicDto;

@Component
public class MusicMapper implements RowMapper<MusicDto>
{
	@Override
	public MusicDto mapRow(ResultSet rs, int rowNun) throws SQLException 
	{
		MusicDto musicDto = new MusicDto();
		
		musicDto.setMusicNo(rs.getInt("music_no"));
		musicDto.setMusicTitle(rs.getString("music_title"));
		musicDto.setMusicAlbum(rs.getString("music_album"));
		musicDto.setMusicArtist(rs.getString("music_artist"));
		musicDto.setMusicPlay(rs.getLong("music_play"));
		musicDto.setMusicLike(rs.getLong("music_like"));
		musicDto.setMusicAdd(rs.getTimestamp("music_add"));
		musicDto.setMusicEdit(rs.getTimestamp("music_edit"));
		
		// TODO Auto-generated method stub
		return musicDto;
	}
}

package com.kh.spring06music.dto;

import java.sql.Timestamp;

public class MusicDto 
{
	private int musicNo;
	private String musicTitle;
	private String musicAlbum;
	private String musicArtist;
	private long musicPlay;
	private long musicLike;
	private Timestamp musicAdd;
	private Timestamp musicEdit;
	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public String getMusicArtist() {
		return musicArtist;
	}
	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}
	public long getMusicPlay() {
		return musicPlay;
	}
	public void setMusicPlay(long musicPlay) {
		this.musicPlay = musicPlay;
	}
	public long getMusicLike() {
		return musicLike;
	}
	public void setMusicLike(long musicLike) {
		this.musicLike = musicLike;
	}
	public Timestamp getMusicAdd() {
		return musicAdd;
	}
	public void setMusicAdd(Timestamp musicAdd) {
		this.musicAdd = musicAdd;
	}
	public Timestamp getMusicEdit() {
		return musicEdit;
	}
	public void setMusicEdit(Timestamp musicEdit) {
		this.musicEdit = musicEdit;
	}
	public MusicDto() {
		super();
	}
	@Override
	public String toString() {
		return "MusicDto [musicNo=" + musicNo + ", musicTitle=" + musicTitle + ", musicAlbum=" + musicAlbum
				+ ", musicArtist=" + musicArtist + ", musicPlay=" + musicPlay + ", musicLike=" + musicLike
				+ ", musicAdd=" + musicAdd + ", musicEdit=" + musicEdit + "]";
	}
}

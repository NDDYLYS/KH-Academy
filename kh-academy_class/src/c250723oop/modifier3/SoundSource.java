package c250723oop.modifier3;;

public class SoundSource 
{
	private int rank;
	private String title;
	private String singer;
	private String album;
	private long like;
	private long play;
	
	public SoundSource(int rank, String title, String singer, String album, long like, long play) 
	{
		this.setRank(rank);
		this.setTitle(title);
		this.setSinger(singer);
		this.setAlbum(album);
		this.setLike(like);
		this.setPlay(play);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		if (rank < 1)
			return;
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		if (like < 0)
			return;
		this.like = like;
	}

	public long getPlay() {
		return play;
	}

	public void setPlay(long play) {
		if (play < 0)
			return;
		this.play = play;
	}
	
	public void info() 
	{
		long rankingPoint = this.getLike() * 123 + this.getPlay();
		System.out.println(this.getRank() + "위. " + this.getTitle() + "(" + this.getSinger() + ") : " + this.getLike() + " * " + 123 + " + " + this.getPlay() + " = " + rankingPoint);
	}
}
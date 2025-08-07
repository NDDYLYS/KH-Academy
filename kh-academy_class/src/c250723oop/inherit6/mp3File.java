package c250723oop.inherit6;;

public class mp3File extends mpFile
{
	protected double duration;
	

	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public mp3File(String filename, long filesize, double duration) {
		super();
		this.setFilename(filename);
		this.setFilesize(filesize);
		this.setDuration(duration);
		// TODO Auto-generated constructor stub
	}
}
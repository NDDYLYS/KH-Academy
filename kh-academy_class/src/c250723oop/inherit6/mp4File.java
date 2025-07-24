package c250723oop.inherit6;;

public class mp4File extends mpFile
{
	protected double speed;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public mp4File(String filename, long filesize, double speed) {
		super();
		this.setFilename(filename);
		this.setFilesize(filesize);
		this.setSpeed(speed);
		// TODO Auto-generated constructor stub
	}
}
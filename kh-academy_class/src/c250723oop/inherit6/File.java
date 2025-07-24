package c250723oop.inherit6;;

public class File 
{
	protected String filename;
	protected long filesize;
	
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	protected void infomation()
	{
		System.out.println(this.getFilename() + " 정보출력 기능");
	}
	
	protected void execute()
	{
		System.out.println(this.getFilename() + " 실행 기능");
	}
	
	protected void info(String filename, long filesize, int pagesize) 
	{
		System.out.println(filename + " / " + filesize + " / " + pagesize);
	}
	
	protected void info(String filename, long filesize, double temp) 
	{
		System.out.println(filename + " / " + filesize + " / " + temp);
	}
}
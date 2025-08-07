package c250723oop.inherit6;;

public class pptFile extends documentFile
{
	protected void slideShow() 
	{
		System.out.println(this.getFilename() + " 슬라이드쇼 기능");
	}

	public pptFile(String filename, long filesize, int pagesize) {
		super();
		// TODO Auto-generated constructor stub
		this.setFilename(filename);
		this.setFilesize(filesize);
		this.setPagesize(pagesize);
	}
}
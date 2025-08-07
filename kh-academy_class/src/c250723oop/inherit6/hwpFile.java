package c250723oop.inherit6;;

public class hwpFile extends documentFile
{
	protected void preview() 
	{
		System.out.println(this.getFilename() + " 미리보기 기능");
	}

	public hwpFile(String filename, long filesize, int pagesize) {
		super();
		this.setFilename(filename);
		this.setFilesize(filesize);
		this.setPagesize(pagesize);
	}
}
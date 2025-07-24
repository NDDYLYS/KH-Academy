package c250723oop.inherit6;;

public class Main 
{
    public static void main(String[] args) 
    {
    	mp4File mp4 = new mp4File("MP4", 12312312, 1D);
    	mp3File mp3 = new mp3File("MP3", 12305324, 50D);
    	hwpFile hwp = new hwpFile("HWP", 12312354, 20);
    	pptFile ppt = new pptFile("PPT", 2131236, 33);
    	
    	mp4.info(mp4.getFilename(), mp4.getFilesize(), mp4.getSpeed());
    	mp4.execute();
    	mp4.forward();
    	mp4.rewind();
    	mp4.infomation();    	
    	
    	mp3.info(mp3.getFilename(), mp3.getFilesize(), mp3.getDuration());
    	mp3.execute();
    	mp3.forward();
    	mp3.rewind();
    	mp3.infomation();
    	
    	hwp.info(hwp.getFilename(), hwp.getFilesize(), hwp.getPagesize());
    	hwp.execute();
    	hwp.preview();
    	hwp.infomation();
    	
    	ppt.info(ppt.getFilename(), ppt.getFilesize(), ppt.getPagesize());
    	ppt.execute();
    	ppt.slideShow();
    	ppt.infomation();
    }
}
package c250723oop.inherit4;;

public class Main 
{
    public static void main(String[] args) 
    {
    	WebCam wc = new WebCam();
    	wc.setName("WebCam"); 
    	wc.setPixel(1280);
    	
    	ActionCam ac = new ActionCam();
    	ac.setName("ActionCam");
    	ac.setPixel(2560);
    	
    	DigitalCam dc = new DigitalCam();
    	dc.setName("DigitalCam");
    	dc.setPixel(5120);
    	
    	wc.info();
    	wc._record();
    	wc.decorate();
    	
    	ac.info();
    	ac._record();
    	ac.slowMotion();
    	ac.reduce();
    	
    	dc.info();
    	dc._record();
    	dc.wideRecord();
    	dc.slowMotion();
    }
}
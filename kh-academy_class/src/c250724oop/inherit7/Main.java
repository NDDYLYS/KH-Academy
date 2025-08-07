package c250724oop.inherit7;;

public class Main 
{
    public static void main(String[] args) 
    {
    	Galaxy25s a = new Galaxy25s("010-6285-4967", "검정");
    	GalaxyFold7 b = new GalaxyFold7("010-6306-4967", "파랑");
    	
    	a.show();
    	a.call();
    	a.sms();
    	a.samsungPay();
    	a.bixby();
    	
    	b.show();
    	b.call();
    	b.sms();
    	b.samsungPay();
    	b.iris();
    }
}
package c250723oop.modifier3;

public class Test02음원정보 
{
    public static void main(String[] args) 
    {
    	SoundSource s1 = new SoundSource(1, "Golden", "HUNTRIX", "KPop Demon Hunters", 83758, 128331);
    	SoundSource s2 = new SoundSource(2, "Soda Pop", "사자보이즈", "KPop Demon Hunters", 52675, 53899);
    	SoundSource s3 = new SoundSource(3, "뛰어(JUMP)", "BLACKPINK", "뛰어(JUMP)", 35699, 83829);
    	SoundSource s4 = new SoundSource(4, "FAMOUS", "ALLDAY PROJECT", "FAMOUS", 74665, 18288);
    	
    	s1.info();
    	s2.info();
    	s3.info();
    	s4.info();
    }
}
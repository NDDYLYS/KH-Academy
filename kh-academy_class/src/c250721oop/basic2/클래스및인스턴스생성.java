package c250721oop.basic2;;

public class 클래스및인스턴스생성 
{
    public static void main(String[] args) 
    {
//    	Country korean = new Country();
//    	korean.name = "한국";
//    	korean.capital = "서울";
//    	korean.population = 50000000L;
//    	
//     	Country japan = new Country();
//     	japan.name = "일본";
//     	japan.capital = "도쿄";
//     	japan.population = 120000000L;
//    	
//     	Country china = new Country();
//     	china.name = "중국";
//     	china.capital = "베이징";
//     	china.population = 1400000000L;
//    	
//     	Country america = new Country();
//     	america.name = "미국";
//     	america.capital = "워싱턴";
//     	america.population = 2500000000L;
    	
    	Country korean = new Country("한국", "서울", 50000000L);
    	Country japan = new Country("일본", "도쿄", 120000000L);
    	Country china = new Country("중국", "베이징", 140000000L);
    	Country america = new Country("미국", "워싱턴", 250000000L);
    	
    	korean.PrintAll();
    	japan.PrintAll();
    	china.PrintAll();
    	america.PrintAll();
    }
}
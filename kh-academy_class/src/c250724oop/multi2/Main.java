package c250724oop.multi2;;

public class Main 
{
    public static void main(String[] args) 
    {
    	Airplane air = new Airplane();
    	Bus bus = new Bus();
    	Drone drone = new Drone();
    	Kickboard kick = new Kickboard();
    	Train train = new Train();
    	
    	air.move();
    	air.fly();
    	air.resetvation();
    	
    	bus.move();
    	
    	drone.onoff();
    	drone.move();
    	drone.fly();
    	
    	kick.onoff();
    	kick.move();
    	
    	train.move();
    	train.resetvation();
    }
}
package c250723oop.inherit3;;

public class Main 
{
    public static void main(String[] args) 
    {
    	Chrome chrome = new Chrome();
    	chrome.setUrl("https://www.chrome.com");
    	Edge edge = new Edge();
    	edge.setUrl("https://www.edge.com");
    	Whale whale = new Whale(); 
    	whale.setUrl("https://www.whale.com");
    	
    	chrome.getUrl();
    	edge.getUrl();
    	whale.getUrl();
    	System.out.println();
    	
    	chrome.refresh();
    	edge.refresh();
    	whale.refresh();
    	System.out.println();
    	
    	chrome.move();
    	edge.move();
    	whale.move();
    	System.out.println();
    	
    	chrome.develop();
    	chrome.chromeStore();
    	edge.fullScreen();
    	whale.papago();
    	whale.naverSearch();
    }
}
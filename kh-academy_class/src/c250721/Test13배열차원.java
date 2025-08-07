package c250721;;

public class Test13배열차원 
{
    public static void main(String[] args) 
    {
    	// 0차원 점 => 변수, 1차원 선 => 1차원 배열, 2차원 면, 3차원 공간
    	
    	// 데이터의 차원?
    	// 데이터를 바라보는 관점에 따른 깊이
    	
    	// 60명의 시험점수
    	// 0차원 > 변수 60개
    	// 1차원 > 60개짜리 1차원 배열 int[] scores = new int[60];
    	// scores[0] = 70;
    	// 2차원 > 3개 반에서 20명씩 추출 int[][] scores = new int[3][20];
    	// scores[0][0] = 70;
    	// 3차원 > 2개 학년의 3개반에서 10명씩 추출 int[][][] scores = new int[2][3][10];
    	// scores[0][0][0] = 70;
    	// 4차원 > 2개 학교 2개 학년 3개반 5명씩 추출 int[][][][] scores = new int[2][2][3][5];
    	// scores[0][0][0][0] = 70;
    }
}
package c250718;

import java.util.Scanner;

;

public class Test05성적계산기 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 반 학생 10명의 시험성적을 입력하도록 하고 입력된 점수를 이용하여 출력
    	// 합격자(60점 이상) 점수 츌력
    	// 평균
    	// 90점 이상 인원수 출력
    	
    	Scanner sc = new Scanner(System.in);
    	int studentCount = 10;
    	int[] studentExams = new int[studentCount];
    	
    	for(int i = 0; i < studentCount; i++) 
    	{
    		System.out.print("반 학생들의 시험성적을 입력해주세요 : ");
    		studentExams[i] = sc.nextInt();
    	}
    	
    	sc.close();
    	
    	float sum = 0f;
    	int examGreaterCount = 0;
    	for(int i = 0; i < studentCount; i++) 
    	{
    		sum += studentExams[i];
    		
    		if (60 <= studentExams[i]) 
    		{
    			System.out.println("합격자의 점수 : " + studentExams[i] + "점");
    		}
    		
    		if (90 <= studentExams[i]) 
    		{
    			examGreaterCount++;
    		}
    	}
    	
    	System.out.println("우리반의 평균점수 : " + (sum / studentCount) + "점");
    	System.out.println("우리반에서 성적우수자들의 인원수는 " + examGreaterCount + "명입니다.");
    }
}
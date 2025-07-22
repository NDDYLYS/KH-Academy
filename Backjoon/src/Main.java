import java.util.Scanner;

public class Main 
{
        public static void main(String[] args) 
        {
    		Scanner sc = new Scanner(System.in);
    	
    		int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            sc.close();

            int result = lcm(num1, num2);

            System.out.println(result);
        }
    }
}

public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// 최소 공배수 구하는 함수
public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
}
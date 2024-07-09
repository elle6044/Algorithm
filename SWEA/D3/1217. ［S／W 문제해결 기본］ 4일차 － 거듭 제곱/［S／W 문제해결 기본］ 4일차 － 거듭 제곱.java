import java.util.Scanner;

public class Solution {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		for(int t=1;t<=10;t++) {
			int k=sc.nextInt();
			
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			System.out.print("#"+t+" ");
			getNum(a,a,b);
		}

	}

	static void getNum(int num, int a, int b) {
		if(b==1) {
			System.out.println(num);
			return;
		}
		
		getNum(num*a,a,b-1);
	}
}

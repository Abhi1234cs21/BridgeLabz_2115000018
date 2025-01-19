import java.util.Scanner;
public class Power_Cal{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base number : ");
		int base = sc.nextInt();
		System.out.print("Enter the exponent number : ");
		int expo = sc.nextInt();
		double res = Math.pow(base,expo);
		System.out.println("Result : "+res);
	}
}
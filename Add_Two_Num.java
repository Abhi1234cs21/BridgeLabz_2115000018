import java.util.Scanner;
public class Add_Two_Num{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a+b;
		System.out.println("Sum:"+sum);
	}
}
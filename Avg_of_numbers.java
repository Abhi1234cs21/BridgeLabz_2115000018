import java.util.Scanner;
public class Avg_of_numbers{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 3 Numbers : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		double avg = (a+b+c)/3;
		System.out.println("The Average of 3 Numbers are : "+avg);
	}
}

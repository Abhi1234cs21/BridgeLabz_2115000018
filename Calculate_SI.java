import java.util.Scanner;
public class Calculate_SI{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the principal Amount : ");
		int prin = sc.nextInt();
		System.out.print("Enter the rate of interest : ");
		int rate = sc.nextInt();
		System.out.print("Enter the time : ");
		int time = sc.nextInt();
		double SI = (prin*rate*time)/100;
		System.out.print("Calculate Simple Interest : "+SI);
	}
}

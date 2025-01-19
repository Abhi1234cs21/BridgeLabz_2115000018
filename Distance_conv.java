import java.util.Scanner;
public class Distance_conv{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the distance in kilometers : ");
		int km = sc.nextInt();
		double miles = km*0.621371;
		System.out.println("Distance in Miles : "+miles);
	}
}
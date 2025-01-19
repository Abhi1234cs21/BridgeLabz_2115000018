import java.util.Scanner;
public class Area_Circle{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Radius of Circle : ");
		int rad = sc.nextInt();
		double area = Math.pow(rad,2)*3.14;
		System.out.println("Area of Circle : "+area);
	}
}
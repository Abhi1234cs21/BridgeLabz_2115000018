import java.util.Scanner;
public class Volume_Cylinder{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Radius and Height of Cylinder : ");
		int rad = sc.nextInt();
		int height = sc.nextInt();
		double volume = Math.pow(rad,2)*height*3.14;
		System.out.println("Area of Cylinder : "+volume);
	}
}
import java.util.Scanner;
public class Peri_Rec{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Length and Width of Rectangle : ");
		int len = sc.nextInt();
		int width = sc.nextInt();
		int peri = 2*(len+width);
		System.out.println("Perimeter of Rectangle: "+peri);
	}
}
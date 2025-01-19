import java.util.Scanner;
public class Temp_Conversion{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the temperature in Celcius : ");
		int cel = sc.nextInt();
		double fahr = (cel*1.8)+32;
		System.out.println("Temperature in Fahrenheit : "+fahr);
	}
}
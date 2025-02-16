import java.util.*;

class ReverseUsingStringBuilder{
	
	public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the String : ");
		String input = sc.nextLine(); // Taking the input as String
		
		System.out.println("Reverse String : "+reverseString(input));
	}
}
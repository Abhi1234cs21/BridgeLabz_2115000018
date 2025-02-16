import java.util.*;

class ConcatenateStrings{

	public static String concatenateStrings(String[] input){
	
		StringBuffer sb = new StringBuffer();
		
		for (String word : input) {
            sb.append(word);
        }

        return sb.toString();
	
	}

	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. of Strings : ");
		int n = sc.nextInt();
		
		String[] input = new String[n];
		
		System.out.println("Enter the strings:");
		for(int i=0;i<n;i++){
			input[i]=sc.nextLine();
			
		}
		
		System.out.println("Concatenate Strings are : "+concatenateStrings(input));
		
	}

}
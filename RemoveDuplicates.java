import java.util.*;

class RemoveDuplicates{
	
	public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
		
		HashSet<Character> hs = new HashSet<>();

		for(char ch : input.toCharArray()){
			if(!hs.contains(ch)){
				hs.add(ch);
				sb.append(ch);
			}
		}
		
		return sb.toString();
        
    }
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the String : ");
		String input = sc.nextLine();
		
		System.out.println("String After Remove Duplicates : "+removeDuplicates(input));
		
	}
}
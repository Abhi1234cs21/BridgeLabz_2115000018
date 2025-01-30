public class RemoveDuplicates {
    public static String removeDuplicateCharacters(String str) {
        String result = "";
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
           
            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "programming";
        String output = removeDuplicateCharacters(input);
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + output);
    }
}

public class WordReplace {
    public static String replaceWord(String sentence, String target, String replacement) {
        return sentence.replace(target, replacement);
    }

    public static void main(String[] args) {
        String sentence = "I love programming in Java.";
        String target = "Java";
        String replacement = "Python";
        String result = replaceWord(sentence, target, replacement);
        System.out.println(result);
    }
}

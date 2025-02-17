public class StringConcatenationComparison {
    public static void main(String[] args) {
        int N = 1_000_000;
        
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) / 1e6 + " ms");
        
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) / 1e6 + " ms");
        
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
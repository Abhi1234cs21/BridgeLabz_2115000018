import java.io.*;

public class LargeFileReadingComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        
        try {
            long startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            while (fileReader.read() != -1) {}
            fileReader.close();
            long endTime = System.nanoTime();
            System.out.println("FileReader reading time: " + (endTime - startTime) / 1e6 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            long startTime = System.nanoTime();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            while (inputStreamReader.read() != -1) {}
            inputStreamReader.close();
            long endTime = System.nanoTime();
            System.out.println("InputStreamReader reading time: " + (endTime - startTime) / 1e6 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
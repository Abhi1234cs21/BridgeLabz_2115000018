import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destinationFile = "copy_largefile.dat";
        
        long startTime, endTime;
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            startTime = System.nanoTime();
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered stream time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            System.out.println("Buffered stream time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
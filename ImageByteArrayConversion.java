import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "copy.jpg";

        try {
            byte[] imageBytes = Files.readAllBytes(new File(sourceImage).toPath());
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            int data;
            while ((data = bais.read()) != -1) {
                baos.write(data);
            }
            
            Files.write(new File(destinationImage).toPath(), baos.toByteArray());
            System.out.println("Image copied successfully.");
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
}

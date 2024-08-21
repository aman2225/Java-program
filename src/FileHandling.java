import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FileHandling {
    public static void main(String[] args) {


        try {

            String sourceFile = "C:\\Users\\amank\\Java program\\src\\source.txt";
            String destinationFile = "C:\\Users\\amank\\Java program\\src\\destination.txt";

            FileReader fileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(destinationFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Add a new line after each line
            }

            // Close resources
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while copying the file: " + e.getMessage());
        }
    }
}

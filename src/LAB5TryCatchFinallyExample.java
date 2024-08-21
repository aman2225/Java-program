import java.util.Scanner;

public class LAB5TryCatchFinallyExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            String input = scanner.nextLine();

            // Attempting to convert the string to an integer
            int number = Integer.parseInt(input);

            // Displaying the result if successful
            System.out.println("You entered: " + number);
        } catch (NumberFormatException ex) {
            // Catching NumberFormatException if the input is not a valid integer
            System.err.println("Error: Please enter a valid integer.");
        } finally {
            // Closing any resources or performing cleanup
            System.out.println("Finally block executed, regardless of the outcome.");
            scanner.close();  // Closing the scanner in the finally block
        }
    }
}


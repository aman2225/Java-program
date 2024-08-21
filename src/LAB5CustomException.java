// Custom exception class
class LAB5CustomException extends Exception {
    public LAB5CustomException(String message) {
        super(message);
    }
}

class CustomExceptionExample {
    // Method that throws the custom exception
    private static void performOperation(int value) throws LAB5CustomException {
        if (value < 0) {
            throw new LAB5CustomException("Value cannot be negative");
        }
        System.out.println("Operation successful! Value: " + value);
    }

    public static void main(String[] args) {
        try {
            // Calling the method that may throw the custom exception
            performOperation(-10);

            // Uncomment the line below to test the exception case
            // performOperation(-5);
        } catch (LAB5CustomException e) {
            // Catching the custom exception and printing the error message
            System.err.println("LAB5CustomException: " + e.getMessage());
        }
    }
}





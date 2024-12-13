public class UncommonBug {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;

        try {
            int z = x / y; // Potential ArithmeticException
            System.out.println(z);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
            // Re-throwing the exception with additional context
            throw new RuntimeException("An error occurred during division:", e);
        } finally {
            System.out.println("Finally block executed");
            // Incorrect approach: Trying to modify x after exception
            // x = 20; //This will not change the x used before exception
        }
    }
}
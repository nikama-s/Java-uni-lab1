import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the upper limit n (>= 1): ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }

            double input = scanner.nextDouble();
            if (input < 1) {
                System.out.println("Number must be greater than or equal to 1.");
                return;
            }

            int n = (int) Math.floor(input);

            System.out.println("Perfect numbers up to " + n + ":");
            boolean found = false;
            for (int i = 1; i <= n; i++) {
                if (isPerfect(i)) {
                    System.out.println(i);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("None found.");
            }
        }
    }

    public static boolean isPerfect(int number) {
    int sum = 1;
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            sum += i;
            int pair = number / i;
            if (pair != i) sum += pair;
        }
    }
    return number != 1 && sum == number;
}
}

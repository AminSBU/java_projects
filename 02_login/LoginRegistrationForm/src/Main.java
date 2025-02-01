import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to Application ...");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Welcome to Login Registration Form ...");
                System.out.println("Please enter your username: ");
                String username = scanner.next();
                System.out.println("Please enter your password: ");
                String password = scanner.next();
                break;

            case 2:
                System.out.println("Welcome to Sign Up ...");
                System.out.println("Please enter your username: ");
                System.out.println("Please enter your password: ");
                System.out.println("Please enter your email: ");
                String email = scanner.next();
                break;

            case 3:
                System.exit(0);

            break;

            default:
                System.out.println("Invalid choice");
                break;

        }
    }
}
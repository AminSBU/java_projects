import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String username = "admin";
        String password = "admin";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String user = sc.nextLine();

        System.out.print("Enter your password: ");
        String pass = sc.nextLine();

        if(user.equals(user) && pass.equals(password)) {
            System.out.println("You are logged in!");
        }
        else {
            System.out.println("You are not logged in!");
        }
    }
}
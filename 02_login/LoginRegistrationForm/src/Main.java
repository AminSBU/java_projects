import java.util.Scanner;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    // Corrected JDBC URL
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useSSL=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1990308902@Omid88";

    public static void main(String[] args) {
        System.out.println("Welcome to Application ...");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after nextInt()

        switch (choice) {
            case 1:
                loginUser(scanner);
                break;

            case 2:
                signUpUser(scanner);
                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void loginUser(Scanner scanner) {
        System.out.println("Welcome to Login Registration Form ...");
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, hashPassword(password)); // Hash the password before comparing

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void signUpUser(Scanner scanner) {
        System.out.println("Welcome to Sign Up ...");
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO users (username, password_hash, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, hashPassword(password)); // Hash the password before storing
            pstmt.setString(3, email);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
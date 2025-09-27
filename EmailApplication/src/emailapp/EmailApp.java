package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        Email email = new Email(firstName, lastName);

        int choice;
        do {
            System.out.println("\n=== Email Management System ===");
            System.out.println("1. Show Info");
            System.out.println("2. Change Password");
            System.out.println("3. Set Alternate Email");
            System.out.println("4. Set Mailbox Capacity");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println(email);
                    break;
                case 2:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    email.changePassword(newPassword);
                    System.out.println("Password updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter alternate email: ");
                    String altEmail = scanner.nextLine();
                    email.setAlternateEmail(altEmail);
                    System.out.println("Alternate email set successfully.");
                    break;
                case 4:
                    System.out.print("Enter new mailbox capacity (MB): ");
                    int capacity = scanner.nextInt();
                    email.setMailboxCapacity(capacity);
                    System.out.println("Mailbox capacity updated.");
                    break;
                case 5:
                    System.out.println("Exiting Email Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

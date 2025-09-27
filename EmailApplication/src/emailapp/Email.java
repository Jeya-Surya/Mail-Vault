package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private int mailboxCapacity = 500;
    private final int defaultPasswordLength = 10;
    private String companySuffix = "xyzcompany.com";



    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        this.department = setDepartment();


        this.password = randomPassword(defaultPasswordLength);


        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() +
                "@" + department.toLowerCase() + "." + companySuffix;
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1: return "sales";
            case 2: return "dev";
            case 3: return "acct";
            default: return "general";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "=== Employee Email Information ===" +
                "\nName           : " + firstName + " " + lastName +
                "\nDepartment     : " + department +
                "\nCompany Email  : " + email +
                "\nPassword       : " + password +
                "\nMailbox Size   : " + mailboxCapacity + "MB" +
                "\nAlternate Email: " + (alternateEmail != null ? alternateEmail : "Not Set");

    }
}

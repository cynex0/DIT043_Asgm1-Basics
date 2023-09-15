import java.util.Scanner;

public class IOScanner {
    public static Scanner scanner = new Scanner(System.in); // create a global scanner for use in all functions

    public static int readInt(String prompt) {
        // prompts the user to enter an int and returns it
        System.out.print(prompt);
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public static String readString(String prompt){
        // prompts the user to enter a string and returns it
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void finish(String msg) {
        // closes the scanner and prints a goodbye message
        scanner.close();
        System.out.println(msg);
    }
}

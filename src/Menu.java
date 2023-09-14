import java.util.Scanner;
import java.util.Locale;

public class Menu {
    final static int MAX_STUDENTS = 7;
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner menu_scanner = new Scanner(System.in);
        // Task 1
        int[] scores = readScores();
        int choice;
        boolean running = true;

        while(running){
            printMenu();
            choice = menu_scanner.nextInt();
            menu_scanner.nextLine();
            switch (choice){
                case 1 -> scores = readScores();
                case 2 -> printScores(scores);
                case 3 -> printMean(scores);
                case 4 -> {
                    printTwoHighestScores();
                    printTwoLowestScores();
                }
                case 5 -> printHighestAndPos(scores);
                case 6 -> printHashtags();
                case 7 -> running = false;
                default -> System.out.println("Error - Invalid value. Please type between 1 and 7");
            }
        }
        menu_scanner.close();
        System.out.println("Thank you for using our grading system. Have a nice day!");
    }

    public static String getOrdinalIndicator(int n){
        switch (n){
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th"; // non-special case (not 1, 2 or 3)
        }
    }

    public static int[] readScores(){
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[MAX_STUDENTS];

        int temp_input;
        for (int i = 0; i < input.length; i++){
            System.out.printf("Enter the score for the %d%s student ", i + 1, getOrdinalIndicator(i + 1));
            temp_input = scanner.nextInt();
            scanner.nextLine();

            if ((temp_input >= 0) && (temp_input <= 100)){
                input[i] = temp_input;
            } else {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
                i--; // decrease the value of the control variable to not skip the i-th element in case of a wrong input
            }
        }

        System.out.print("Thank you for your input. ");
        printScores(input);

        // closing scanner here causes a NoSuchElement exception when reading other inputs later, so closing is omitted
        // scanner.close();
        return input;
    }

    public static void printMenu(){
        System.out.println("Welcome to the menu. Choose one of the options below:\n" +
                "\t1. Register new scores for students.\n" +
                "\t2. Print all registered grades.\n" +
                "\t3. Calculate the mean of the entered scores.\n" +
                "\t4. Find the two highest and two lowest scores.\n" +
                "\t5. Find the highest score and its position.\n" +
                "\t6. Collect hashtags from a post.\n" +
                "\t7. To exit.\n\n" +
                "Type your option: ");
    }

    public static void printScores(int[] scores){
        String output = ""; // string to be outputted at the end of the function
        System.out.println("Your entered scores are:");

        for (int i = 0; i < scores.length; i++) {
            output += scores[i]; // add a score to the output
            if (i != (scores.length - 1)){
                output += ", "; // if not last score, add a comma and a space
            }
        }

        System.out.println(output);
    }

    public static void printMean(int[] scores) {
        double sum = 0.0f;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.printf("The mean is:  %.2f", (sum / scores.length));
    }

    public static void printTwoHighestScores(){

    }
    public static void printTwoLowestScores(){

    }

    public static void printHighestAndPos(int[]scores){
        int highestScore = 0;
        int position = 0;

        for (int i = 0; i < scores.length; i++){
            if (scores[i] > highestScore){
                highestScore = scores[i];
                position = i + 1;
            }
        }

        System.out.println("The highest score is " + highestScore + " and belongs to the " + position +
                getOrdinalIndicator(position) + " student");
    }

    public static String readPost(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your post: ");
        String post = scanner.nextLine();

//        scanner.close();
        return post;
    }

    public static String[] extractHashtags(String input){
        String[] words = input.split(" ");
        String[] hashtags = new String[words.length]; // max possible hashtags = length of post (if all hashtags)
        int hashtag_i = 0; // counter for hashtag array

        for (int i = 0; i < words.length; i++){
            if (words[i].startsWith("#")){
                // put each hashtag into an array, starting from 0, in the same order
                hashtags[hashtag_i] = words[i];
                hashtag_i++; // increase index
            }
        }
        // returns array of the same length as the post, hashtags in order, then empty strings
        return hashtags;
    }

    public static void printHashtags(){
        String post = readPost();
        String[] hashtags = extractHashtags(post);

        if (hashtags[0] != null){ // if has at least 1 hashtag
            System.out.print("Hashtags found:"); // no space to allow easy printing of elements

            // loop until an empty element, array can have empty elements if less hashtags than words
            for (int i = 0; i < hashtags.length; i++){
                if (hashtags[i] != null){
                    System.out.printf(" %s", hashtags[i]); // if not empty, print
                } else {
                    break; // else stop loop (only empty strings after the tags in the array)
                }
            }
            System.out.println();
        }
        else {
            System.out.println("No hashtags were typed.");
        }
    }
}

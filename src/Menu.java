import java.util.Locale;

public class Menu {
    final static int MAX_STUDENTS = 7;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        int[] scores = readScores();
        int choice;
        boolean running = true;

        while(running){
            printMenu();
            choice = IOScanner.readInt("Type your option: ");
            switch (choice){
                case 1 -> scores = readScores();
                case 2 -> printScores(scores);
                case 3 -> printMean(scores);
                case 4 -> {
                    printTwoLowestScores(scores);
                    printTwoHighestScores(scores);
                }
                case 5 -> printHighestAndPos(scores);
                case 6 -> printHashtags();
                case 7 -> running = false;
                default -> System.out.println("Error - Invalid value. Please type between 1 and 7");
            }
        }

        IOScanner.finish("Thank you for using our grading system. Have a nice day!");
    }

    public static int[] readScores(){
        int[] input = new int[MAX_STUDENTS];

        int temp_input;
        for (int i = 0; i < input.length; i++){
            temp_input = IOScanner.readInt("Enter the score for the " + (i + 1) + getOrdinalIndicator(i + 1)
                                            + " student ");

            if ((temp_input >= 0) && (temp_input <= 100)){
                input[i] = temp_input;
            } else {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
                i--; // decrease the value of the control variable to not skip the i-th element in case of a wrong input
            }
        }

        System.out.print("Thank you for your input. ");
        Menu.printScores(input);

        return input;
    }

    public static String getOrdinalIndicator(int n){
        switch (n){
            // using ":" instead of "->" because returns wouldn't work w/ arrows
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

    public static void printMenu(){
        System.out.print("Welcome to the menu. Choose one of the options below:\n" +
                "1. Register new scores for students.\n" +
                "2. Print all registered grades.\n" +
                "3. Calculate the mean of the entered scores.\n" +
                "4. Find the two highest and two lowest scores.\n" +
                "5. Find the highest score and its position.\n" +
                "6. Collect hashtags from a post.\n" +
                "7. To exit.\n\n");
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
            sum = sum + scores[i];
        }

        System.out.printf("The mean of the numbers is %.2f%n", (sum / scores.length));
    }

    public static void printTwoHighestScores(int[]scores){
        int highestScore = 0;
        int secondHighestScore = 0; // set to 0 as it is the lowest possible score

        for (int i = 0; i < scores.length; i++){
            if (scores[i] >= highestScore){
                secondHighestScore = highestScore;
                highestScore = scores[i];
            } else if (scores[i] > secondHighestScore) { // if a new second highest after the highest
                secondHighestScore = scores[i];
            }
        }
  
        System.out.printf("The two highest scores provided are %d, and %d%n", highestScore, secondHighestScore);

    }
  
    public static void printTwoLowestScores(int []scores){
        int lowestScore = 100;
        int secondLowestScore = 100; // set to 100 as it is the highest possible score

        for (int i = 0; i < scores.length; i++){
            if (scores[i] <= lowestScore){
                secondLowestScore = lowestScore;
                lowestScore = scores[i];
            } else if (scores [i] < secondLowestScore) {
                secondLowestScore = scores[i];
            }
        }

        System.out.printf("The two lowest scores provided are %d, and %d%n", lowestScore,secondLowestScore);
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

    public static String[] extractHashtags(String[] words){
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
        String[] postWords = IOScanner.readWordArray("Type your post: ");
        String[] hashtags = extractHashtags(postWords);

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

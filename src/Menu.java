import java.util.Scanner;

public class Menu {
    final static int MAX_STUDENTS = 7;
    public static void main(String[] args) {
        // Task 1
        int[] scores;
        scores = readScores();
        // Task 2
//        printScores(scores);
        // Task 3
        printMean();
        // Task 4
        printTwoHighestScores();
        printTwoLowestScores();
        // Task 5
        printHighestAndPos(scores);
        // Task 6
        printHashtags();
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

        scanner.close();
        return input;
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

    public static void printMean(){

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

        } System.out.println("The highest score is " + highestScore + " and belongs to the " + position + getOrdinalIndicator(position)
                + " student");
    }

    public static void printHashtags(){

    }
}

import java.util.Scanner;
import java.util.Locale;

public class Menu {
    public static void main(String[] args) {
        // Task 1
        Locale.setDefault(Locale.ENGLISH);
        int[] scores;
        scores = readScores();
        // Task 2
//        printScores(scores);
        // Task 3
        printMean(scores);
        // Task 4
        printTwoHighestScores();
        printTwoLowestScores();
        // Task 5
        printHighestAndPos();
        // Task 6
        printHashtags();
    }
    public static int[] readScores(){
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[7];

        int temp_input;
        for (int i = 0; i < input.length; i++){
            System.out.printf("Enter the score for the %d%s student ", i + 1, "th");
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
        System.out.println("Your entered scores are:");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d, ", scores[i]);
        }
        System.out.println();
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

    public static void printHighestAndPos(){

    }

    public static void printHashtags(){

    }
}

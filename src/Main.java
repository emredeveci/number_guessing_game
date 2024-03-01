import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);
//        double number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int attempt = 0;
        int guess;
        int[] wrongGuesses = new int[5];
        boolean isWin = false;

        while (attempt < 5) {
            System.out.println("Make a guess: ");
            guess = input.nextInt();

            if (guess < 0 || guess > 100) {
                System.out.println("Please enter a number between 0 and 100");
                continue;
            }

            if (guess == number) {
                System.out.println("Congratulations! You guessed the number correctly: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Your guess is incorrect.");
                if (guess > number) {
                    System.out.println("Your guess " + guess + " is higher than the secret number.");
                } else {
                    System.out.println("Your guess " + guess + " is lower than the secret number.");
                }
                wrongGuesses[attempt] = guess;
                attempt++;
                System.out.println("You have " + (5 - attempt) + " attempts remaining.");
            }
        }
        if (!isWin) {
            System.out.println("You lost.");
            System.out.println("Your guesses were: " + Arrays.toString(wrongGuesses));
        }
    }
}
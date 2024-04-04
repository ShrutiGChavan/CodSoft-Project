import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5; // Limiting the attempts
        int score = 0; // Score to count the rounds won

        System.out.println("Welcome to the Number Guessing Game!");

        // Game loop
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Guess it!");
            int attempts = 0;

            // Guessing loop
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNumber);
                    break;
                }
            }

            // Prompt to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over. Your score is: " + score);
        scanner.close();
    }
}


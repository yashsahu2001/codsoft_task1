package org.codsoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int totalRounds = 0;
        int totalScore = 0;

        do {
            playAgain = false;
            int attempts = playGame(scanner);
            totalRounds++;
            totalScore += (MAX_ATTEMPTS - attempts) + 1;
            
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next().toLowerCase();
            if (response.equals("yes")) {
                playAgain = true;
            }
        } while (playAgain);

        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ":");

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess (" + (MAX_ATTEMPTS - attempts) + " attempts left): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low!");
            } else if (guess > targetNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all attempts. The correct number was " + targetNumber + ".");
        }

        return attempts;
    }
}
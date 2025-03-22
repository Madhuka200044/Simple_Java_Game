import java.util.Scanner;
import java.util.Random;

public class Games 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("\nWelcome to the Simple Games!");
            System.out.println("Choose a game to play:");
            System.out.println("1. Guess the Number");
            System.out.println("2. Rock, Paper, Scissors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            int gameChoice = scanner.nextInt();

            switch (gameChoice) {
                case 1:
                    playGuessTheNumber();
                    break;
                case 2:
                    playRockPaperScissors();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for playing! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Guess the Number Game
    public static void playGuessTheNumber() 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int numberOfTries = 0;
        int guess;
        boolean hasGuessedCorrectly = false;

        System.out.println("\nWelcome to Guess the Number!");
        System.out.println("I have selected a number between 1 and 100. Can you guess what it is?");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
            }
        }
    }

    // Rock, Paper, Scissors Game
    public static void playRockPaperScissors() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nWelcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice: (1 = Rock, 2 = Paper, 3 = Scissors)");

        int playerChoice = scanner.nextInt();
        int computerChoice = random.nextInt(3) + 1; // Random number between 1 and 3

        // Display player and computer choices
        System.out.println("You chose: " + getChoiceName(playerChoice));
        System.out.println("Computer chose: " + getChoiceName(computerChoice));

        // Determine the winner
        if (playerChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if ((playerChoice == 1 && computerChoice == 3) ||
                   (playerChoice == 2 && computerChoice == 1) ||
                   (playerChoice == 3 && computerChoice == 2)) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }

    // Helper method to convert choice number to name
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid Choice";
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class Hangman {
    static int numberOfWrongGuesses = 0;
    public static void main(String[] args) {
        Scanner readerObj = null;
        List<String> words = new ArrayList<>();

        // Reading word bank file and adding the words to
        // an array list
        try {
            readerObj = new Scanner(new File("src/wordbank.txt"));
            while (readerObj.hasNextLine()) {
                words.add(readerObj.next());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            assert readerObj != null;
            readerObj.close();
        }


        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        List<Character> guesses = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        while(true) {

            GameDisplayAssets.displayHangingMan(numberOfWrongGuesses);
            displayWordProgress(word, guesses);

            // Keeping track of the guesses the player makes so that they are
            // sure not to duplicate
            System.out.println("\nLetters Guessed: " + guesses);

            // Checking to see if limit of incorrect guesses has been met
            // If true - game is over and player has lost
            if(numberOfWrongGuesses >= 6) {
                System.out.println("Game over! :(  The correct word was: " + word);
                break;
            }

            getGuessesOfPlayer(input,word, guesses);

            // Checking to see if return value from method is true
            // If true - game is over and player has won
            if(displayWordProgress(word, guesses)) {
                System.out.println("Winner!");
                break;
            }
        }
    }

    /*
    Method for getting the guesses of the player.
    Player is prompted to enter a letter to guess the word.
    That guess is added to a list of guesses to keep track / add the guess to the word.
    If the character guessed by the player is not in the word, it is flagged as an
    incorrect guess and the player is prompted to make another attempt.
     */
    public static void getGuessesOfPlayer(Scanner input, String word, List<Character> guesses) {
        System.out.println("\nEnter a letter!");
        String letterGuessedByPlayer = input.next();
        guesses.add(letterGuessedByPlayer.charAt(0));

        if(!word.contains(letterGuessedByPlayer)){
            System.out.println("Sorry! That guess wasn't right. Try again.\n");
            System.out.println("Wrong guesses: " + numberOfWrongGuesses);
            numberOfWrongGuesses += 1;
        }
    }

    /*
    Boolean method for checking / displaying the state of the word being guessed.
    If the return value evaluates to true, the game is over and the player has won the game.
    Playing loop only ends if this condition is met / or if the limit of six incorrect guesses has been met.
     */
    public static boolean displayWordProgress(String word, List<Character> guesses) {
        int numberOfCorrectGuesses  = 0;
        for(int i = 0; i < word.length(); i++) {
            if(guesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                numberOfCorrectGuesses++;
            }
            else {
                System.out.print(" - ");
            }
        }
        System.out.println();
        return word.length() == numberOfCorrectGuesses;
    }
}
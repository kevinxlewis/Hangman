import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class Hangman {

    public static void main(String[] args) {
        Scanner readerObj = null;
        List<String> words = new ArrayList<>();
        try {
            readerObj = new Scanner(new File("src/wordbank.txt"));
            while (readerObj.hasNextLine()) {
                words.add(readerObj.next());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            assert readerObj != null;
            readerObj.close();
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        List<Character> guesses = new ArrayList<>();
        int numberOfWrongGuesses = 0;
        Scanner input = new Scanner(System.in);
        AudioAssets audioAssets = new AudioAssets();

        System.out.println("Welcome to Hangman!");
        while(true) {

            GameDisplayAssets.displayHangingMan(numberOfWrongGuesses);
            if(numberOfWrongGuesses >= 6) {
                System.out.println("Game over!\tThe correct word was: " + word);
                break;
            }
            displayWordProgress(word, guesses);
            if(!getGuessesOfPlayer(input, word, guesses)) {
                numberOfWrongGuesses++;
                System.out.println("Sorry! That guess wasn't right. Try again.\n");
                System.out.println("Wrong guesses: " + numberOfWrongGuesses);
            }
            if(displayWordProgress(word, guesses)) {
                System.out.println("You won! You got the word!");
                break;
            }
        }
    }

    public static boolean getGuessesOfPlayer(Scanner input, String word, List<Character> guesses) {
        System.out.println("\nEnter a letter!");
        String letterGuessedByPlayer = input.next();
        guesses.add(letterGuessedByPlayer.charAt(0));

        return word.contains(letterGuessedByPlayer);
    }

    public static boolean displayWordProgress(String word, List<Character> guesses) {
        int numberOfCorrectGuesses  = 0;
        for(int i = 0; i < word.length(); i++) {
            if(guesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                numberOfCorrectGuesses++;
            } else {
                System.out.print(" - ");

            }
        }
        System.out.println();
        return (word.length() == numberOfCorrectGuesses);
    }
}
public class GameDisplayAssets {
    public static void displayHangingMan(Integer numberOfWrongGuesses) {
        // Displaying the post that the man will be hanging from related
        // to the amount of times a player has an incorrect guess.
        System.out.println(" _________ ");
        System.out.println(" |       |");

        if(numberOfWrongGuesses >= 1) {
            System.out.println(" O");
        }
        if(numberOfWrongGuesses >= 2) {
            System.out.print("\\ ");
            if(numberOfWrongGuesses >=3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }
        if(numberOfWrongGuesses >= 4) {
            System.out.println(" |");
        }
        if(numberOfWrongGuesses >= 5) {
            System.out.print("/ ");
            if(numberOfWrongGuesses >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println();
        System.out.println();
    }
}

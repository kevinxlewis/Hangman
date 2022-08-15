public class GameDisplayAssets {
    public static void displayHangingMan(Integer numberOfWrongGuesses) {
        // Displaying the post that the man will be hanging from related
        // to the amount of times a player has an incorrect guess.
        if(numberOfWrongGuesses == 0) {
            System.out.println(" ------------  ");
            System.out.println(" |          |  ");
            System.out.println(" |             ");
            System.out.println(" |             ");
            System.out.println(" |             ");
            System.out.println(" |             ");
        }
        if (numberOfWrongGuesses == 1) {
            System.out.println(" ------------   ");
            System.out.println(" |          |   ");
            System.out.println(" |          0   ");
            System.out.println(" |              ");
            System.out.println(" |              ");
            System.out.println(" |              ");
        }
        if (numberOfWrongGuesses == 2) {
            System.out.println(" ------------    ");
            System.out.println(" |          |    ");
            System.out.println(" |          0    ");
            System.out.println(" |        \\     ");
            System.out.println(" |               ");
            System.out.println(" |               ");
        }
        if (numberOfWrongGuesses == 3) {
            System.out.println(" ------------    ");
            System.out.println(" |          |    ");
            System.out.println(" |          0    ");
            System.out.println(" |         \\|   ");
            System.out.println(" |               ");
            System.out.println(" |               ");
        }
        if (numberOfWrongGuesses == 4) {
            System.out.println(" ------------    ");
            System.out.println(" |          |    ");
            System.out.println(" |          0    ");
            System.out.println(" |         \\|/  ");
            System.out.println(" |               ");
            System.out.println(" |               ");
        }
        if (numberOfWrongGuesses == 5) {
            System.out.println(" ------------    ");
            System.out.println(" |          |    ");
            System.out.println(" |          0    ");
            System.out.println(" |         \\|/  ");
            System.out.println(" |         /     ");
            System.out.println(" |               ");
        }
        if (numberOfWrongGuesses == 6) {
            System.out.println(" ------------    ");
            System.out.println(" |          |    ");
            System.out.println(" |          0    ");
            System.out.println(" |         \\|/  ");
            System.out.println(" |         / \\  ");
            System.out.println(" |               ");
        }
        System.out.println();
        System.out.println();
    }
}

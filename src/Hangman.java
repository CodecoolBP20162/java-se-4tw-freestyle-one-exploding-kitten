import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by noncsi on 2017.05.24..
 */
public class Hangman {

    LinkedList wordPair;
    String blankLines;
    String word;
    String definition;
    String userInput;
    Integer lives;

    public Hangman() {
        GetRandomWordPair word = new GetRandomWordPair();
        this.wordPair = word.getRandomWord();
        this.word = this.wordPair.get(0).toString();
        this.definition = this.wordPair.get(1).toString();
        this.blankLines = this.word;
        this.lives = 5;
    }

    public void turnWordToBlankLines() {
        for (int i = 1; i < blankLines.length() - 1; i++) {
            if (blankLines.charAt(i) == ' ') { // ignore whitespace
                continue;
            }
            blankLines = blankLines.replace(blankLines.charAt(i), '_');
        }
    }

    public String askInput() {
        Scanner input = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a letter: ");
        userInput = input.next();
        if (userInput.length() > 1 || checkIfInputIsInteger(userInput)) {
            System.out.println("That's not a letter");
            askInput();
        }
        return userInput;
    }

    private boolean checkIfInputIsInteger(String input) {
        try {
            int isNumber = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void Game() {
        turnWordToBlankLines();
        System.out.println(blankLines);
        String userInput = askInput();
        for (int i = 0; i < blankLines.length(); i++) {
            if(userInput.charAt(0) == word.charAt(0)) {
            }
        }
    }
}

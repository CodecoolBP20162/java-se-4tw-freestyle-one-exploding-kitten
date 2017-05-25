package com.codecool.noncsi_hangman;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * Created by noncsi on 2017.05.24..
 */
public class Hangman {

    private static final Logger LOGGER = Logger.getLogger( Hangman.class.getName() );

    public LinkedList wordPair;
    public String blankLines;
    public String word;
    public String definition;
    public Integer lives;


    public static void main(String[] args) {
        Hangman hangman = new Hangman(5);
        hangman.Game();
    }

    /**
     * Constructor
     */
    public Hangman(int lives) {
        GetRandomWordPair word = new GetRandomWordPair();
        this.wordPair = word.GetRandomWord();
        this.word = this.wordPair.get(0).toString();
        this.definition = this.wordPair.get(1).toString();
        this.blankLines = this.word;
        this.lives = lives;
    }

    /**
     * Makes blank lines from the word, to make is classified
     */
    public String turnWordToBlankLines() {
        for (int i = 1; i < blankLines.length() - 1; i++) {
            if (blankLines.charAt(i) == ' ') { // ignore whitespace
                continue;
            }
            blankLines = blankLines.replace(blankLines.charAt(i), '_');
        }
        return blankLines;
    }

    /**
     * Ask a letter from the user
     */
    public String askInput() {
        System.out.println("Enter a letter: ");
        Scanner input = new Scanner(System.in);  // Reading from System.in
        String userInput = input.next();
        LOGGER.info("userInput = " + userInput);
        if (userInput.length() > 1 || checkIfInputIsInteger(userInput)) {
            System.out.println("That's not a letter");
            askInput();
        }
        return userInput;
    }

    /**
     * The input must be only a letter
     */
    private boolean checkIfInputIsInteger(String input) {
        try {
            int isNumber = Integer.parseInt(input);
            LOGGER.info("Method found an Integer");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * In case of lose, the user get the word
     */
    public void Lose() {
        System.out.println("#####################");
        System.out.println("GAME OVER");
        System.out.println("The word is: " + word);
        System.out.println("#####################");
    }

    /**
     * In case of win, the user get the definition as a reward
     */
    public void Win() {
        System.out.println("#####################");
        System.out.println("CONGRATULATIONS");
        System.out.println(definition);
        System.out.println("#####################");
    }

    /**
     * This is the soul of the game
     * We have to check if the user already tried a letter
     * We have to inform them about the number of lives
     * Checks the place of the letter and replaces the blank line with the letter
     * All of this until the player win or lose
     */
    public void Game() {
        turnWordToBlankLines();
        Stack alreadyGuessedLetters = new Stack();
        // while we have lives and we haven't guessed the word
        while (lives > 0 && blankLines.contains("_")) {
            System.out.println(lives + " lives left");
            System.out.println(blankLines);
            String userInput = askInput();
            if (alreadyGuessedLetters.contains(userInput)) {
                System.out.println("You already tried that");
                continue;
            } else {
                alreadyGuessedLetters.push(userInput);
                LOGGER.info("Guessed letter added to database");
                if (word.toLowerCase().contains(userInput.toLowerCase())) {
                    for (int i = 0; i < blankLines.length(); i++) {
                        if (userInput.charAt(0) == word.charAt(i)) {
                            LOGGER.info("Letter is found in word");
                            // this was sooooo easy in Python :c
                            blankLines = blankLines.substring(0,i) + userInput.charAt(0) + blankLines.substring(i+1, blankLines.length());
                        }
                    }
                } else {
                    lives--; // if we haven't guessed the right letter, lose a life
                    if(lives == 1) {
                        LOGGER.warning("!!! You have only 1 life left !!!");
                    }
                }
            }
        }
        if (lives == 0) {
            Lose();
        } else {
            Win();
        }

    }
}

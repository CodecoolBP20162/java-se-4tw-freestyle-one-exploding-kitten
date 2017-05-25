import com.codecool.noncsi_hangman.Hangman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by noncsi on 2017.05.25..
 */
class HangmanTest {

    @Test
    void testIsBlankLinesLengthEqualWithWordLength() {
        Hangman hangman = new Hangman(5);
        assertEquals(hangman.word.length(), hangman.blankLines.length());
    }

    @Test
    void testIsWordIsNotDefinition() {
        Hangman hangman = new Hangman(5);
        assertNotEquals(hangman.word, hangman.definition);
    }

    @Test
    void testIsBlankLinesAreTrulyLines() {
        Hangman hangman = new Hangman(5);
        String lines = hangman.turnWordToBlankLines();
        assertEquals(true, lines.contains("_"));
    }
}
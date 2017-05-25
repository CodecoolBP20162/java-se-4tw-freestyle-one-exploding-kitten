import com.codecool.noncsi_hangman.GetRandomWordPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by noncsi on 2017.05.25..
 */
class GetRandomWordPairTest {

    @Test
    void testIsListContainsWordAndDefinitionOnly() {
        GetRandomWordPair wordPair = new GetRandomWordPair();
        assertEquals(2, wordPair.wordAndDefinition.size());
    }
}
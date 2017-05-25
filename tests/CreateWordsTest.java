import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by noncsi on 2017.05.25..
 */
class CreateWordsTest {

    @Test
    void testIsTheFileIsNotEmpty() throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("src/words.txt")));
        assertNotEquals(0, text.length());
    }
}
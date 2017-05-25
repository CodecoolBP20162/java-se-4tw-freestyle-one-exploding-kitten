import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by noncsi on 2017.05.24..
 */
public class GetRandomWordPair {

    public HashMap gettingWord() {
        CreateWords fileReading = new CreateWords("src/words.txt");
        fileReading.readLines();
        HashMap wordsAndDefinitions = fileReading.FillHashMap();
        return wordsAndDefinitions;
    }

    public LinkedList getRandomWord() {
        LinkedList wordAndDefinition = new LinkedList();
        HashMap words = gettingWord();
        Random random = new Random();
        List<String> keys = new ArrayList<String>(words.keySet());
        String randomKey = keys.get( random.nextInt(keys.size()) );
        Object value = words.get(randomKey);
        wordAndDefinition.add(randomKey);
        wordAndDefinition.add(value);
        return wordAndDefinition;
    }

}

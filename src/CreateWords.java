import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by noncsi on 2017.05.23..
 */
public class CreateWords {

    String fileName;

    public CreateWords(String fileName) {
        this.fileName = fileName;
    }

    private String ReadFile() {
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(this.fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public List readLines() {
        String text = ReadFile();
        String lines = null;
        List<String> splitText = Arrays.asList(text.split("#"));
        return splitText;
    }

    public void FillHashMap() {
        List text = readLines();
        HashMap wordsAndDefinitions = new HashMap();
        for(int word = 0; word < text.size()-1; word+=2) {
            int description = word+1;
                wordsAndDefinitions.put(text.get(word), text.get(description));
        }
        System.out.println(wordsAndDefinitions);
    }
}

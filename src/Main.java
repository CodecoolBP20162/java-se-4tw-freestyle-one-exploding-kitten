/**
 * Created by noncsi on 2017.05.23..
 */
public class Main {
    public static void main(String[] args) {
        CreateWords fileReading = new CreateWords("src/words.txt");
        fileReading.readLines();
        fileReading.FillHashMap();
    }
}

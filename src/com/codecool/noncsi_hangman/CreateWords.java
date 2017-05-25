package com.codecool.noncsi_hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by noncsi on 2017.05.23..
 */
public class CreateWords {

    private static final Logger LOGGER = Logger.getLogger( Hangman.class.getName() );

    String fileName;

    /**
     * Constructor
     */
    public CreateWords(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads all the lines from the given file
     */
    private String ReadFile() {
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(this.fileName)));
        } catch (IOException e) {
            LOGGER.warning("Couldn't find the file");
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Splits the lines correctly
     */
    public List readLines() {
        String text = ReadFile();
        LOGGER.info("Founding the file went successfully");
        String lines = null;
        List<String> splitText = Arrays.asList(text.split("#"));
        return splitText;
    }

    /**Matches the words with the definitions.
     * Could have done with simple list,
     * but I wanted to exercise HashMaps*/
    public HashMap FillHashMap() {
        List text = readLines();
        HashMap wordsAndDefinitions = new HashMap();
        for(int word = 0; word < text.size()-1; word+=2) {
            int description = word+1;
                wordsAndDefinitions.put(text.get(word), text.get(description));
        }
        return wordsAndDefinitions;
    }
}

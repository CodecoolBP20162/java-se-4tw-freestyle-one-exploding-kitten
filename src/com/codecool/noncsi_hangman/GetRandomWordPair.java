package com.codecool.noncsi_hangman;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by noncsi on 2017.05.24..
 */
public class GetRandomWordPair {

    private static final Logger LOGGER = Logger.getLogger( Hangman.class.getName() );

    public LinkedList wordAndDefinition = new LinkedList();

    /**
     * Getting the words from the other class
     */
    public HashMap GetWords() {
        CreateWords fileReading = new CreateWords("src/words.txt");
        fileReading.readLines();
        HashMap wordsAndDefinitions = fileReading.FillHashMap();
        LOGGER.info("Got the words and definitions from CreateWords");
        return wordsAndDefinitions;
    }

    /**
     * Choose a random word and the definition which is belong to it
     */
    public LinkedList GetRandomWord() {
        HashMap words = GetWords();
        Random random = new Random();
        List<String> keys = new ArrayList<String>(words.keySet());
        String randomKey = keys.get( random.nextInt(keys.size()) );
        Object value = words.get(randomKey);
        wordAndDefinition.add(randomKey);
        wordAndDefinition.add(value);
        return wordAndDefinition;
    }

}

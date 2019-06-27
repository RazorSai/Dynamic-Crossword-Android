package com.demo.crosswordnewcreate;

import java.util.ArrayList;
import java.util.List;

public class WordElementProviderModel {

    public static List<WordElement> getAllElements(){

        List<WordElement> wordElements = new ArrayList<>();

        WordElement wordElement = new WordElement("Yourself", 2);

        wordElements.add(wordElement);

        WordElement wordElement1 = new WordElement("Success", 11);

        wordElements.add(wordElement1);

        WordElement wordElement2 = new WordElement("Believe", 4);

        wordElements.add(wordElement2);

        WordElement wordElement3 = new WordElement("Himself", 1);

        wordElements.add(wordElement3);

        WordElement wordElement4 = new WordElement("Outfit", 5);

        wordElements.add(wordElement4);

        WordElement wordElement5 = new WordElement("Wealth", 7);

        wordElements.add(wordElement5);

        WordElement wordElement6 = new WordElement("Think", 0);

        wordElements.add(wordElement6);

        WordElement wordElement7 = new WordElement("Power", 3);

        wordElements.add(wordElement7);

        WordElement wordElement8 = new WordElement("Inner", 8);

        wordElements.add(wordElement8);

        WordElement wordElement9 = new WordElement("Faith", 10);

        wordElements.add(wordElement9);

        WordElement wordElement10 = new WordElement("Self", 9);

        wordElements.add(wordElement10);

        WordElement wordElement11 = new WordElement("Life", 6);

        wordElements.add(wordElement11);

        return wordElements;

    }

}

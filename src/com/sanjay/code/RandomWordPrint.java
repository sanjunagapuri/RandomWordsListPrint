package com.sanjay.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
Java program to choose a random word from this list and print it out.
 */

public class RandomWordPrint {


    public static void main(String[] args) {
       /* Picks a random word from the List built from test_words.txt file. */

        System.out.println("Random Word from the given list: " + getRandomWordFromList(readWordsFromFIle("src/resource/words_alpha.txt")));

    }

    public static String getRandomWordFromList(List<String> wordsList) {
        String word ;
        if(wordsList.isEmpty()) {
            return "No words present in the list to print";
        } else {
            //Choose random number between 0 to words List size
            int randNum = new Random().nextInt(wordsList.size());
            return wordsList.get(randNum);
        }

    }


    public static List<String> readWordsFromFIle(String file){

        List<String> wordList = new ArrayList<String>();

        try {
            Scanner scan = new Scanner(new File(file));
            while (scan.hasNextLine()) {
                wordList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found to read the words from");
        }

        return wordList;

    }

}


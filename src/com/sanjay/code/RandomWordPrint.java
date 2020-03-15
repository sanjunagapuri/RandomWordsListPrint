package com.sanjay.code;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
Java program to choose a random word from the given list and print it out.
 */

public class RandomWordPrint {

    private static String FILE_PATH = "src/resource/words_alpha.txt";

    public static void main(String[] args) {
       /* Picks a random word from the List built from words_alpha.txt file. */

        System.out.println("Printing Random Word from the given text file--> " + getRandomWordFromList(readWordsFromFIle(FILE_PATH)));

    }
    /* Method to return a random word from the given words list */
    public static String getRandomWordFromList(List<String> wordsList) {
        if(wordsList.isEmpty()) {
            return "Words List is empty";
        } else {
            //Choose random number between 0 to words List size
            int randNum = new Random().nextInt(wordsList.size());
            return wordsList.get(randNum);
        }

    }

    /* Method to read words from a given file and return the words list*/
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


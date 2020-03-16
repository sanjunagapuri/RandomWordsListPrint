package com.random.code;


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

    private static String FILE_PATH = "src/resource//words_alpha.txt";
    public static final String  FILE_NOT_FOUND = "File Not Found";
    public static final String FILE_IS_EMPTY = "File is Empty";

    public static void main(String[] args) {
       /* Picks a random word from the List built from words_alpha.txt file. */
        String randomWord = getRandomWordFromList(readWordsFromFIle(FILE_PATH));

        if(FILE_NOT_FOUND.equals(randomWord)){
            System.out.println(FILE_NOT_FOUND);
        } else if(FILE_IS_EMPTY.equals(randomWord)){
            System.out.println(FILE_IS_EMPTY);
        } else {
            System.out.println("Printing Random Word -->  "+ randomWord);
        }

    }
    /* Method to return a random word from the given words list */
    public static String getRandomWordFromList(List<String> wordsList) {

        if(wordsList == null) {
            return FILE_NOT_FOUND;
        } else if (wordsList.isEmpty()) {
            return FILE_IS_EMPTY;
        } else {
            //Choose random number between 0 to words List's size
            int randNum = new Random().nextInt(wordsList.size());
            return wordsList.get(randNum);
        }

    }

    /* Method to read words from a given file and return the words list*/
    public static List<String> readWordsFromFIle(String filePath){

        List<String> wordList = new ArrayList<String>();

        try {
            Scanner scan = new Scanner(new File(filePath));
            while (scan.hasNextLine()) {
                wordList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

        return wordList;

    }

}


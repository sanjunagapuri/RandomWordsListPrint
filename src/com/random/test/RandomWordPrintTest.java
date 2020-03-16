package com.random.test;

import com.random.code.RandomWordPrint;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomWordPrintTest {

    private List<String> wordList ;
    private String filePath ;
    private RandomWordPrint randomWordPrint;

    @BeforeMethod
    public void setUp() {
        wordList = new ArrayList<String>();
        filePath = "src/resource/test_words.txt";
        randomWordPrint = new RandomWordPrint();
    }

    @Test
    public void testGetRandomWordFromListEmpty() {

        Assert.assertEquals(randomWordPrint.getRandomWordFromList(wordList), RandomWordPrint.FILE_IS_EMPTY);
    }

    @Test
    public void testGetRandomWordFromListWithFileNotFound() {

        wordList = null;
        Assert.assertEquals(randomWordPrint.getRandomWordFromList(wordList), RandomWordPrint.FILE_NOT_FOUND);
    }

    @Test
    public void testGetRandomWordFromListWithOneWord() {

        wordList.add("aaa");

        Assert.assertEquals(randomWordPrint.getRandomWordFromList(wordList), "aaa");
    }

    @Test
    public void testGetRandomWordFromListWithMultipleWords() {

        wordList.add("aab");
        wordList.add("aac");
        wordList.add("aad");

        Assert.assertTrue((randomWordPrint.getRandomWordFromList(wordList).startsWith("aa")));
    }

    @Test
    public void testReadWordsFromFIleWithException() {

        filePath = "/wrongpath/test_words.txt";

        Assert.assertEquals(randomWordPrint.readWordsFromFIle(filePath), null);

    }

    @Test
    public void testReadWordsFromFIleWithNoException() {

        Assert.assertNotSame(randomWordPrint.readWordsFromFIle(filePath), Collections.EMPTY_LIST);

    }
}
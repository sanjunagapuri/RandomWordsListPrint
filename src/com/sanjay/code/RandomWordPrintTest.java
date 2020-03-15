package com.sanjay.code;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomWordPrintTest extends RandomWordPrint {

    private List<String> wordList ;
    private String filePath ;
    @BeforeMethod
    public void setUp() {
        wordList = new ArrayList<String>();
        filePath = "src/resource/test_words.txt";
    }

    @Test
    public void testGetRandomWordFromListEmpty() {

        Assert.assertEquals(getRandomWordFromList(wordList), "Words List is empty");
    }

    @Test
    public void testGetRandomWordFromListWithOneWord() {

        wordList.add("aaa");

        Assert.assertEquals(getRandomWordFromList(wordList), "aaa");
    }

    @Test
    public void testGetRandomWordFromListWithMultipleWords() {

        wordList.add("aab");
        wordList.add("aac");
        wordList.add("aad");

        Assert.assertTrue((getRandomWordFromList(wordList).startsWith("aa")));
    }

    @Test
    public void testReadWordsFromFIleException() {

        filePath = "/wrongpath/test_words.txt";

        Assert.assertEquals(readWordsFromFIle(filePath), Collections.EMPTY_LIST);

    }

    @Test
    public void testReadWordsFromFIleNoException() {

        Assert.assertNotSame(readWordsFromFIle(filePath), Collections.EMPTY_LIST);

    }
}
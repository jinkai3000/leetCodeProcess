package cn.jk.reverseWords;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by JinKai on 2016/11/28.
 */
public class ReverseWordsTest {

    @org.junit.Test
    public void testReverseWordsByArray() throws Exception {
        String words = "the sky is blue";
        String reverseWords = ReverseWords.reverseWordsByArray(words);
        System.out.println(reverseWords);
    }
}
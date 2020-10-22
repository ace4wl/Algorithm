package com.lyn.algorithm;

import com.lyn.algorithm.question.IQuestion;
import com.lyn.algorithm.question.imp.Q2_AddTwoNumbers;
import com.lyn.algorithm.question.imp.Q3_LengthOfLongestSubstring;

public class Algorithm {

    public static void main(String[] args) {
        IQuestion question = new Q3_LengthOfLongestSubstring();
        question.execute();
    }
}

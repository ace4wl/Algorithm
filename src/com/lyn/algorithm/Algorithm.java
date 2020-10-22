package com.lyn.algorithm;

import com.lyn.algorithm.question.IQuestion;
import com.lyn.algorithm.question.imp.AddTwoNumbers;

public class Algorithm {

    public static void main(String[] args) {
        IQuestion question = new AddTwoNumbers();
        question.execute();
    }
}

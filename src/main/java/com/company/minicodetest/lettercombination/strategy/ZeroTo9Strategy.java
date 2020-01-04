package com.company.minicodetest.lettercombination.strategy;

import com.company.minicodetest.lettercombination.util.LetterCombinationsUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ZeroTo9Strategy implements LetterCombinationStrategy {
    private static final Map<Integer, String> MAP = new HashMap<Integer, String>(11) {
        {
            put(0, " ");
            put(1, " ");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    public ZeroTo9Strategy() {
        LetterCombinationsUtil.setMap(MAP);
    }

    @Override
    public String combine(Integer... nums) {
        return LetterCombinationsUtil.combine(nums);
    }

    @Override
    public String getPromptMessage() {
        return "Converting from 0 to 9, please enter numbers separated by a space:";
    }
}

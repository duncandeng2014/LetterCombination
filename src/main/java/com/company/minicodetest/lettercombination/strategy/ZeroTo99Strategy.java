package com.company.minicodetest.lettercombination.strategy;

import com.company.minicodetest.lettercombination.util.LetterCombinationsUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Strategy of converting from 0 to 99 digits into letters.
 */
public class ZeroTo99Strategy implements LetterCombinationStrategy {
    private static final Map<Integer, String> MAP = new HashMap<Integer, String>(101) {
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

    public ZeroTo99Strategy() {
        IntStream.rangeClosed(10, 99).forEach(num -> {
            String key = String.valueOf(num).substring(0, 1);
            String value = MAP.get(Integer.valueOf(key));
            MAP.put(num, value);
        });
    }

    @Override
    public String combine(Integer... nums) {
        return LetterCombinationsUtil.combine(MAP, nums);
    }

    @Override
    public String getPromptMessage() {
        return "Converting from 0 to 99, please enter numbers separated by a space:";
    }
}

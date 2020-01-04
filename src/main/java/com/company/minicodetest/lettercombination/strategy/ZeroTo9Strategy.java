package com.company.minicodetest.lettercombination.strategy;

import com.company.minicodetest.lettercombination.util.LetterCombinationsUtil;

import java.util.HashMap;
import java.util.Map;

public class ZeroTo9Strategy implements LetterCombinationStrategy {
    private Map<Integer, String> map = new HashMap<Integer, String>(11) {
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
        LetterCombinationsUtil.setMap(map);
    }

    @Override
    public String combine(Integer... nums) {
        return LetterCombinationsUtil.combine(nums);
    }

    @Override
    public Map<Integer, String> getMap() {
        return map;
    }

    @Override
    public String getPromptMessage() {
        return "Converting from 0 to 9, Please enter numbers separated by a space:";
    }
}

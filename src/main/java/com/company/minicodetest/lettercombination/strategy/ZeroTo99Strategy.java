package com.company.minicodetest.lettercombination.strategy;

import com.company.minicodetest.lettercombination.util.LetterCombinationsUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class ZeroTo99Strategy implements LetterCombinationStrategy {
    private Map<Integer, String> map = new HashMap<Integer, String>(101) {
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
            String value = map.get(Integer.valueOf(key));
            map.put(num, value);
        });

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
}

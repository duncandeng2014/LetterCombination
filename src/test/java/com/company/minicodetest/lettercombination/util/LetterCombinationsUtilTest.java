package com.company.minicodetest.lettercombination.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LetterCombinationsUtilTest {
    private static Map<Integer, String> map = new HashMap<Integer, String>() {
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

    @Test
    public void testCombine() {
        IntStream.rangeClosed(0, 9).forEach(n -> {
            String combineResult = LetterCombinationsUtil.combine(map, n);
            String expected = Arrays.stream(map.get(n).split("")).collect(Collectors.joining(" "));
            assertEquals(expected.trim(), combineResult);
        });
    }

    @Test
    public void testCombine0To9() {
        Integer[] input = {9};
        String result = LetterCombinationsUtil.combine(map, input);
        assertEquals("w x y z", result);

        input = new Integer[]{2, 3};
        result = LetterCombinationsUtil.combine(map, input);
        assertEquals("ad ae af bd be bf cd ce cf", result);

        input = new Integer[]{2, 3, 4};
        result = LetterCombinationsUtil.combine(map, input);
        assertEquals("adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi", result);
    }

}

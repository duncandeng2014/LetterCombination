package com.company.minicodetest.lettercombination.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provide core arithmetic to combine the characters represent by digits into letters.
 */
public abstract class LetterCombinationsUtil {
    private static Map<Integer, String> map;

    public static String combine(Integer... nums) {
        StringBuilder sb = new StringBuilder();
        LetterCombinationsUtil.combineSingleNumber(sb, 0, "", nums);
        return sb.toString().trim();
    }

    private static void combineSingleNumber(StringBuilder sb, int index, String parent, Integer... nums) {
        if (index < nums.length) {
            int num = nums[index];
            Stream.of(map.get(num).chars().mapToObj(item -> (char)item).collect(Collectors.toList())).forEach(charlist ->
                    charlist.forEach(c -> {
                        String current = c.toString().trim();
                        if (index == nums.length - 1)
                            sb.append(parent).append(current).append(" ");
                        combineSingleNumber(sb, index + 1, parent + current, nums);
                    })
            );
        }
    }

    public static Map<Integer, String> getMap() {
        return map;
    }

    public static void setMap(Map<Integer, String> map) {
        LetterCombinationsUtil.map = map;
    }
}

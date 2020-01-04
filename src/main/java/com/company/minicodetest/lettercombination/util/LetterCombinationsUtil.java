package com.company.minicodetest.lettercombination.util;

import javafx.util.converter.CharacterStringConverter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class LetterCombinationsUtil {
    private static CharacterStringConverter characterStringConverter = new CharacterStringConverter();

    private static Map<Integer, String> map;

    public static String combine(Integer... nums) {
        StringBuilder sb = new StringBuilder();
//        Integer[] splited = LetterCombinationsUtil.splitToSingleNumbers(nums);
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
                            sb.append(parent + current).append(" ");
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

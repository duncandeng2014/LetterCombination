package com.company.minicodetest.lettercombination.util;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provide core arithmetic to combine the characters represent by digits into letters.
 */
public abstract class LetterCombinationsUtil {
    private static ReentrantLock lock = new ReentrantLock();

    public static String combine(Map<Integer, String> map, Integer... nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("digits is null or empty");

        StringBuilder sb = new StringBuilder();

        try {
            lock.lock();
            LetterCombinationsUtil.combineSingleNumber(sb, 0, "", map, nums);
        } finally {
            lock.unlock();
        }

        return sb.toString().trim();
    }

    private static void combineSingleNumber(StringBuilder sb, int index, String parent, Map<Integer, String> map, Integer... nums) {
        if (index < nums.length) {
            int num = nums[index];
            Stream.of(map.get(num).chars().mapToObj(item -> (char)item).collect(Collectors.toList())).forEach(charlist ->
                    charlist.forEach(c -> {
                        String current = c.toString().trim();
                        if (index == nums.length - 1)
                            sb.append(parent).append(current).append(" ");
                        combineSingleNumber(sb, index + 1, parent + current, map, nums);
                    })
            );
        }
    }

}

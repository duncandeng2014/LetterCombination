package com.company.minicodetest.lettercombination.strategy;

import java.util.Map;

public interface LetterCombinationStrategy {
    String combine(Integer... nums);
    Map<Integer, String> getMap();
}

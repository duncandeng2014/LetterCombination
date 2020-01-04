package com.company.minicodetest.lettercombination.service;

import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;

public interface LetterCombinationService {
    /**
     * Convert the line of digits into letters.
     * @param strategy The specific strategy what apply to convert the digits into letters
     * @param input The digits separated by space
     * @return Converted letters
     */
    String combine(LetterCombinationStrategy strategy, String input);

}

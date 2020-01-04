package com.company.minicodetest.lettercombination.strategy;

/**
 * Extendable strategy of converting from digits into letters for different requirement.
 */
public interface LetterCombinationStrategy {
    String combine(Integer... nums);
    String getPromptMessage();
}

package com.company.minicodetest.lettercombination.strategy;

public interface LetterCombinationStrategy {
    String combine(Integer... nums);
    String getPromptMessage();
}

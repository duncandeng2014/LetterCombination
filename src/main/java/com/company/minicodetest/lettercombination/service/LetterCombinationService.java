package com.company.minicodetest.lettercombination.service;

import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;

public interface LetterCombinationService {
    String combine(LetterCombinationStrategy strategy, String line);

}

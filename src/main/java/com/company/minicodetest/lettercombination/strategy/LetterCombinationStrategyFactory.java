package com.company.minicodetest.lettercombination.strategy;

import java.util.LinkedList;
import java.util.List;

public enum LetterCombinationStrategyFactory {
    instance;

    private List<LetterCombinationStrategy> strategies = new LinkedList<LetterCombinationStrategy>() {
        {
          add(new ZeroTo9Strategy());
          add(new ZeroTo99Strategy());
        }
    };

    public List<LetterCombinationStrategy> getStrategies() {
        return strategies;
    }
}

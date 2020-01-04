package com.company.minicodetest.lettercombination.service.impl;

import com.company.minicodetest.lettercombination.service.LetterCombinationService;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import org.springframework.stereotype.Service;

@Service
public class LetterCombinationServiceImpl implements LetterCombinationService {
    @Override
    public String combine(LetterCombinationStrategy strategy, Integer... nums) {
        return strategy.combine(nums);
    }

}

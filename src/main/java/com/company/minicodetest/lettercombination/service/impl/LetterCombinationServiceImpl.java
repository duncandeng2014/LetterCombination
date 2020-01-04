package com.company.minicodetest.lettercombination.service.impl;

import com.company.minicodetest.lettercombination.service.LetterCombinationService;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LetterCombinationServiceImpl implements LetterCombinationService {
    @Override
    public String combine(LetterCombinationStrategy strategy, String input) {
        Integer[] nums = convertInput(input);
        return strategy.combine(nums);
    }

    private Integer[] convertInput(String input) {
        String[] splited = input.split(" ");
        Integer[] nums = new Integer[splited.length];
        for (int i = 0; i < splited.length; i++) {
            String num = splited[i];
            nums[i] = parseInteger(num);
        }

        return nums;
    }

    private Integer parseInteger(String s) {
        Integer i = null;
        try {
            i = Integer.valueOf(s);
        } catch (Exception e) {
            // skip if not a number
        }

        return Optional.ofNullable(i).orElse(0);
    }

}

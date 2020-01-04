package com.company.minicodetest.lettercombination;

import com.company.minicodetest.lettercombination.service.LetterCombinationService;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategyFactory;
import com.company.minicodetest.lettercombination.strategy.ZeroTo99Strategy;
import com.company.minicodetest.lettercombination.strategy.ZeroTo9Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class StartMain implements CommandLineRunner {
    @Autowired
    private LetterCombinationService letterCombinationService;

    private void combine(LetterCombinationStrategy strategy, String line) {
        String result = letterCombinationService.combine(strategy, line);
        System.out.println("Result:" + result);
    }

    @Override
    public void run(String... args) throws Exception {
        List<LetterCombinationStrategy> strategies = LetterCombinationStrategyFactory.instance.getStrategies();
        for (LetterCombinationStrategy strategy : strategies) {
            Scanner sc = new Scanner(System.in);
            System.out.println(strategy.getPromptMessage());
            String line = sc.nextLine();
            combine(strategy, line);
            System.out.println("==========================");
        }
    }
}

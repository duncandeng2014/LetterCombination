package com.company.minicodetest.lettercombination;

import com.company.minicodetest.lettercombination.service.LetterCombinationService;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StartMain implements CommandLineRunner {
    @Autowired
    private LetterCombinationService letterCombinationService;

    private LetterCombinationStrategy getStrategyByOption(Scanner sc) {
        String line = sc.nextLine();
        while (line == null || line.trim().length() == 0) {
            System.out.println("You input wrong option, please input 1 or 2");
            line = sc.nextLine();
        }

        return LetterCombinationStrategyFactory.instance.getStrategy(line);
    }

    @Override
    public void run(String... args)  {
        if (args != null && args.length > 0) {
            Scanner sc = new Scanner(System.in);
            String line = null;
            switch (args[0]) {
                case "-c":
                    System.out.println("Choose an option:\n  " +
                            "1: Convert digits from 0 to 9\n  " +
                            "2: Convert digits from 0 to 99");
                    LetterCombinationStrategy strategy = getStrategyByOption(sc);
                    System.out.println(strategy.getPromptMessage());
                    line = sc.nextLine();
                    String result = letterCombinationService.combine(strategy, line);
                    System.out.println("Result:" + result);
                    System.out.println("==========================");
                    break;
            }
        }
    }
}

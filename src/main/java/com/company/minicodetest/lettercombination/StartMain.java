package com.company.minicodetest.lettercombination;

import com.company.minicodetest.lettercombination.service.LetterCombinationService;
import com.company.minicodetest.lettercombination.strategy.ZeroTo99Strategy;
import com.company.minicodetest.lettercombination.strategy.ZeroTo9Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class StartMain implements CommandLineRunner {
    @Autowired
    private LetterCombinationService letterCombinationService;

    @Autowired
    private ZeroTo9Strategy zeroTo9Strategy;

    @Autowired
    private ZeroTo99Strategy zeroTo99Strategy;

    private void combineWithZeroTo9Strategy(String line) {
        Integer[] nums = convertInput(line);
        String result = letterCombinationService.combine(zeroTo9Strategy, nums);
        System.out.println("Result:" + result);
    }

    private void combineWithZeroTo99Strategy(String line) {
        Integer[] nums = convertInput(line);
        String result = letterCombinationService.combine(zeroTo99Strategy, nums);
        System.out.println("Result:" + result);
    }

    public Integer[] convertInput(String line) {
        String[] splited = line.split(" ");
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

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Converting from 0 to 9, Please enter numbers separated by a space:");
        String line = sc.nextLine();
        combineWithZeroTo9Strategy(line);

        sc = new Scanner(System.in);
        System.out.println("Converting from 0 to 99, Please enter numbers separated by a space:");
        line = sc.nextLine();
        combineWithZeroTo99Strategy(line);
    }

}

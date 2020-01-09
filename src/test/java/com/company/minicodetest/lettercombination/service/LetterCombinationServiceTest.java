package com.company.minicodetest.lettercombination.service;

import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LetterCombinationServiceTest {
    @Autowired
    private LetterCombinationService service;

    @Test
    public void testCombine0To9() {
        LetterCombinationStrategy zeroTo9Strategy = LetterCombinationStrategyFactory.instance.getStrategy(
                LetterCombinationStrategyFactory.LcStrategyOption.ZeroTo9);
        String input = "9";
        String result = service.combine(zeroTo9Strategy, input);
        assertEquals("w x y z", result);

        input = "2 3";
        result = service.combine(zeroTo9Strategy, input);
        assertEquals("ad ae af bd be bf cd ce cf", result);
    }

    @Test
    public void testCombine0To99() {
        LetterCombinationStrategy zeroTo99Strategy = LetterCombinationStrategyFactory.instance.getStrategy(
                LetterCombinationStrategyFactory.LcStrategyOption.ZeroTo99);
        String input = "22 33";
        String result = service.combine(zeroTo99Strategy, input);
        assertEquals("ad ae af bd be bf cd ce cf", result);

        input = "99";
        result = service.combine(zeroTo99Strategy, input);
        assertEquals("w x y z", result);

        input = "23 43 52 99";
        result = service.combine(zeroTo99Strategy, input);
        assertEquals("agjw agjx agjy agjz agkw agkx agky agkz aglw aglx agly aglz ahjw ahjx ahjy ahjz ahkw ahkx ahky ahkz ahlw ahlx ahly ahlz aijw aijx aijy aijz aikw aikx aiky aikz ailw ailx aily ailz bgjw bgjx bgjy bgjz bgkw bgkx bgky bgkz bglw bglx bgly bglz bhjw bhjx bhjy bhjz bhkw bhkx bhky bhkz bhlw bhlx bhly bhlz bijw bijx bijy bijz bikw bikx biky bikz bilw bilx bily bilz cgjw cgjx cgjy cgjz cgkw cgkx cgky cgkz cglw cglx cgly cglz chjw chjx chjy chjz chkw chkx chky chkz chlw chlx chly chlz cijw cijx cijy cijz cikw cikx ciky cikz cilw cilx cily cilz", result);
    }

}

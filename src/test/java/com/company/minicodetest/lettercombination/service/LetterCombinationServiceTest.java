package com.company.minicodetest.lettercombination.service;

import com.company.minicodetest.lettercombination.service.impl.LetterCombinationServiceImpl;
import com.company.minicodetest.lettercombination.strategy.LetterCombinationStrategy;
import com.company.minicodetest.lettercombination.strategy.ZeroTo99Strategy;
import com.company.minicodetest.lettercombination.strategy.ZeroTo9Strategy;
import com.company.minicodetest.lettercombination.util.LetterCombinationsUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

public class LetterCombinationServiceTest {
    private LetterCombinationService service;

    @Before
    public void beforeScenario() {
        service = new LetterCombinationServiceImpl();

    }

    @Test
    public void testCombine0To9() {
        LetterCombinationStrategy zeroTo9Strategy = new ZeroTo9Strategy();
        Integer[] input = {9};
        String result = service.combine(zeroTo9Strategy, input);
        assertEquals("w x y z", result);

        input = new Integer[]{2, 3};;
        result = service.combine(zeroTo9Strategy, input);
        assertEquals("ad ae af bd be bf cd ce cf", result);
    }

    @Test
    public void testCombine0To99() {
        LetterCombinationStrategy zeroTo99Strategy = new ZeroTo99Strategy();
        Integer[] input = {22, 33};
        String result = service.combine(zeroTo99Strategy, input);
        assertEquals("ad ae af bd be bf cd ce cf", result);

        input = new Integer[]{99};;
        result = service.combine(zeroTo99Strategy, input);
        assertEquals("w x y z", result);

        input = new Integer[]{23, 43, 52, 99};;
        result = service.combine(zeroTo99Strategy, input);
        assertEquals("agjw agjx agjy agjz agkw agkx agky agkz aglw aglx agly aglz ahjw ahjx ahjy ahjz ahkw ahkx ahky ahkz ahlw ahlx ahly ahlz aijw aijx aijy aijz aikw aikx aiky aikz ailw ailx aily ailz bgjw bgjx bgjy bgjz bgkw bgkx bgky bgkz bglw bglx bgly bglz bhjw bhjx bhjy bhjz bhkw bhkx bhky bhkz bhlw bhlx bhly bhlz bijw bijx bijy bijz bikw bikx biky bikz bilw bilx bily bilz cgjw cgjx cgjy cgjz cgkw cgkx cgky cgkz cglw cglx cgly cglz chjw chjx chjy chjz chkw chkx chky chkz chlw chlx chly chlz cijw cijx cijy cijz cikw cikx ciky cikz cilw cilx cily cilz", result);
    }
}

package com.company.minicodetest.lettercombination;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartMainTest {
    private StartMain startMain;

    @Before
    public void beforeScenario() {
        startMain = new StartMain();

    }

    @Test
    public void convertInput() {
        Integer[] nums = startMain.convertInput("0 1 2 3 4 5 6 7 8 9");
        Integer[] expected = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }

    }
}
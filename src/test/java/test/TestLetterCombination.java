package test;

import lc.LetterCombinations;
import org.junit.Assert;
import org.junit.Test;

public class TestLetterCombination {
    @Test
    public void testCombine() {
        Integer[] input = {2, 3};
        StringBuilder sb = new StringBuilder();
        LetterCombinations.combine(sb, 0, "", input);
        Assert.assertEquals(sb.toString().trim(),"ad ae af bd be bf cd ce cf");

        input = new Integer[]{9};
        sb = new StringBuilder();
        LetterCombinations.combine(sb, 0, "", input);
        Assert.assertEquals(sb.toString().trim(),"w x y z");

        input = new Integer[]{2, 99};
        Integer[] splited = LetterCombinations.splitToSingleNumbers(input);
        sb = new StringBuilder();
        LetterCombinations.combine(sb, 0, "", splited);
        System.out.println(sb.toString());
        Assert.assertEquals(sb.toString().trim(),"aww awx awy awz axw axx axy axz ayw ayx ayy ayz azw azx azy azz bww bwx bwy bwz bxw bxx bxy bxz byw byx byy byz bzw bzx bzy bzz cww cwx cwy cwz cxw cxx cxy cxz cyw cyx cyy cyz czw czx czy czz");
    }
}

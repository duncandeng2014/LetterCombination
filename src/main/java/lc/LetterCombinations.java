package lc;

import javafx.util.converter.CharacterStringConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCombinations {
    static Map<Integer, String> map = new HashMap<Integer, String>();
    static CharacterStringConverter characterStringConverter = new CharacterStringConverter();
    static {
        map.put(0, " ");
        map.put(1, " ");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static void combine(StringBuilder sb, int index, String parent, Integer... nums) {
        if (index < nums.length) {
            int num = nums[index];
            Stream.of(map.get(num).chars().mapToObj(item -> (char)item).collect(Collectors.toList())).forEach(charlist ->
                    charlist.forEach(c -> {
                        String current = c.toString().trim();
                        if (index == nums.length - 1)
                            sb.append(parent + current).append(" ");
                        combine(sb, index + 1, parent + current, nums);
                    })
            );
        }
    }

    public static Integer[] splitToSingleNumbers(Integer... nums) {
        List<Integer> singleNumbers = new ArrayList<Integer>();
        for (int num : nums)
            splitToSingleNumbers(singleNumbers, num);
        Integer[] result = new Integer[singleNumbers.size()];
        return singleNumbers.toArray(result);
    }

    private static void splitToSingleNumbers(List<Integer> singleNumbers, int num) {
        if (num < 10) {
            singleNumbers.add(num);
            return;
        } else {
            String numStr = String.valueOf(num);
            int length = numStr.length();
            for (int i = 0; i < length; i++) {
                Integer each = Integer.valueOf(characterStringConverter.toString(numStr.charAt(i)));
                singleNumbers.add(each);
            }
        }
    }

}

package tests;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static tests.Calculator.calculate;

public class Classssss {

    @Test
    public void checkSumOfCalculator() {
        assertEquals(3.0, calculate(1, 2, "sum"));
    }

    @Test
    public void checkSubtractOfCalculator() {
        assertEquals(8.0, calculate(10, 2, "subtract"));
    }

    @Test
    public void checkDivideOfCalculator() {
        assertEquals(50.0, calculate(100, 2, "divide"));
    }

    @Test
    public void checkMultiplyOfCalculator() {
        assertThat(calculate(5, 4, "multiply")).isEqualTo(20.0);
    }

    @Test
    public void checkExceptionOfCalculator() {
        assertThrows(UnsupportedOperationException.class, () -> calculate(1, 1, "invalid"));
    }


    static boolean isPalindrome(int x) {
        int sum = 0;
        int u = x;
        if (u < 0) {
            return false;
        }

        while (x > 0) {
            int rem = x % 10;
            sum = (sum * 10) + rem;
            x /= 10;
        }
        System.out.println(sum == u);
        return sum == u;
    }

    static int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curVal = values.get(s.charAt(i));

            if (i < s.length() - 1 && curVal < values.get(s.charAt(i + 1))) {
                res = res - curVal;
            } else {
                res = res + curVal;
            }
        }
        System.out.println(res);
        return res;
    }

    static int linearSequence(int[] ints, int find) {
        int result = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == find && result == -1) {
                result = i;
            }
        }
        return result;
    }

    static int biggestNumber(int[] ints) {
        int result = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > result) {
                result = ints[i];
            }
        }
        return result;
    }

    static int secondBiggestNumber(int[] ints) {
        int result = ints[0] < ints[1] ? ints[0] : ints[1];
        int max = ints[0] > ints[1] ? ints[0] : ints[1];

        for (int i = 2; i < ints.length; i++) {
            if (ints[i] > result && ints[i] > max) {
                result = max;
                max = ints[i];
            } else if (ints[i] > result && ints[i] < max) {
                result = ints[i];
            }
        }
        return result;
    }

    static int smallestEvenNumber(int[] ints) {
        int result = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 == 0 && (result == -1 || result > ints[i])) {
                result = ints[i];
            }
        }
        return result;
    }

    static String shortestWords(List<String> input) {
        List<String> result = new ArrayList<>();
        int minlen = input.getFirst().length();
        for (int i = 1; i < input.size() - 1; i++) {
            if (input.get(i).length() < minlen) {
                minlen = input.get(i).length();
            }
        }
        for (String str : input) {
            if (str.length() == minlen) {
                result.add(str);
            }
        }
        return String.join(" ", result);
    }

    static String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return s.toString();
                }
            }
            s.append(currentChar);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 2, 2, 2, 4, 5, 1};
//        System.out.println(Arrays.toString(sortedArray(ints)));

        System.out.println(isDigitPerMutation(155532, 213555));
    }

    static int[] sortedArray(int[] initArray) {
        int[] result = new int[initArray.length];
        int[] counters = new int[6];
        for (int k : initArray) {
            counters[k]++;
        }
        int resultIndex = 0;
        for (int i = 0; i < counters.length; i++) {
            for (int j = 0; j < counters[i]; j++) {
                result[resultIndex++] = i;
            }
        }
        return result;
    }

    static Boolean isDigitPerMutation(int first, int second) {
        boolean result = false;
        int[] firstIndexes = fillArray(first);
        int[] secondIndexes = fillArray(second);

        for (int i = 0; i < 10; i++) {
            result = firstIndexes[i] == secondIndexes[i];
        }
        return result;
    }

    private static int[] fillArray(int number) {
        int[] filledArray = new int[10];
        while (number > 0) {
            int divByTen = number % 10;
            filledArray[divByTen] = filledArray[divByTen] + 1;
            number = number / 10;
        }
        return filledArray;
    }
}

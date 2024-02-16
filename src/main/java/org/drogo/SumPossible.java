package org.drogo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static boolean isSumPossible(int amount, List<Integer> numbers) {
        return isSumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean isSumPossible(
            int amount,
            List<Integer> numbers,
            HashMap<Integer, Boolean> memo
    ) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int num : numbers) {
            int subAmount = amount - num;
            if (isSumPossible(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;

    }

    public static void main(String[] args) {

        System.out.println(isSumPossible(5, Arrays.asList(1, 2, 3)));
        System.out.println(isSumPossible(8, List.of(5, 12, 4)));
        System.out.println(isSumPossible(15, List.of(6, 2, 10, 19)));
        System.out.println(isSumPossible(103, List.of(6, 20, 1)));
        System.out.println(isSumPossible(271, List.of(10, 8, 265, 24)));
        System.out.println(isSumPossible(2017, List.of(4, 2, 10)));

    }
}

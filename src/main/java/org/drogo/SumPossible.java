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
    }
}

package org.drogo;

import java.util.HashMap;
import java.util.List;

public class CountingChange {

    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }

    public static int countingChange(
            int amount, int coinIndex,
            List<Integer> coins,
            HashMap<List<Integer>, Integer> memo
    ) {
        if (amount == 0) {
            return 1;
        }

        if (coinIndex >= coins.size()) {
            return 0;
        }

        List<Integer> key = List.of(amount, coinIndex);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalWays = 0;
        int value = coins.get(coinIndex);

        for (int qty = 0; qty * value <= amount; qty += 1) {
            int subAmount = amount - (qty * value);
            totalWays += countingChange(subAmount, coinIndex + 1, coins, memo);
        }
        memo.put(key, totalWays);
        return totalWays;
    }
}

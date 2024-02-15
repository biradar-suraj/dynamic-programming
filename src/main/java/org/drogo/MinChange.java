package org.drogo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinChange {

    public static int minimumNumberOfCoins(int amount, List<Integer> coins) {
        return minimumNumberOfCoins(amount, coins, new HashMap<>());
    }

    public static int minimumNumberOfCoins(
            int amount,
            List<Integer> coins,
            HashMap<Integer, Integer> memo
    ) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minimumNumberOfCoins(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }

        }

        memo.put(amount, minCoins);
        return minCoins;

    }

    public static void main(String[] args) {
        System.out.println(minimumNumberOfCoins(5, Arrays.asList(1, 2, 3)));

    }
}

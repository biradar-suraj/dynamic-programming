package org.drogo;

import java.util.HashMap;

/* Use minimum number of perfect squares */
public class SummingSquares {
    public static int summingSquares(int num) {
        return (int) summingSquares(num, new HashMap<>());
    }

    public static double summingSquares(
            int num, HashMap<Integer, Double> memo
    ) {
        if (num == 0) {
            return 0;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        double minSquares = Double.POSITIVE_INFINITY;
        for (int i = 1; i <= Math.sqrt(num); i += i) {
            int square = i * i;
            double numSquares = 1 + summingSquares(num - square,memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }
        memo.put(num,minSquares);
        return minSquares;
    }

    public static void main(String[] args) {
        System.out.println(summingSquares(8));
        System.out.println(summingSquares(9));
        System.out.println(summingSquares(12));
        System.out.println(summingSquares(31));
        System.out.println(summingSquares(50));
        System.out.println(summingSquares(68));

    }

}

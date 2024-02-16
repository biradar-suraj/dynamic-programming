package org.drogo;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum {
    public static int findMaxPathSum(List<List<Integer>> grid) {
        return (int) findMaxPathSum(0, 0, grid, new HashMap<>());

    }

    public static double findMaxPathSum(int row, int col, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
        if (row == grid.size() || col == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }
        if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
            return grid.get(row).get(col);
        }

        List<Integer> pos = List.of(row, col);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double down = findMaxPathSum(row + 1, col, grid, memo);
        double right = findMaxPathSum(row, col + 1, grid, memo);

        double result = grid.get(row).get(col) + Math.max(down, right);
        memo.put(pos, result);
        return result;


    }

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 6, 2)
        );
        System.out.println(findMaxPathSum(grid));

        List<List<Integer>> grid1 = List.of(
                List.of(1, 3, 12),
                List.of(5, 1, 1),
                List.of(3, 6, 1)
        );
        System.out.println(findMaxPathSum(grid1));

        List<List<Integer>> grid2 = List.of(
                List.of(1, 2, 8, 1),
                List.of(3, 1, 12, 10),
                List.of(4, 0, 6, 3)
        );
        System.out.println(findMaxPathSum(grid2));
    }
}

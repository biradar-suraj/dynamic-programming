package org.drogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountPaths {
    public static int countPaths(List<List<String>> grid) {
        return countPaths(0, 0, grid, new HashMap<>());
    }

    public static int countPaths(
            int row,
            int col,
            List<List<String>> grid,
            HashMap<List<Integer>, Integer> memo
    ) {
        if (row == grid.size() || col == grid.get(0).size()) {
            return 0;
        }

        if ("X".equals(grid.get(row).get(col))) {
            return 0;
        }
        if (row == grid.size() - 1 && col == grid.size() - 1) {
            return 1;
        }

        List<Integer> pos = List.of(row, col);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int result = countPaths(row + 1, col, grid, memo) + countPaths(row, col + 1, grid, memo);
        memo.put(pos, result);
        return result;


    }

    public static List<String> printPaths(
            int row,
            int col,
            List<List<String>> grid,
            HashMap<List<Integer>, List<String>> memo
    ) {
        List<String> result = new ArrayList<>();
        if (row == grid.size() || col == grid.get(0).size()) {
            return new ArrayList<>();
        }

        if ("X".equals(grid.get(row).get(col))) {
            return new ArrayList<>();
        }
        if (row == grid.size() - 1 && col == grid.size() - 1) {
            result.add("[" + row + "," + col + "]");
        }

        List<Integer> pos = List.of(row, col);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        List<String> downPaths = (printPaths(row + 1, col, grid, memo));
        List<String> rightPaths = (printPaths(row, col + 1, grid, memo));
        for (String rightPath : rightPaths) {
            result.add("[" + row + "," + col + "]" + rightPath);
        }
        for (String downPath : downPaths) {
            result.add("[" + row + "," + col + "]" + downPath);
        }
        memo.put(pos, result);
        return result;


    }


    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X"),
                List.of("O", "O", "O"),
                List.of("O", "O", "O")
        );

        System.out.println(countPaths(grid));
        System.out.println(printPaths(0, 0, grid, new HashMap<>()));
    }


}

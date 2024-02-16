package org.drogo;

import java.util.ArrayList;
import java.util.Collections;
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
        if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
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

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X"),
                List.of("O", "O", "O"),
                List.of("O", "O", "O")
        );
        System.out.println(countPaths(grid));

        List<List<String>> grid1 = List.of(
                List.of("O", "O", "O"),
                List.of("O", "X", "X"),
                List.of("O", "O", "O")
        );
        System.out.println(countPaths(grid1));

        List<List<String>> grid2 = List.of(
                List.of("O", "O", "X", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "X"),
                List.of("X", "O", "O", "O", "O", "O"),
                List.of("X", "X", "X", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O")
        );
        System.out.println(countPaths(grid2));
    }


}

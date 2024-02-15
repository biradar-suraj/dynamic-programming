package org.drogo;

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

        return countPaths(row + 1, col, grid, memo) + countPaths(row, col + 1, grid, memo);


    }

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X"),
                List.of("O", "O", "O"),
                List.of("O", "O", "O")
        );

        System.out.println(countPaths(grid));
    }


}

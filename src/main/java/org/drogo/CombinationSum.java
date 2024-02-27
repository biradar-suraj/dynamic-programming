package org.drogo;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum {
    public static int combinationSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return combinationSum(nums, target, memo);
    }

    public static int combinationSum(int[] nums, int target, Map<Integer, Integer> memo) {

        if (target == 0) return 1;

        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int combination = 0;

        for (int num : nums) {
            if (num > target) continue;
            combination += combinationSum(nums, target - num, memo);
        }

        memo.put(target, combination);
        return combination;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum(nums, target));
    }
}

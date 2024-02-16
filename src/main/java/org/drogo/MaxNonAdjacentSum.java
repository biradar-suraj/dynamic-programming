package org.drogo;

import java.util.HashMap;
import java.util.List;

public class MaxNonAdjacentSum {

    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());

    }

    public static int nonAdjacentSum(
            List<Integer> nums, int i, HashMap<Integer, Integer> memo
    ) {
        if (i >= nums.size()) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int left = nums.get(i) + nonAdjacentSum(nums, i + 2, memo);
        int right = nonAdjacentSum(nums, i + 1, memo);
        int result = Math.max(left, right);
        memo.put(i, result);
        return result;

    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 5, 12, 7);
        System.out.println(nonAdjacentSum(nums));

        List<Integer> nums1 = List.of(7, 5, 5, 12);
        System.out.println(nonAdjacentSum(nums1));

        List<Integer> nums2 = List.of(7, 5, 5, 12, 17, 29);
        System.out.println(nonAdjacentSum(nums2));

        List<Integer> nums3 = List.of(
                72, 62, 10, 6, 20, 19, 42,
                46, 24, 78, 30, 41, 75, 38,
                23, 28, 66, 55, 12, 17, 9,
                12, 3, 1, 19, 30, 50, 20
        );
        System.out.println(nonAdjacentSum(nums3));

        List<Integer> nums4 = List.of(
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                83, 80, 56, 68, 6, 22, 56, 96, 77, 98,
                61, 20, 0, 76, 53, 74, 8, 22, 92, 37,
                30, 41, 75, 38, 23, 28, 66, 55, 12, 17,
                72, 62, 10, 6, 20, 19, 42, 46, 24, 78,
                42
        );
        System.out.println(nonAdjacentSum(nums4));

    }
}

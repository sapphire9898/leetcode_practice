package com.example.java;

import java.util.*;
/**
 * Created by yueyangzou on 16/10/11.
 */
public class CoinGame {
    public static void main(String[] args) {
        int[] nums = {3,7,2,1};
        CoinGame coinGame = new CoinGame();
        System.out.println(coinGame.maxA(nums));
    }
    public int maxA(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }

        // if get the last one, B will get the Math.max(nums[start], nums[end - 1]);
        // helper(nums, rest);


        // if get the first one, B will get the Math.max(nums[start + 1], nums[end]);
        // helper(rest);

        int first = nums[end];
        int last = nums[start];

        if (nums[end - 1] > nums[start]) {
            // A get the last one.
            first += helper(nums, start, end - 2);
        }
        else if (nums[end - 1] < nums[start]){
            first += helper(nums, start + 1, end - 1);
        }
        else {
            first += Math.max(helper(nums, start, end - 2), helper(nums, start + 1, end - 1));
        }

        if (nums[end] > nums[start + 1]) {
            // A get the first one.
            last += helper(nums, start + 1, end - 1);
        }
        else if (nums[end] < nums[start + 1]){
            last += helper(nums, start + 2, end);
        }
        else {
            last += Math.max(helper(nums, start + 1, end - 1), helper(nums, start + 2, end));
        }
        return Math.max(first, last);

    }


}

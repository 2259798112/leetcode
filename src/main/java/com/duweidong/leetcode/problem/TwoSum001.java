package com.duweidong.leetcode.problem;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class TwoSum001 {
    /*

    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     */


    /**
     * 循环遍历
     * Complexity Analysis
     * <p>
     * Time complexity : O(n^2)
     * <p>
     * Space complexity : O(1)
     *
     * @author du wd
     **/
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }


    /**
     * 减低运行时间, 以空间换时间
     * 查找时间从 O(n) -> O(1) , 可以通过创建hash table
     * 注意避免 Hash 碰撞, 发生碰撞 会从O(1) 下降到 O(n)
     *
     * @param args
     */
    public static int[] twoSumOnHashTable(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (hashMap.containsKey(x) && hashMap.get(x) != i) {
                return new int[]{i, hashMap.get(x)};
            }
        }

        return null;
    }


}

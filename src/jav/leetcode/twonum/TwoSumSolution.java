package jav.leetcode.twonum;

import java.util.Arrays;

public class TwoSumSolution {

    public static final Integer MAX_CAPACITY = 10000;

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        TwoSumSolution t = new TwoSumSolution();
        System.out.println(Arrays.toString(t.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        /**
         * Way 1 稀疏Matrix point[num] = sequence;
         * Way 2 TargetList point[sequence] = subtraction;
         **/
        int[] resolve = new int[MAX_CAPACITY];
        Arrays.fill(resolve, 0);
        for (int point = 0, maxPoint = -1; point < nums.length; point++, maxPoint++) {
            for (int j = 0; ; j++) {
                resolve[point] = target - nums[point];
                if (maxPoint < 0) break;
                if (resolve[j] == nums[point]) {
                    return new int[]{point, j};
                }
                if (j == maxPoint) break;
            }

        }
        int[] result = {0, 0};
        return result;
    }
}


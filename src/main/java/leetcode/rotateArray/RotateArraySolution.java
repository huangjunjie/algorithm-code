package leetcode.rotateArray;

import java.util.Arrays;

public class RotateArraySolution {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        new RotateArraySolution().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     * <p>
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 105
     * <p>
     * <p>
     * Follow up:
     * <p>
     * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int numLength = nums.length;
        int remainder = k % numLength;
        int [] result = new int[numLength];
        System.arraycopy(nums, numLength - remainder, result, 0, remainder);
        System.arraycopy(nums, 0, result, remainder, numLength - remainder);
        System.arraycopy(result, 0, nums, 0, numLength);
    }
}

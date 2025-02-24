package leetcode.maximumSubarray;

import java.util.Arrays;

public class MaximumSubarraySolution {

    public static void main(String[] args) {
        int[] input = {5,4,-1,7,8};
        System.out.println(new MaximumSubarraySolution().maxSubArray(input));
    }

    /**
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     * <p>
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * Example 3:
     * <p>
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * <p>
     * <p>
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * <p>
     * 左 右 可以贪心。  中心不能贪不行。
     * Positive Negative Positive Negative Positive
     * <p>
     * 以 i 为右边界，最大的值
     * d(i) = max(d(x,i+1)) + nums[i]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        int pLeft = 0;
        int pRight = nums.length - 1;
        while (pLeft < nums.length && nums[pLeft] <= 0) pLeft++;
        while (pRight > 0 && nums[pRight] <= 0) pRight--;
        //special condition
        if (pLeft >= pRight) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        left = pLeft;
        right = pRight;
        int i = left;
        while (true) {
            if (i > right) break;
            if (nums[i] <= 0) {
                // 负数
                int negative = 0;
                i--;
                do {
                    i++;
                    negative += nums[i];
                } while (nums[i + 1] <= 0);
                if (sum > -1 * negative) {
                    sum += negative;
                } else {
                    left = i + 1;
                    sum = 0;
                }
            } else {
                sum += nums[i];
            }
            if (maxValue < sum) maxValue = sum;
            i++;
        }
        return maxValue;
    }
}

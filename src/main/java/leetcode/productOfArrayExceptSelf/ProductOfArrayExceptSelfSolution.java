package leetcode.productOfArrayExceptSelf;

import java.util.Arrays;

public class ProductOfArrayExceptSelfSolution {
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelfSolution().productExceptSelf(input)));
    }

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * Example 2:
     * <p>
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 10^5
     * -30 <= nums[i] <= 30
     * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
     * <p>
     * <p>
     * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /**
         * 对于每个结果都要 从左到右 也要从右到左
         */
        int n = nums.length;
        int[] ans = new int[n];
        //初始化ans都为1
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }
        //左侧
        int L = 1;
        for(int i = 0; i < n; i++){
            ans[i] *= L;
            L *= nums[i];
        }
        //右侧
        int R = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;


    }

    /***
     *
     *         OOM
     *         int[] result = new int[nums.length];
     *         int[][] dp = new int[nums.length][nums.length];
     *         // algorithm : f(x) = f(0 ~ x-1) * f(x+1 ~ nums.length-1);
     *         for (int i = 0; i < nums.length; i++) {
     *             dp[i][i] = nums[i];
     *         }
     *         for (int i = 0; i < nums.length; i++) {
     *             for (int j = i + 1; j < nums.length; j++) {
     *                 dp[i][j] = dp[i][j - 1] * nums[j];
     *             }
     *         }
     *         for (int i = 0; i < nums.length; i++) {
     *             if (i == 0) {
     *                 result[i] = dp[1][nums.length - 1];
     *                 continue;
     *             }
     *             if (i == nums.length - 1) {
     *                 result[i] = dp[0][nums.length - 2];
     *                 continue;
     *             }
     *             result[i] = dp[0][i - 1] * dp[i + 1][nums.length - 1];
     *         }
     *         return result;
     *
     *
     *         int[] result = new int[nums.length];
     *         int numMultiplication = 0;
     *         Arrays.fill(result, 0);
     *         int zeroNum = 0;
     *         int zeroFirst = 0;
     *         for (int i = 0; i < nums.length; i++) {
     *             if (nums[i] == 0) {
     *                 zeroNum++;
     *                 zeroFirst = i;
     *                 if (zeroNum == 2) break;
     *                 continue;
     *             }
     *             if (numMultiplication == 0) {
     *                 numMultiplication = nums[i];
     *                 continue;
     *             }
     *             numMultiplication *= nums[i];
     *         }
     *         if (zeroNum == 2) return result;
     *         if (zeroNum == 1) {
     *             result[zeroFirst] = numMultiplication;
     *             return result;
     *         }
     *         for (int i = 0; i < nums.length; i++) {
     *             result[i] = numMultiplication / nums[i];
     *         }
     *         return result;
     *
     */
}

package leetcode.firstMissingPositive;

import java.util.Arrays;

public class FirstMissingPositiveSolution {

    public static void main(String[] args) {
        int [] input = {1,2,0};
        System.out.println(new FirstMissingPositiveSolution().firstMissingPositive(input));
    }

    /**
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     * <p>
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     * Example 2:
     * <p>
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Explanation: 1 is in the array but 2 is missing.
     * Example 3:
     * <p>
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * Explanation: The smallest positive integer 1 is missing.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length-1] < 0)return 1;
        int positiveNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] == 0) {
                continue;
            }
            positiveNum++;
            if (nums[i] != positiveNum) break;
            while(i< nums.length && nums[i] == positiveNum ) i++;
            i = i-1;
        }
        if(nums[nums.length-1] == positiveNum) positiveNum ++;
        return positiveNum;
    }
}

package leetcode.maxSlidingWindow;

import java.util.Arrays;
import java.util.TreeMap;

public class MaxSlidingWindowSolution {

    public static void main(String[] args) {
        int input [] = {1};
        System.out.println(Arrays.toString(new MaxSlidingWindowSolution().maxSlidingWindow(input,1)));
    }


    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * <p>
     * Return the max sliding window.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int [nums.length - k + 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int i = 0;
        int index = 0;
        while (i < k) {
            treeMap.put(nums[i], treeMap.containsKey(nums[i]) ? treeMap.get(nums[i]) + 1 : 1);
            i++;
        }
        result[index] = treeMap.lastKey();

        while (i < nums.length) {
            Integer count = treeMap.get(nums[i - k]);
            if (count == 1) {
                treeMap.remove(nums[i - k]);
            } else {
                treeMap.put(nums[i - k], treeMap.get(nums[i - k]) - 1);
            }
            treeMap.put(nums[i], treeMap.containsKey(nums[i]) ? treeMap.get(nums[i]) + 1 : 1);
            result[++index] = treeMap.lastKey();
            i++;
        }
        return result;
    }
}

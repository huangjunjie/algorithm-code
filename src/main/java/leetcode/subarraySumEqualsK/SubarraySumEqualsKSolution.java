package leetcode.subarraySumEqualsK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

public class SubarraySumEqualsKSolution {

    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("D:\\idea_project\\algorithm-code\\out\\production\\algorithm_code\\leetcode\\subarraySumEqualsK\\1.txt", Charset.forName("UTF-8")));
            String inputStr = fileReader.readLine();
            String[] subStrings = inputStr.split(",");
            int[] input = new int[subStrings.length];
            for (int i = 0; i < input.length; i++) {
                input[i] = Integer.valueOf(subStrings[i]);
            }
            System.out.println(new SubarraySumEqualsKSolution().subarraySum(input, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     * <p>
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     * <p>
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 2 * 10^4
     * -1000 <= nums[i] <= 1000
     * -10^7 <= k <= 10^7
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // standard resolve

        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     *
     *         OOM
     *
     *         int result = 0;
     *         int[][] sum = new int[10000][10000];
     *         for (int i = 0; i < sum.length - 1; i++) {
     *             Arrays.fill(sum[i], -108);
     *         }
     *
     *         for (int i = 0; i < nums.length; i++) {
     *             for (int j = i; j < nums.length; j++) {
     *                 if (j == i) {
     *                     sum[i][j] = nums[i];
     *                     if (k == sum[i][j]) result++;
     *                     continue;
     *                 }
     *                 sum[i][j] = sum[i][j - 1] + nums[j];
     *                 if (k == sum[i][j]) result++;
     *             }
     *         }
     *         return result;
     *
     *
     *         OOT
     *
     *         public int subarraySum(int[] nums, int k) {
     *         int result = 0;
     *         int[] sum = new int[nums.length];
     *
     *         for (int i = 0; i < nums.length; i++) {
     *             for (int j = i; j < nums.length; j++) {
     *                 if (j == i) {
     *                     sum[j] = nums[i];
     *                     if (k == sum[j]) result++;
     *                     continue;
     *                 }
     *                 sum[j] = sum[j - 1] + nums[j];
     *                 if (k == sum[j]) result++;
     *             }
     *         }
     *         return result;
     *     }
     *
     *
     * 方法四：前缀和 + 哈希表优化
     * 由于只关心次数，不关心具体的解，我们可以使用哈希表加速运算；
     * 由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了O(N)。
     *
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *     best resolve
     *
     *     // key：前缀和，value：key 对应的前缀和的个数
     *         Map<Integer, Integer> preSumFreq = new HashMap<>();
     *         // 对于下标为 0 的元素，前缀和为 0，个数为 1
     *         preSumFreq.put(0, 1);
     *
     *         int preSum = 0;
     *         int count = 0;
     *         for (int num : nums) {
     *             preSum += num;
     *
     *             // 先获得前缀和为 preSum - k 的个数，加到计数变量里
     *             if (preSumFreq.containsKey(preSum - k)) {
     *                 count += preSumFreq.get(preSum - k);
     *             }
     *
     *             // 然后维护 preSumFreq 的定义
     *             preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
     *         }
     *         return count;
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/247577/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * */
}

package jav.leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSolution {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharactersSolution().lengthOfLongestSubstring(s));
    }

    /**
     * Given a string s, find the length of the longest
     * substring
     * without repeating characters.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * <p>
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * <p>
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     *
     *         Set<Character> set = new HashSet<>();
     *         int n = s.length();
     *         int right = 0, left = 0, maxLength = 0;
     *
     *         while (right < n) {
     *             char currentChar = s.charAt(right);
     *             if (!set.contains(currentChar)) {
     *                 set.add(currentChar);
     *                 maxLength = Math.max(maxLength, right - left + 1);
     *                 right++;
     *             } else {
     *                 set.remove(s.charAt(left));
     *                 left++;
     *             }
     *         }
     *
     *         return maxLength;
     *
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> collects = new HashMap<>();
        char[] str = s.toCharArray();
        int leftWindow = 0;
        int rightWindow = 0;
        int nowLength = 0;
        while (rightWindow < str.length) {
            if (collects.containsKey(str[rightWindow])) {
                Integer index = collects.get(str[rightWindow]);
                while (leftWindow <= index) collects.remove(str[leftWindow++]);
                collects.put(str[rightWindow], rightWindow);
                nowLength = rightWindow - index;
                rightWindow++;
            } else {
                collects.put(str[rightWindow], rightWindow);
                nowLength++;
                rightWindow++;
                maxLength = maxLength > nowLength ? maxLength : nowLength;
            }
        }
        return maxLength;
    }
}

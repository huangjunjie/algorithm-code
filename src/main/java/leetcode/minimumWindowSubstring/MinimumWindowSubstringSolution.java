package leetcode.minimumWindowSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinimumWindowSubstringSolution {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(new MinimumWindowSubstringSolution().minWindow(s, t));
    }

    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     * <p>
     * The testcases will be generated such that the answer is unique.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     * <p>
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * <p>
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 10^5
     * s and t consist of uppercase and lowercase English letters.
     * <p>
     * <p>
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
     * <p>
     * <p>
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        char[] sourcesChar = s.toCharArray();
        char[] targetChar = t.toCharArray();
        Arrays.sort(targetChar);
        if (targetChar.length > sourcesChar.length) return "";
        // target index
        Map<Character, Integer> targetCharCountMap = new HashMap<>();
        Map<Character, Integer> targetCharStartIndexMap = new HashMap<>();
        // sources index
        TreeMap<Integer, Character> sourcesIndexCharMap = new TreeMap<>();
        int[] targetCharIndex = new int[targetChar.length];
        Arrays.fill(targetCharIndex, -1);

        int count = 0;
        int allCount = targetChar.length;

        for (int i = 0; i < targetChar.length; i++) {
            targetCharStartIndexMap.putIfAbsent(targetChar[i], i);
            targetCharCountMap.put(targetChar[i], targetCharCountMap.getOrDefault(targetChar[i], 0) + 1);
        }

        int left = 0;
        int right = 0;
        int length = sourcesChar.length;

        for (int i = 0; i < sourcesChar.length; i++) {
            if (targetCharStartIndexMap.containsKey(sourcesChar[i])) {
                int targetCharStartIndex = targetCharStartIndexMap.get(sourcesChar[i]);
                int targetCharCount = targetCharCountMap.get(sourcesChar[i]);
                int[] targetCharIndexNow = Arrays.copyOfRange(targetCharIndex, targetCharStartIndex, targetCharStartIndex + targetCharCount);
                if (targetCharIndexNow[0] == -1) {
                    count++;
                    sourcesIndexCharMap.put(i, sourcesChar[i]);
                } else {
                    sourcesIndexCharMap.remove(targetCharIndexNow[0]);
                    sourcesIndexCharMap.put(i, sourcesChar[i]);
                }
                targetCharIndexNow[0] = i;
                Arrays.sort(targetCharIndexNow);
                System.arraycopy(targetCharIndexNow, 0, targetCharIndex, targetCharStartIndex, targetCharCount);
                if (count == allCount) {
                    int nowLength = sourcesIndexCharMap.lastKey() - sourcesIndexCharMap.firstKey() + 1;
                    if (nowLength <= length) {
                        length = nowLength;
                        left = sourcesIndexCharMap.firstKey();
                        right = sourcesIndexCharMap.lastKey();
                    }
                }
            }
        }
        if(count != allCount) return "";
        return String.valueOf(Arrays.copyOfRange(sourcesChar, left, right + 1));
    }

}

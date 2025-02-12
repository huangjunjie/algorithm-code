package leetcode.findAllAnagramsInAString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindAllAnagramsInAStringSolution {

    public static void main(String[] args) {

        System.out.println(new FindAllAnagramsInAStringSolution().findAnagrams("acdcaeccde", "c"));
    }


    /**
     * Given two strings s and p, return an array of all the start indices of p's
     * anagrams
     * in s. You may return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     * <p>
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s and p consist of lowercase English letters.
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        char[] muster = s.toCharArray();
        char[] target = p.toCharArray();
        List<Integer> result = new ArrayList<Integer>();
        //排序目标
        Arrays.sort(target);
        Set<Character> letterCollect = new HashSet<Character>();
        for (char i : target) letterCollect.add(i);
        int startPoint = 0;
        int indexPoint = 0;
        while (true) {
            while (startPoint < muster.length && !letterCollect.contains(Character.valueOf(muster[startPoint])))
                startPoint++;
            indexPoint = startPoint;
            while (indexPoint < muster.length && indexPoint - startPoint + 1 < target.length && letterCollect.contains(Character.valueOf(muster[indexPoint])))
                indexPoint++;
            // break condition
            if (indexPoint >= muster.length) break;
            // success condition
            if (indexPoint - startPoint + 1 == target.length) {
                char[] compare = Arrays.copyOfRange(muster, startPoint, indexPoint + 1);
                Arrays.sort(compare);
                if (Arrays.compare(compare, target) == 0) {
                    result.add(startPoint);
                }
                startPoint++;
            }
            if (!letterCollect.contains(Character.valueOf(muster[indexPoint]))) {
                startPoint = indexPoint + 1;
            }
        }
        return result;
    }
}

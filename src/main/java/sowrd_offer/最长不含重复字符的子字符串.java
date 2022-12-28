package sowrd_offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *  
     *
     * 提示：
     *
     * s.length <= 40000
     * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> dict = new HashMap<>();
            int result = 0, tmp = 0;
            for(int j = 0; j < s.length(); j++){
                int i = dict.getOrDefault(s.charAt(j), -1);
                dict.put(s.charAt(j), j);
                tmp = tmp < j - i ? tmp + 1 : j - i;
                result = Math.max(result, tmp);
            }
            return result;
        }
    }

    @Test
    public void test(){
        int result = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}

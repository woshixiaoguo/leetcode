package interview_classic_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

/**
 * 3 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 提示：
 * 
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int ans = 0;
        HashMap<Character, Integer> queue = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            while (index < s.length()) {
                char c = s.charAt(index);
                if (queue.containsKey(c)) {
                    // System.out.println(c);
                    int ind = queue.get(c);

                    ans = Math.max(ans, index - i);
                    i = ind;
                    // System.out.println("i: " + i);
                    queue.clear();
                    break;
                }
                queue.put(c, index);
                // queue.forEach((k, v) -> System.out.print("key: " + k + " "));
                // System.out.println();
                index++;
            }
            ans = Math.max(ans, index - i); // 没有触发if语句
            if (index == s.length())
                break;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2)
            return s.length();
        int ans = 0;
        HashMap<Character, Integer> queue = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (queue.containsKey(c)) {
                // System.out.println(c);
                int index = queue.get(c);
                ans = Math.max(ans, right - left);
                // System.out.println("ans: " + ans);
                if (index == left) { // 删除队头
                    // System.out.println(" ==");
                    left = index + 1;
                    queue.remove(c);
                } else {
                    // System.out.println(" !=");
                    for (int i = left; i <= index; i++) {
                        queue.remove(s.charAt(i));
                    }
                    left = index + 1;
                }
                // System.out.println("left: " + left + " right: " + right + " index: " +
                // index);
                // queue.forEach((k, v) -> System.out.print("key: " + k + " "));
                // System.out.println();
                // continue;
            }
            queue.put(c, right);
            // System.out.println("put");
            // queue.forEach((k, v) -> System.out.print("key: " + k + " "));
            // System.out.println();
            right++;
        }
        ans = Math.max(ans, right - left); // 没有触发if语句
        // queue.forEach((k, v) -> System.out.print("key: " + k + " "));
        return ans;

    }

    /**
     * @param s
     * @return length
     *
     *         因为我们已经保证了当前区间没有重复值，当右指针右移一个位置，只需要遍历区间，找出其中与右指针当前元素相同的元素即可(最多1个）。如果存在，这个元素以及其左侧的元素都可以舍弃掉，
     *         左指针 = 相同元素位置+1。
     * 
     *         时间复杂度O(N*∣Σ∣)。因为不重复子串区间长度不会超过ASCII 码字符集的长度∣Σ∣=128，当N足够大时，时间复杂度接近O(N)。
     * 
     *         空间复杂度O(1)。跟官方解法相比，这个解法省去了哈希表占用的空间。
     * 
     * 
     */
    public int lengthOfLongestSubstring3(String s) {
        int left = 0, length = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            for (int k = left; k < right; k++) {
                if (s.charAt(k) == s.charAt(right)) {
                    left = k + 1;
                    length = right - left;
                    break;
                }
            }
            length++;
            if (max < length)
                max = length;
        }
        return max;
    }

    // TODO 使用具有链表属性的双列集合实现
    public int lengthOfLongestSubstring4(String s) {
        if (s.length() < 2)
            return s.length();
        int ans = 0;
        LinkedHashMap<Character, Integer> queue = new LinkedHashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (queue.containsKey(c)) {
                int index = queue.get(c);
                ans = Math.max(ans, right - left);
                // if (index == left) { // 删除队头
                // left = index + 1;
                // queue.remove(c);
                // } else {
                // for (int i = left; i <= index; i++) {
                // queue.remove(s.charAt(i));
                // }
                // left = index + 1;
                // }
            }
            queue.put(c, right);
            right++;
        }
        ans = Math.max(ans, right - left); // 没有触发if语句
        return ans;

    }

    @Test
    public void test() {
        String s = "abcabcbb";
        String s2 = " ";
        String s3 = "aa";
        String s4 = "";
        String s5 = "au";
        String s6 = "pwwkew";
        String s7 = "abba";
        String s8 = "uqinntq";
        int ans = lengthOfLongestSubstring3(s7);
        System.out.println(ans);
    }
}

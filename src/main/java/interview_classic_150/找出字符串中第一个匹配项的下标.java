package interview_classic_150;

import org.junit.Test;

import weekly_match.设计相邻元素求和服务.neighborSum;

/**
 * 28 找出字符串中第一个匹配项的下标
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0
 * 开始）。如果 needle 不是 haystack 的一部分，则返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 
 * 
 * 提示：
 * 
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */

public class 找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        int s = haystack.length();
        if (s < needle.length())
            return -1;
        for (int i = 0; i < s; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) { // 对上第一个字符
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (i + needle.length() > s || haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                System.out.println(j);
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }

    // kmp
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String haystack = "leetcode";
        String needle = "leeto";
        String haystack2 = "sadbutsad";
        String needle2 = "sad";
        String haystack3 = "mississippi";
        String needle3 = "issipi";

        int ans = strStr(haystack3, needle3);
        System.out.println(ans);

    }
}

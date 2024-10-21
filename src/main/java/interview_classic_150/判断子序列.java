package interview_classic_150;

import org.junit.Test;

/**
 * 392 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 
 * 进阶：
 * 
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T
 * 的子序列。在这种情况下，你会怎样改变代码？
 * 
 * 致谢：
 * 
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 
 * 
 * 提示：
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */

public class 判断子序列 {
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        if (n == 0)
            return true;
        int sp = 0, tp = 0;
        for (tp = 0; tp < t.length(); tp++) {
            if (t.charAt(tp) == s.charAt(sp))
                sp++;
            if (sp == n)
                return true;
        }
        return sp == n;
    }

    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    @Test
    public void test() {
        // String s = "abc", t = "ahbgdc";
        // String s1 = "b", t1 = "abc";
        String s2 = "", t2 = "abc";
        boolean res = isSubsequence(s2, t2);
        System.out.println(res);
    }
}

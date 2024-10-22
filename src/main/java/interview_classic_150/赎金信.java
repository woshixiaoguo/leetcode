package interview_classic_150;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 383 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 
 * 如果可以，返回 true ；否则返回 false 。
 * 
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 
 * 
 * 提示：
 * 
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */

public class 赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if (m.containsKey(magazine.charAt(i)))
                m.put(magazine.charAt(i), m.get(magazine.charAt(i)) + 1);
            else
                m.put(magazine.charAt(i), 1);
        }
        int l = 0;
        while (l < ransomNote.length()) {
            if (m.containsKey(ransomNote.charAt(l)) && m.get(ransomNote.charAt(l)) > 0) {
                m.put(ransomNote.charAt(l), m.get(ransomNote.charAt(l)) - 1);
                l++;
            } else
                break;
        }

        return l == ransomNote.length();
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        String ransomNote = "aa", magazine = "aab";
        // String ransomNote2 = "aa", magazine2 = "ab";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
}

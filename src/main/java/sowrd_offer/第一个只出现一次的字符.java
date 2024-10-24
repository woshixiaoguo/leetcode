package sowrd_offer;

import java.util.HashMap;
import java.util.Iterator;
import org.junit.Test;

public class 第一个只出现一次的字符 {
    /**
     *
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * s 只包含小写字母。
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     *
     * 0 <= s 的长度 <= 50000
     *
     * 思路：不能仅排除出现偶次数的字符
     */

    public char firstUniqChar(String s) {
        if (s.length() == 0)
            return ' ';
        int[] array = new int[26];
        // String result = null;
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {

            // System.out.print(character);
            // System.out.println((char)(character+97));
            if (array[i] > 1) {

                s = s.replace((char) (i + 97), ' ');
            }
            // System.out.println(s);
        }
        // System.out.println(result);
        s = s.replace(" ", "");
        if (s.length() != 0)
            return s.charAt(0);
        else
            return ' ';
    }

    // 哈希表
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c))
                return c;
        return ' ';
    }

    @Test
    public void test() {
        // String test = "abeadccdefbf";
        // String test = "";
        // String test = "leetcode";
        String test = "aeaadadaad";
        System.out.println(firstUniqChar2(test));
    }
}

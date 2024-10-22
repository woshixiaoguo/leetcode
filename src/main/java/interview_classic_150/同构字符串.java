package interview_classic_150;

import java.util.ArrayList;
import java.util.HashMap;
// import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 205 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */

/*
 * 不同字符不能指向同一字符，同一字符不能指向多个字符
 */
public class 同构字符串 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m = new HashMap<Character, Character>();
        List<Character> l = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                // 排除同一字符指向不同字符
                if (m.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else { // 键不存在，该字符不指向其他字符
                // 排除不同字符指向同一字符
                if (l.contains(t.charAt(i)))
                    return false;
                m.put(s.charAt(i), t.charAt(i));
                l.add(t.charAt(i));
            }
        }
        m.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) ||
                    (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    @Test
    public void test() {
        // String s = "paper", t = "title";
        String s3 = "paper", t3 = "titls";
        // String s1 = "foo", t1 = "bar";
        // String s2 = "badc", t2 = "baba";
        // String s4 = "baba", t4 = "abab";
        // String s5 = "egg", t5 = "add";
        boolean res = isIsomorphic(s3, t3);
        System.out.println(res);
    }
}

package interview_classic_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 290 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * 
 * 
 * 提示:
 * 
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */

public class 单词规律 {
    public static boolean wordPattern(String pattern, String s) {
        String[] schar = s.split(" ");
        if (schar.length != pattern.length())
            return false;
        Map<String, Character> m = new HashMap<String, Character>();
        List<Character> l = new ArrayList<Character>();
        for (int i = 0; i < schar.length; i++) {
            if (m.containsKey(schar[i])) {
                if (m.get(schar[i]) != pattern.charAt(i))
                    return false;
            } else {
                if (l.contains(pattern.charAt(i)))
                    return false;
                m.put(schar[i], pattern.charAt(i));
                l.add(pattern.charAt(i));
            }
        }
        return true;
    }

    @Test
    public void test() {
        String pattern = "abba", s = "dog cat cat dog";
        // String pattern2 = "abba", s2 = "dog cat cat fish";
        boolean res = wordPattern(pattern, s);
        System.out.println(res);
    }
}

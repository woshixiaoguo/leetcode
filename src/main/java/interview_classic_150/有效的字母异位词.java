package interview_classic_150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/* 242 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。



示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false


提示:

1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母


进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/

public class 有效的字母异位词 {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;
    char[] schar = s.toCharArray();
    char[] tchar = t.toCharArray();
    Arrays.sort(schar);
    Arrays.sort(tchar);
    return Arrays.equals(schar, tchar);
  }

  public static boolean isAnagram2(String s, String t) {
    if (s.length() != t.length())
      return false;
    Map<Character, Integer> table = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      table.put(ch, table.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      table.put(ch, table.getOrDefault(ch, 0) - 1);
      if (table.get(ch) < 0)
        return false;
    }
    return true;
  }

  public static boolean isAnagram3(String s, String t) {
    if (s.length() != t.length())
      return false;
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      table[t.charAt(i) - 'a']--;
      if (table[t.charAt(i)] < 0)
        return false;
    }
    return true;
  }

  @Test
  public void test() {
    String s = "anagram", t = "nagaram";
    boolean res = isAnagram(s, t);
    System.out.println(res);
  }
}

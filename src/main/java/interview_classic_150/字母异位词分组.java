package interview_classic_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/* 49 字母异位词分组

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:

输入: strs = [""]
输出: [[""]]

示例 3:

输入: strs = ["a"]
输出: [["a"]]


提示：

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母 */

public class 字母异位词分组 {

    // 利用哈希表记录排序后的字符串的分组位置
    // 435ms 46.3MB
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> table = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (table.contains(s)) {
                int index = table.indexOf(s);
                res.get(index).add(strs[i]);

            } else {
                table.add(s);
                res.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        return res;
    }

    // 哈希表改进
    // 429ms 46.3MB
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> table = new ArrayList<String>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            int index = table.indexOf(s);

            boolean b = index == -1 ? res.add(new ArrayList<>(Arrays.asList(str))) && table.add(s)
                    : res.get(index).add(str);
        }

        return res;
    }

    // 使用表记录键的同时，保存值的分组
    // 6ms 46.7MB
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 计数
    // 12ms 47.1mB
    public List<List<String>> groupAnagrams4(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test() {
        // String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = { "aaeat", "teaaa", "tan", "aaate", "nat", "bat" };
        List<List<String>> res = groupAnagrams4(strs);
        for (List<String> l : res) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}

package interview_classic_150;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 151 反转字符串中的单词
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * 
 * 输入：s = "a good example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 
 * 
 * 提示：
 * 
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 
 * 
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */

public class 反转字符串中的单词 {

    // 快慢指针 栈排序 5ms 72.47%
    public String reverseWords(String s) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        Stack<String> stack = new Stack<>();

        while (right < l) {
            while (right < l && s.charAt(right) == ' ') { // 先判断位置，再取值
                right++;
            }
            if (right == l)
                break;
            left = right;
            while (right < l && s.charAt(right) != ' ') {
                right++;
            }
            stack.push(s.substring(left, right));
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
            if (!stack.empty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 利用空格字符分割字符串 5ms 72.47%
    public String reverseWords2(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int l = split.length - 1;
        for (int i = l; i >= 0; i--) {
            System.out.print("||");
            System.out.print(split[i]);
            System.out.print("||");
            if (!split[i].equals("")) {
                if (i != l) { // 只能判断队尾，判断对头会遇到空字符串
                    sb.append(" ");
                    System.out.println("append");
                }
                sb.append(split[i]);
            }
            System.out.println(i);
        }
        return sb.toString();
    }

    public String reverseWords3(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    @Test
    public void test() {
        String s = "the sky is blue";
        String s2 = " hello world ";
        String s3 = "  hello  world  ";

        String ans = reverseWords3(s3);
        System.out.print("||");
        System.out.print(ans);
        System.out.print("||");

    }
}

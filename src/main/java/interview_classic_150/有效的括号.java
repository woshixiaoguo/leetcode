package interview_classic_150;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

/**
 * 20 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 示例 1：
 * 
 * 输入：s = "()"
 * 
 * 输出：true
 * 
 * 示例 2：
 * 
 * 输入：s = "()[]{}"
 * 
 * 输出：true
 * 
 * 示例 3：
 * 
 * 输入：s = "(]"
 * 
 * 输出：false
 * 
 * 示例 4：
 * 
 * 输入：s = "([])"
 * 
 * 输出：true
 * 
 * 提示：
 * 
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */

public class 有效的括号 {

    public boolean isValid(String s) {
        HashMap<Character, Character> table = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!table.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || stack.pop() != table.get(c)) // 不需要再pop()，如果用stack.peek() 则需要在pop()
                    return false;
            }
        }
        return stack.empty();
    }

    @Test
    public void test() {
        String s = "(]";
        String s2 = "([])";
        String s3 = "()";
        boolean ans = isValid(s3);
        System.out.println(ans);

    }
}

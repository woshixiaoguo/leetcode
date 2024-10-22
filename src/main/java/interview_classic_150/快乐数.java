package interview_classic_150;

import java.util.Stack;
import org.junit.Test;

/*
 * 202 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 */

public class 快乐数 {

    // 超出时间限制
    static boolean isHappy(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            stack.push((int) s.charAt(i));
        }

        int sum = 0;
        while (sum != 1) {
            while (!stack.isEmpty()) {
                sum += (int) Math.pow(stack.pop(), 2);
            }
            if (sum == 1)
                return true;
            else {
                int length = (int) (Math.log10(sum) + 1);
                for (int i = 0; i < length; i++) {
                    stack.push(sum % 10);
                    sum /= 10;
                }
            }
        }
        return false;
    }

    // 使用哈希表找循环
    boolean isHappy2(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        // 内存消耗 Stack < ArrayList < HashSet
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (stack.contains(sum))
                return false;
            else
                stack.push(sum);
            n = sum;
        }
        return true;
    }

    // 快慢指针
    boolean isHappy3(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) { // 可能存在循环
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    // 整数取位数
    @Test
    public void get_bit_of_integer() {
        int n = 5812041;
        int length = (int) (Math.log10(n) + 1);
        for (int i = 0; i < length; i++) {
            System.out.print(i + " ");
            System.out.println(n % 10);
            n = n / 10;
        }
    }

    @Test
    public void test() {
        int n = 19;
        boolean res = isHappy3(n);
        System.out.println(res);
    }
}

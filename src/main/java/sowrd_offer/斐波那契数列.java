package sowrd_offer;

import org.junit.Test;

public class 斐波那契数列 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：5
     *  
     *
     * 提示：
     *
     * 0 <= n <= 100
     *
     *
     */

    // 方法一：使用动态数组 时间复杂度 O(1)，空间复杂度 O(n)
    class Solution {
        public int fib(int n) {
            final int MOD = 1000000007;
            if(n < 2) return n;

            int p, q = 0, r = 1;

            for(int i = 2; i <= n; i++){
                p = q;
                q = r;
                r = (p+q)%MOD;
            }
            return r;
        }
    }

    @Test
    public void test(){
        int result = new Solution().fib(44);
        System.out.println(result);
    }
}

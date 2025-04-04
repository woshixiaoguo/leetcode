package sowrd_offer;

import org.junit.Test;

public class 青蛙跳台阶问题 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 提示：
     *
     * 0 <= n <= 100
     * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
     *
     */

    class Solution {
        public int numWays(int n) {
            final int MOD = 1000000007;
            if(n < 2) return 1;
            int p = 0, q =1 , r = 2;
            for(int i = 3; i <= n; i++)
            {
                p = q;
                q = r;
                r = (p+q)%MOD;
            }
            return r;
        }
    }

    @Test
    public void test(){
        int result = new Solution().numWays(4);
        System.out.println(result);
    }
}

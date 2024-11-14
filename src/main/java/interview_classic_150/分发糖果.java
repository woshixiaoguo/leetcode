package interview_classic_150;

import org.junit.Test;

/**
 * 135 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * 
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * 
 * 
 * 提示：
 * 
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */

public class 分发糖果 {
    public int candy(int[] ratings) {
        int ans = 0;
        int l = ratings.length;
        int[] candy = new int[l];
        candy[0] = 1;
        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1])
                candy[i] = candy[i - 1] + 1;
            else
                candy[i] = 1;
        }
        // for (int i = 0; i < l; i++) {
        // System.out.print(candy[i] + " ");
        // }
        // System.out.println();
        ans = candy[l - 1];
        for (int i = l - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1])
                candy[i] = candy[i + 1] + 1; // 比后面大时不用变
            ans += candy[i];
            // System.out.println("ans: "+ans);
        }
        // for (int i = 0; i < l; i++) {
        // System.out.print(candy[i]+" ");
        // }
        return ans;
    }

    @Test
    public void test() {
        int[] ratings = { 1, 0, 2 };
        int[] ratings2 = { 1, 2, 2 };
        int[] ratings3 = { 1, 3, 4, 5, 2 };
        int[] ratings4 = { 1, 2, 87, 87, 87, 2, 1 };
        int ans = candy(ratings);
        System.out.println(ans);

    }
}

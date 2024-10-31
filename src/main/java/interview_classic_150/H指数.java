package interview_classic_150;

import java.util.Arrays;

import org.junit.Test;

/**
 * 274 H指数
 *
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h
 * 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * 
 * 输入：citations = [1,3,1]
 * 输出：1
 * 
 * 
 * 提示：
 * 
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */

public class H指数 {

    public int hIndex(int[] citations) {
        /**
         * 查找不满足引用次数的论文数
         * 达到一定数量时，降低引用次数
         */

        int max = citations.length;
        int l = max;
        while (max != 0) {
            int temp = 0;
            int i;
            for (i = 0; i < l; i++) {
                if (citations[i] < max) {
                    temp++;
                    if (temp > l - max)
                        break;
                }
            }
            if (i == l)
                return max;
            max--;
        }
        return max;
    }

    // 排序 时间 O(nlogn) 空间O(logn)
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int max = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > max) {
            max++;
            i--;
        }
        return max;

    }

    // 计数排序 时间 O(n) 空间O(n)
    public int hIndex3(int[] citations) {
        /**
         * 创建一个数组用于保存相同引用次数的论文有几篇
         * 然后反向遍历，查询篇数大于引用数的零界点
         */
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    // 二分搜索 时间O(nlogn) 空间O(1)
    public int hIndex4(int[] citations) {
        /**
         * 二分的是 h 的值，不是数组下标
         */
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;
        while (left < right) {
            // +1 防止死循环
            mid = (left + right + 1) >> 1;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                // 要找的答案在 [mid,right] 区间内
                left = mid;
            } else {
                // 要找的答案在 [0,mid) 区间内
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] citations = { 3, 0, 6, 1, 5 };
        int[] citations2 = { 1, 3, 1 };
        int ans = hIndex4(citations);
        System.out.println(ans);

    }
}

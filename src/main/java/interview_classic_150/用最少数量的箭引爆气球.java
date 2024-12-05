package interview_classic_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 452 用最少数量的箭引爆气球
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend]
 * 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足
 * xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 
 * 
 * 示例 1：
 * 
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * 
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * 
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * 
 * 
 * 
 * 提示:
 * 
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 */

public class 用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> a[0] - b[0]);
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> table = new ArrayList<int[]>();
        for (int i = 0; i < points.length; i++) {
            int l = points[i][0];
            int r = points[i][1];
            System.out.println(l + " " + r);
            if (table.size() == 0 || l > table.get(table.size() - 1)[1]) {
                table.add(new int[] { l, r });
            } else {
                table.get(table.size() - 1)[0] = l;
                table.get(table.size() - 1)[1] = Math.min(r, table.get(table.size() - 1)[1]);
            }
        }
        return table.size();
    }

    /**
     * 后一个区间如果和前面某个区间有交集，说明它并不会贡献一次新的射击，因为可以和其他区间一块射击
     * 这样我们就可以按照区间右端点排序，这样距离当前区间左端点最近的右端点就是前一个区间的右端点
     * 只有当前区间左端点大于前一个区间右端点时才不相交，所以需要新增一次射击
     * 
     * @param points
     * @return
     */
    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

        int[][] points2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        int[][] points3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int[][] points4 = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };

        int ans = findMinArrowShots(points4);
        System.out.println(ans);

    }
}

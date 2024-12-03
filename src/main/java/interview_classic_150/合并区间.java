package interview_classic_150;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * 56 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start_i, end_i]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 提示：
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start_i <= end_i <= 10^4
 */

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, new Comparator<int[]>() {
        // public int compare(int[] a, int[] b) {
        // return a[0] - b[0];
        // }
        // });
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (arrayList.size() == 0 || arrayList.get(arrayList.size() - 1)[1] < l) {
                arrayList.add(new int[] { l, r });
            } else {
                if (arrayList.get(arrayList.size() - 1)[1] < r) {
                    arrayList.get(arrayList.size() - 1)[1] = r;
                }
            }
        }
        return arrayList.toArray(new int[arrayList.size()][]);
    }

    @Test
    public void test() {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] ans = merge(intervals);
        for (int[] row : ans) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }
}

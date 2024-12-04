package interview_classic_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 57 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i
 * 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end]
 * 表示另一个区间的开始和结束。
 * 
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti
 * 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 
 * 返回插入之后的 intervals。
 * 
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 * 提示：
 * 
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals 根据 starti 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */

public class 插入区间 {

    // 插入后排序
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][];
        System.arraycopy(intervals, 0, newArr, 1, intervals.length);
        newArr[0] = newInterval;
        Arrays.sort(newArr, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < newArr.length; i++) {
            int l = newArr[i][0];
            int r = newArr[i][1];
            if (arrayList.size() == 0 || arrayList.get(arrayList.size() - 1)[1] < l) {
                arrayList.add(new int[] { l, r });
            } else {
                if (arrayList.get(arrayList.size() - 1)[1] < r) {
                    arrayList.get(arrayList.size() - 1)[1] = r;
                }
            }
        }
        return arrayList.toArray(new int[arrayList.size()][]);

        // return newArr;
    }

    // 二分查找
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            int[][] ans = new int[1][];
            ans[0] = newInterval;
            return ans;
        }
        int l = 0, r = intervals.length - 1;
        int pivot = newInterval[0];
        int index = 0;
        while (l < r) { // 查找开始合并的区间
            index = (l + r) / 2;
            // System.out.println(index);
            if (intervals[index][1] > pivot) {
                r = index - 1;
            } else {
                l = index + 1;
            }
        }

        int[][] ans = new int[length][];

        // TODO
        //
        // if (pivot > intervals[l][1]) {
        // int[][] ans = new int[length + 1][];
        // System.arraycopy(intervals, 0, ans, 0, length);
        // ans[length] = newInterval;
        // return ans;
        // }
        // int start = Math.min(pivot, intervals[l][0]);
        // int end = newInterval[1];
        // int i;
        // for (i = l; i < intervals.length; i++) {
        // if (end > intervals[i][1]) {
        // continue;
        // } else {
        // if (end >= intervals[i][0]) {
        // end = intervals[i][1];
        // length = intervals.length - (i - l);
        // i++;
        // } else {
        // length = intervals.length - (i - l - 1);
        // }
        // break;
        // }
        // }
        // // System.out.println("length: " + length);
        // int[][] ans = new int[length][];
        // System.arraycopy(intervals, 0, ans, 0, l);
        // System.out.println(l);
        // ans[l] = new int[] { start, end };
        // System.arraycopy(intervals, i, ans, l + 1, length - l - 1);

        return ans;
    }

    public int[][] insert3(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[] { left, right });
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[] { left, right });
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] intervals2 = { { 1, 5 } };
        int[] newInterval2 = { 2, 7 };
        int[][] ans = insert3(intervals2, newInterval2);
        for (int[] row : ans) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }
}

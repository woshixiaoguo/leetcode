package weekly_match;

import java.util.ArrayList;
import org.junit.Test;

/* 给你一个整数 n 和一个二维整数数组 queries。

有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i +
1（ 0 <= i < n - 1）。

queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi
的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。

返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i]
是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。



示例 1：

输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]]

输出： [3, 2, 1]

https://assets.leetcode.com/uploads/2024/06/28/image8.jpg

新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。

https://assets.leetcode.com/uploads/2024/06/28/image9.jpg

新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。

https://assets.leetcode.com/uploads/2024/06/28/image10.jpg

新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。

示例 2：

输入： n = 4, queries = [[0, 3], [0, 2]]

输出： [1, 1]

解释：

https://assets.leetcode.com/uploads/2024/06/28/image11.jpg

新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。

https://assets.leetcode.com/uploads/2024/06/28/image12.jpg

新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。

提示：

3 <= n <= 500
1 <= queries.length <= 500
queries[i].length == 2
0 <= queries[i][0] < queries[i][1] < n
1 < queries[i][1] - queries[i][0]
查询中没有重复的道路。
 */

public class 新增道路查询后的最短距离I {

  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    ArrayList<Integer> table = new ArrayList<Integer>();
    int max = n - 1;
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int s = queries[i][1] - queries[i][0];
      max = Math.min(max, (max - s + 1));
      if (max > (max - s + 1)) {
        table.add(queries[i][0]);
        table.add(queries[i][1]);
        max = (max - s + 1);
      }

      res[i] = max;
    }
    return new int[-1];
  }

  @Test
  public void test() {}
}

package sowrd_offer;

import org.junit.Test;

public class 礼物的最大价值 {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     *  
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *  
     *
     * 提示：
     *
     * 0 < grid.length <= 200
     * 0 < grid[0].length <= 200
     *
     *
     */


    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 && j == 0) continue;
                    if(i == 0) grid[i][j] += grid[i][j-1];
                    else if(j == 0) grid[i][j] += grid[i-1][j];
                    else grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
            return grid[m-1][n-1];
        }
    }

    @Test
    public void test(){
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1},
        };
        int result = new Solution().maxValue(grid);
        System.out.println(result);
    }
}

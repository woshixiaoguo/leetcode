package interview_classic_150;

import java.util.HashMap;

import org.junit.Test;

/**
 * 289 生命游戏
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞
 * （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board
 * 的当前状态，返回下一个状态。
 * 
 * 给定当前 board 的状态，更新 board 到下一个状态。
 * 
 * 注意 你不需要返回任何东西。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/26/grid1.jpg"/>
 * 
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/26/grid2.jpg"/>
 * 
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 * 
 * 
 * 提示：
 * 
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 * 
 * 进阶：
 * 
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * 
 */

public class 生命游戏 {

    HashMap<Integer, Integer> table = new HashMap<Integer, Integer>(); // HashMap 比 HashSet 快

    /**
     * 使用 hash记录状态改变过的格子
     * 
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = checkNeighbor(board, i, j, m, n);
                if (board[i][j] != live) {
                    table.put(i * 25 + j, 0);
                    board[i][j] = live;
                    // System.out.println("change");
                }
            }
        }
    }

    public int checkNeighbor(int[][] board, int x, int y, int m, int n) {
        int sum = 0;

        int r = Math.min(x + 2, m);
        int c = Math.min(y + 2, n);
        // System.out.println(x + ", " + y);
        for (int i = Math.max(x - 1, 0); i < r; i++) {
            for (int j = Math.max(y - 1, 0); j < c; j++) {
                // System.out.println("i: " + i + ", j: " + j);
                if (i == x && j == y)
                    continue;
                if (table.containsKey(i * 25 + j)) {
                    if (board[i][j] < 1)
                        sum++;
                } else {
                    if (board[i][j] > 0)
                        sum++;
                }
            }
        }
        // System.out.println(sum);
        if (board[x][y] > 0 && (sum == 2 || sum == 3)) {
            return 1;
        } else if (sum == 3)
            return 1;
        return 0;

    }

    @Test
    public void test() {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        int[][] board2 = { { 1, 1 }, { 1, 0 } };
        gameOfLife(board);
        for (int[] row : board) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}

package interview_classic_150;

import org.junit.Test;

/**
 * 130 被围绕的区域
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * 
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 * 
 * 示例 1：
 * 
 * 输入：board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 
 * 解释：
 * 
 * <img src="https://pic.leetcode.cn/1718167191-XNjUTG-image.png"/>
 * 
 * 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。
 * 
 * 示例 2：
 * 
 * 输入：board = [["X"]]
 * 
 * 输出：[["X"]]
 * 
 * 提示：
 * 
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */

public class 被围绕的区域 {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == board.length - 1)
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j);
                }
            else {
                for (int j = 0; j < board[0].length; j += board[0].length - 1) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }

        }

    }

    public void dfs(char[][] board, int r, int c) {
        int h = board.length;
        int w = board[0].length;
        if (r < 0 || c < 0 || r >= h || c >= w || board[r][c] == 'X' || board[r][c] == '1')
            return;
        board[r][c] = '1';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }

    @Test
    public void test() {
        char[][] board = {
                { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' }
        };

        solve(board);
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

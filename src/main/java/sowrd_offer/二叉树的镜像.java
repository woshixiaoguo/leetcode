package sowrd_offer;

import org.junit.Test;

public class 二叉树的镜像 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 从根结点开始转换
         * @param root
         * @return
         */
        public TreeNode mirrorTree(TreeNode root) {
            if(root ==null) return null;
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }
    }

    @Test
    public void test() {
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(7);
        TreeNode C = new TreeNode(2);
        A.left = B;
        A.right = C;
        B.left = new TreeNode(9);
        B.right = new TreeNode(6);
        C.left = new TreeNode(3);
        C.right = new TreeNode(1);
        new Solution().mirrorTree(A);

    }
}

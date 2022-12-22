package sowrd_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树2
{
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     */


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int length = queue.size();
                for(int i = 0; i < length; i++){
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(level);
            }
            return result;
        }
    }

    @Test
    public void test(){
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(9);
        TreeNode C = new TreeNode(20);
        A.left = B;
        A.right = C;
        C.left = new TreeNode(15);
        C.right = new TreeNode(7);
        List<List<Integer>> result = new Solution().levelOrder(A);
        for(int i = 0; i < result.size(); i++){
            List<Integer> level = result.get(i);
            for(int j = 0; j < level.size(); j++)
            {
                System.out.print(level.get(j)+" ");
            }
            System.out.println();
        }
    }
}

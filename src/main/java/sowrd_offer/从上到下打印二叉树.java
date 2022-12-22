package sowrd_offer;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class 从上到下打印二叉树 {
    /**
     *
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *  3
     * / \
     * 9 20
     * / \
     * 15 7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     *
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        int[] res;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);

        res = new int[arr.length];
        for(int i = 0; i < arr.length; i ++)
            res[i] = arr[i];
        return res;
    }



    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int[] result = levelOrder(node1);
        for (int num:result
             ) {
            System.out.println(num);
        }


    }

}


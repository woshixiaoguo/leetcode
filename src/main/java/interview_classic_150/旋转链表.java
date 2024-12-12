package interview_classic_150;

import java.util.ArrayList;

import org.junit.Test;

import ds.ListNode;

/**
 * 61 旋转链表
 * 
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg">
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg">
 * 
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 
 * 提示：
 * 
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 218
 */

public class 旋转链表 {

    // 1ms 9.69% 41.69MB 7.53%
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) // 超过两个元素时，才可旋转
            return head;
        ArrayList<ListNode> table = new ArrayList<ListNode>();
        while (head != null) {
            table.add(head);
            head = head.next;
        }
        if (k % table.size() == 0 || k == 0)
            return table.get(0);
        int index = k % table.size();
        table.get(table.size() - 1).next = table.get(0);
        table.get(table.size() - index - 1).next = null;
        return table.get(table.size() - index);
    }

    // 0ms 100.00% 41.49MB 60.31%
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) // 超过两个元素时，才可旋转
            return head;
        ArrayList<ListNode> table = new ArrayList<ListNode>();
        while (head != null) {
            table.add(head);
            head = head.next;
        }
        if (k % table.size() == 0)
            return table.get(0);
        int index = k % table.size();
        table.get(table.size() - 1).next = table.get(0);
        table.get(table.size() - index - 1).next = null;
        return table.get(table.size() - index);
    }

    // 0ms 100.00% 41.54MB 40.16%
    public ListNode rotateRight3(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    @Test
    public void test() {
        // int[] headarr = { 0, 1, 2 };
        // int[] headarr = { 1 };
        int[] headarr = { 1, 2, 3, 4, 5 };

        // int[] headarr = { 1, 2 };
        int k = 2;
        // int k = 4;
        // int k = 1;
        // int k = 10;
        ListNode head = ListNode.arrToNode(headarr);

        ListNode res = rotateRight(head, k);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

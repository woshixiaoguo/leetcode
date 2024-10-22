package interview_classic_150;

import org.junit.Test;

/**
 * 82 删除排序链表中的重复元素interview_classic_150
 * 
 * 给定一个已排序的链表的头 head ，
 * 删除原始链表中所有重复数字的节点，只留下不同的数字
 * 。返回 已排序的链表 。
 * 
 * 示例 1：
 *
 * <img src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg">
 * 
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg">
 * 
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 
 * 
 * 提示：
 * 
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */

public class 删除排序链表中的重复元素II {

    // 会错题意
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int step = 0;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                step++;

                continue;
            }
            if (step > 1) {
                slow.next = fast;
                slow = fast;
                step = 0;
            } else {
                slow = fast;
            }
        }
        return head;
    }

    // 0ms 100.00% 42.32MB 7.48%
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode headp = new ListNode(-101, head);
        ListNode pre = headp;
        ListNode fast = head;
        ListNode slow = head;
        int step = 0;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                step++;
                continue;
            }
            if (step > 1) {
                pre.next = fast;
                slow = fast;
                step = 0;
            } else {
                pre = pre.next;
                slow = fast;
                step = 0;
            }
        }
        if (step > 1) { // 重复元素结尾，快慢指针元素相同，未触发删除
            pre.next = fast;
        }
        return headp.next;
    }

    //
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) { // 后两个节点值相等
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) { // 连续删除该值
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    @Test
    public void test() {
        // int[] headarr = {1, 2, 2, 3, 4, 4, 5};
        // int[] headarr = {1, 2, 3, 3, 4, 4, 5};
        int[] headarr = { 1, 1, 1, 2, 3 };
        // int[] headarr = { 1, 1 };
        ListNode head = ListNode.arrToNode(headarr);
        ListNode res = deleteDuplicates2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

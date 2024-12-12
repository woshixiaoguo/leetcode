package interview_classic_150;

import org.junit.Test;

import ds.ListNode;

/**
 * 
 * 86 分隔链表
 * 
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg">
 * 
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * 
 * 提示：
 * 
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= -200
 * 
 */

public class 分隔链表 {

    // 0ms 100.00% 41.11MB 37.53%
    public ListNode partition(ListNode head, int x) {
        // if (head == null || head.next == null) // 后面两个 while 均有做判断，因此不需要
        // return head;
        ListNode hp = new ListNode(-1, head); // 头节点有可能被替换，因此要保留头节点的前一个节点
        ListNode xp = hp;
        while (xp.next != null) {
            if (xp.next.val >= x)
                break;
            xp = xp.next;
        }
        // System.out.println("hp: " + xp.val);
        ListNode rightHead = xp;
        while (rightHead != null && rightHead.next != null) {
            if (rightHead.next.val < x) {
                ListNode rightTail = rightHead.next.next;

                ListNode leftTail = xp.next;

                // System.out.println("leftTail: " + leftTail.val);
                xp.next = rightHead.next;
                xp.next.next = leftTail;
                xp = xp.next;

                rightHead.next = rightTail;

            } else {

                rightHead = rightHead.next; // 可能会出现连续小于特定值，因此交换后不用移动指针
            }
        }

        return hp.next;
    }

    // 0ms 100.00% 41.41MB 11.84%
    // 直观来说我们只需维护两个链表 small 和 large 即可，small 链表按顺序存储所有小于 x 的节点，
    // large 链表按顺序存储所有大于等于 x 的节点。遍历完原链表后，
    // 我们只要将 small 链表尾节点指向 large 链表的头节点即能完成对链表的分隔。

    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    @Test
    public void test() {
        int[] headarr = { 1, 4, 3, 2, 5, 2 };
        // int[] headarr = { 2, 1 };
        // int[] headarr = { 1, 4, 3, 0, 2, 5, 2 };

        // int x = 3;
        // int x = 2;
        int x = 3;
        ListNode head = ListNode.arrToNode(headarr);
        // ListNode head = null;
        ListNode res = partition(head, x);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

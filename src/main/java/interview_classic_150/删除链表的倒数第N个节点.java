package interview_classic_150;

import java.util.ArrayList;

import org.junit.Test;

import ds.ListNode;

/**
 * 19 删除链表的倒数第N个节点
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg">
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 * 
 * 提示：
 * 
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class 删除链表的倒数第N个节点 {

    // 0ms 100.00% 40.95MB 5.62%
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> table = new ArrayList<ListNode>();
        ListNode headp = head;
        while (headp != null) {
            table.add(headp);
            headp = headp.next;
        }
        int index = table.size() - n;
        if (index > 0) {
            ListNode node = table.get(table.size() - n);
            ListNode pre = table.get(table.size() - n - 1);
            pre.next = node.next;
            return head;
        } else {
            return head.next;
        }
    }

    // 双指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) { // 判断尾节点需要多走一步，因此second从dummy开始走。
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    @Test
    public void test() {
        int[] headarr = { 1, 2, 3, 4, 5 };
        int n = 2;
        ListNode head = ListNode.arrToNode(headarr);
        ListNode res = removeNthFromEnd(head, n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

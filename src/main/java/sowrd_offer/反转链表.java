package sowrd_offer;

import org.junit.Test;

public class 反转链表 {

    /**
     * 反转链表
     *
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 迭代解法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归解法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    @Test
    public void test(){
        ListNode list = new ListNode(2);
        list.next = new ListNode(3);

        ListNode result = reverseList(list);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

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

    public ListNode reverseList(ListNode head) {

    }

    @Test
    public void test(){
        ListNode list = new ListNode(2);
        list.next = new ListNode(3);
        System.out.println(list.val);
        System.out.println(list.next.val);
    }
}

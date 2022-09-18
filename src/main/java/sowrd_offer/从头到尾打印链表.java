package sowrd_offer;

import org.junit.Test;

import java.util.Stack;

public class 从头到尾打印链表 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * 0 <= 链表长度 <= 10000
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
//        if(head == null){
//            return null;
//        }
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    @Test
    public void test(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int[] result = reversePrint(node);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}

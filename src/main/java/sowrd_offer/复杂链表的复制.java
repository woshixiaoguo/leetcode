package sowrd_offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {
    /**
     *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     *  -10000 <= Node.val <= 10000
     *  Node.random 为空（null）或指向链表中的节点。
     *  节点数目不超过 1000 。
     */

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }


    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();

        Node node = new Node(head.val);
        nodeMap.put(head, node);
        Node prev = node;   // 指向复制链表
        Node curr = head.next; // 指向原链表
        while(curr != null ){

            Node nextNode = new Node(curr.val);
            nodeMap.put(curr, nextNode);
            prev.next = nextNode;
            prev = nextNode;
            curr = curr.next;

        }

        prev = node;
        while(head != null){
            if(head.random != null){

                Node node_random = nodeMap.get(head.random);
                System.out.println("random: "+node_random.val);
                prev.random = node_random;
            }
            head = head.next;
            prev = prev.next;

        }

        return node;
    }

    // 回溯解法
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    //迭代解法
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }



    @Test
    public void test(){
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node result = copyRandomList(node1);
        while(result != null){
            System.out.print(result.val);
            if(result.random != null){

                System.out.println(" "+result.random.val);
            }else{
                System.out.println();
            }
            result = result.next;
        }
    }
}

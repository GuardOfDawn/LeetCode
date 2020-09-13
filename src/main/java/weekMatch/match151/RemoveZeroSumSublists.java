package weekMatch.match151;

public class RemoveZeroSumSublists {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RemoveZeroSumSublists removeZeroSumSublists = new RemoveZeroSumSublists();
        removeZeroSumSublists.removeZeroSumSublists(node);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head != null) {
            ListNode turn = head;
            ListNode prevTurn = head;
            while (turn != null) {
                ListNode cur = turn;
                ListNode pre = turn;
                int add = 0;
                while (cur != null) {
                    if (cur.val == 0) {
                        if (pre == cur) {
                            if (prevTurn == head) {
                                head = head.next;
                            } else {
                                prevTurn.next = cur.next;
                            }
                        } else {
                            pre.next = cur.next;
                        }
                        return removeZeroSumSublists(head);
                    }
                    add += cur.val;
                    if (add == 0) {
                        if (turn == head) {
                            return removeZeroSumSublists(cur.next);
                        } else {
                            prevTurn.next = cur.next;
                            return removeZeroSumSublists(head);
                        }
                    } else {
                        pre = cur;
                        cur = cur.next;
                    }
                }
                prevTurn = turn;
                turn = turn.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

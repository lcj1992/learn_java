package ds.list;


import common.ListNode;
import common.Utils;
import org.junit.Test;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/6/4
 */
public class AddTwoNumbersTest {

    @Test
    public void test() {
        ListNode l1OneNode = new ListNode(2);
        ListNode L1TwoNode = new ListNode(4);
        ListNode L1ThreeNode = new ListNode(3);
        l1OneNode.next = L1TwoNode;
        L1TwoNode.next = L1ThreeNode;

        ListNode l2OneNode = new ListNode(5);
        ListNode l2TwoNode = new ListNode(6);
        ListNode l2ThreeNode = new ListNode(4);
        l2OneNode.next = l2TwoNode;
        l2TwoNode.next = l2ThreeNode;

        ListNode listNode = addTwoNumbers(l1OneNode, l2OneNode);
        Utils.printListNode(listNode);
    }


    /**
     * 反转入参的两个链表
     * 然后逐节点相加
     * 最后再反转链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = null;
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }

}
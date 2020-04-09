package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

import java.util.HashSet;
import java.util.Set;


/**
 * 检查链表是否存在环，存在返回换的入口，不存在返回空
 * 不利用额外空间的解法？
 *
 * @author kangxiongwei
 * @date 2020-04-08 21:57
 */
public class ListNodeDetectCycleSolution {

    public static void main(String[] args) {
        ListNodeDetectCycleSolution solution = new ListNodeDetectCycleSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        ListNode listNode = solution.detectCycle(node1);
        System.out.println(listNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode cycle = cycle(head);
        if (cycle == null) {
            return null;
        }
        //从头出发和从相遇点出发，每次走一步，第一次相遇点就是入口
        ListNode fast = head;
        ListNode slow = cycle;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode cycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }

}

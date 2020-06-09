package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

/**
 * 2.两数相加
 *
 * @author kangxiongwei
 * @date 2020-06-09 15:35
 */
public class TwoNumberAddSolution {

    public static void main(String[] args) {
        TwoNumberAddSolution solution = new TwoNumberAddSolution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode left = l1;
        ListNode right = l2;
        ListNode node = head;
        //公共的部分
        int nextVal = 0;
        while (left != null && right != null) {
            int val = left.val + right.val + nextVal;
            node.next = new ListNode(val % 10);
            nextVal = val / 10;             //进位值
            left = left.next;
            right = right.next;
            node = node.next;
        }
        //多余的部分
        while (left != null) {
            int val = left.val + nextVal;
            node.next = new ListNode(val % 10);
            nextVal = val / 10;
            left = left.next;
            node = node.next;
        }
        while (right != null) {
            int val = right.val + nextVal;
            node.next = new ListNode(val % 10);
            nextVal = val / 10;
            right = right.next;
            node = node.next;
        }
        while (nextVal != 0) {
            node.next = new ListNode(nextVal);
            nextVal = 0;
        }
        return head.next;
    }


}

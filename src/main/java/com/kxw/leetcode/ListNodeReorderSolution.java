package com.kxw.leetcode;

import com.kxw.leetcode.factory.ListNodeFactory;
import com.kxw.leetcode.model.ListNode;

/**
 * 给定链表重排序
 *
 * @author kangxiongwei
 * @date 2020-04-05 12:53
 */
public class ListNodeReorderSolution {

    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNodeReorderSolution solution = new ListNodeReorderSolution();
        solution.reorderList(listNode);
        System.out.println(listNode);
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode midNext = slow.next;
        //翻转后面的列表
        while (midNext != null && midNext.next != null) {
            ListNode nextNode = midNext.next;
            midNext.next = nextNode.next;
            nextNode.next = middle.next;
            middle.next = nextNode;
        }
        //重新排序
        slow = head;
        fast = middle.next;
        middle.next = null;
        ListNode node = head;
        while (slow != null && fast != null) {
            //添加前半部分
            ListNode slowNext = slow.next;
            slow.next = null;
            node.next = slow;
            slow = slowNext;
            node = node.next;
            //添加后半部分
            ListNode fastNext = fast.next;
            fast.next = null;
            node.next = fast;
            fast = fastNext;
            node = node.next;
        }
        //对于奇数的处理
        if (slow != null) {
            slow.next = null;
            node.next = slow;
        }
    }


}

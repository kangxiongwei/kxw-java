package com.kxw.leetcode;

import com.kxw.leetcode.model.ListNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * 给定链表重排序
 *
 * @author kangxiongwei
 * @date 2020-04-05 12:53
 */
public class ListNodeReorderSolution {


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
        


    }


}

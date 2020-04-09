package com.kxw.leetcode.model;

/**
 * 链表节点定义
 *
 * @author kangxiongwei
 * @date 2020-04-04
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

}
package com.kxw.leetcode.model;

import java.util.ArrayList;

/**
 * 无向图
 *
 * @author kangxiongwei
 * @date 2020-04-21
 */
public class UndirectedGraphNode {

    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

}
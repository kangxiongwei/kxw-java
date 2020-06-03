package com.kxw.leetcode;

import com.kxw.leetcode.model.UndirectedGraphNode;

import java.util.*;

/**
 * 拷贝无向图
 *
 * @author kangxiongwei
 * @date 2020-04-21 20:00
 */
public class GraphNodeCloneSolution {

    public static void main(String[] args) {
        GraphNodeCloneSolution solution = new GraphNodeCloneSolution();
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(1);
        UndirectedGraphNode node3 = new UndirectedGraphNode(2);
        node1.neighbors = new ArrayList<>(Arrays.asList(node2, node3));
        node2.neighbors = new ArrayList<>(Arrays.asList(node3));
        node3.neighbors = new ArrayList<>(Arrays.asList(node3));
        UndirectedGraphNode graph = solution.cloneGraph(node1);
        System.out.println(graph);
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
        return createNode(node, newNodes);
    }

    public UndirectedGraphNode createNode(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> newNodes) {
        UndirectedGraphNode head;
        if (newNodes.containsKey(node.label)) {
            head = newNodes.get(node.label);
        } else {
            head = new UndirectedGraphNode(node.label);
            newNodes.put(node.label, head);
        }
        //创建邻居节点
        ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<>();
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (neighbor.label == head.label) {
                //自己形成环
                newNeighbors.add(head);
            } else {
                UndirectedGraphNode nei = createNode(neighbor, newNodes);
                if (nei != null) {
                    newNeighbors.add(nei);
                }
            }
        }
        head.neighbors = newNeighbors;
        return head;
    }
}

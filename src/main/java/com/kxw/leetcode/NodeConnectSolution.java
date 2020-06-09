package com.kxw.leetcode;

import com.kxw.leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangxiongwei
 * @date 2020-06-08 12:15
 */
public class NodeConnectSolution {

    public static void main(String[] args) {
        Node root = new Node(0);
        Node left = new Node(1);
        Node right = new Node(2);
        root.left = left;
        root.right = right;

        NodeConnectSolution solution = new NodeConnectSolution();
        solution.connect(root);
    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        connect(nodes);
        return root;
    }

    /**
     * 传入上一层数据，返回下一层数据
     *
     * @param nodes
     */
    private List<Node> connect(List<Node> nodes) {
        if (nodes == null || nodes.size() <= 0) {
            return new ArrayList<>();
        }
        List<Node> nextNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (i < nodes.size() - 1) {
                node.next = nodes.get(i + 1);
            }
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        connect(nextNodes);
        return nextNodes;
    }

}

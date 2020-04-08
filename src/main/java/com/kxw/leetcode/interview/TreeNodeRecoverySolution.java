package com.kxw.leetcode.interview;

import com.kxw.leetcode.model.TreeNode;
import com.kxw.leetcode.utils.TreeNodeUtil;

/**
 * 给定一个完全二叉树的广度优先遍历顺序，求原来的树
 *
 * @author kangxiongwei
 * @date 2020-04-08 10:41
 */
public class TreeNodeRecoverySolution {

    public static void main(String[] args) {
        TreeNodeRecoverySolution solution = new TreeNodeRecoverySolution();
        TreeNode treeNode = solution.buildTree("123456789");
        String node = TreeNodeUtil.breadthFirst(treeNode);
        System.out.println(node);
    }

    /**
     * @param tree
     * @return
     */
    public TreeNode buildTree(String tree) {
        if (tree == null) {
            return null;
        }
        char[] chars = tree.toCharArray();
        return buildTree(0, chars);
    }

    public TreeNode buildTree(int index, char[] chars) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(chars[index])));
        if (chars.length > leftIndex) {
            root.left = buildTree(leftIndex, chars);
        }
        if (chars.length > rightIndex) {
            root.right = buildTree(rightIndex, chars);
        }
        return root;
    }


}

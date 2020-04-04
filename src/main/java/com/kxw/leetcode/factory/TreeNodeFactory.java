package com.kxw.leetcode.factory;

import com.kxw.leetcode.model.TreeNode;

/**
 * 树节点的构建工厂
 *
 * @author kangxiongwei
 * @date 2020-04-04 17:12
 */
public class TreeNodeFactory {

    /**
     * 构建一棵树
     *
     * @return
     */
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

}

package com.cj;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        List<Integer>[] graph = new List[200];
        for (int i = 0; i < 200; i++) {
            graph[i] = new LinkedList<>();
        }
    }
}

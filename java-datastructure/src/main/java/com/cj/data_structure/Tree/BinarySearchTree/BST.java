package com.cj.data_structure.Tree.BinarySearchTree;//package dataStructure.Tree.BinarySearchTree;
//
//import java.util.NoSuchElementException;
//
///**
// * 二叉搜索树（BinarySearchTree）
// *
// */
//public class BST<E extends Comparable<? super E>> {
//
//    private Node<E> root;
//
//    /**
//     * 二叉搜索树的节点
//     * @param <E>
//     */
//    private static class Node<E> {
//        E element;
//        Node<E> left;
//        Node<E> right;
//
//        Node(E element, Node<E> left, Node<E> right) {
//            this.element = element;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public BST() {}
//
//
//    /**
//     * 插入节点
//     */
//    public void add(E e) {
//        this.root = add(this.root, e);
//    }
//    /**
//     * 删除节点
//     */
//    public void remove(E e) {
//        this.root = remove(this.root, e);
//    }
//
//    /**
//     * 查找最小节点的值
//     * @return 最小节点的值
//     */
//    public E getFirst() {
//        if (isEmpty()) {
//            throw new NoSuchElementException();
//        }
//        Node<E> node = this.root;
//        while (node.left != null) {
//            node = node.left;
//        }
//        return node.element;
//    }
//
//    /**
//     * 查找最大节点的值
//     */
//    public E getLast() {
//        if (isEmpty()) {
//            throw new NoSuchElementException();
//        }
//        Node<E> node = this.root;
//        while (node.right != null) {
//            node = node.right;
//        }
//        return node.element;
//    }
//
//    /**
//     * 查找是否有包含此值的节点
//     * @param e
//     * @return 返回结果
//     */
//    public boolean contains(E e) {
//        if (isEmpty()) {
//            return false;
//        }
//        Node<E> node = this.root;
//        while (node != null) {
//            int res = e.compareTo(node.element);
//            if (res < 0) {
//                node = node.left;
//            } else if (res > 0) {
//                node = node.right;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 获取前驱的值（第一个小于参数的值）
//     * @param e
//     * @return
//     */
//    public E getPrecursor(E e) {
//        if (isEmpty()) {
//            throw new NoSuchElementException("No such element");
//        }
//    }
//
//    /**
//     * 获取后继的值（第一个大于参数的值）
//     * @param e
//     * @return
//     */
//    public E getSuccessor(E e) {
//        if (isEmpty()) {
//            throw new NoSuchElementException("No such element");
//        }
//
//    }
//
//    /**
//     * 二叉搜索树的高度
//     * @return
//     */
//    public int height() {
//        return height(this.root);
//    }
//    private int height(Node<E> node) {
//        if (node == null) {
//            return 0;
//        }
//        return 1 + Math.max(height(node.left), height(node.right));
//    }
//    /**
//     * 获取节点个数
//     * @return 整形
//     */
//    public int size() {
//        return size(this.root);
//    }
//
//    private int size(Node<E> node) {
//        if (node == null) {
//            return 0;
//        }
//        return 1 + size(node.left) + size(node.right);
//    }
//
//    /**
//     * 中序遍历树
//     */
//    public void inorderTraversal() {
//        inorderTraversal(this.root);
//    }
//    private void inorderTraversal(Node<E> node) {
//        if (node != null) {
//            inorderTraversal(node.left);
//            System.out.println(node.element);
//            inorderTraversal(node.right);
//        }
//    }
//    /**
//     * 清空节点
//     */
//    public void clear() {
//        this.root = null;
//    }
//    /**
//     * 判断是否为空树
//     */
//    public boolean isEmpty() {
//        return this.root == null;
//    }
//    /**
//     * 往节点中添加元素方法，如果节点为空返回新的元素节点
//     * 否则比较节点的值并赋值给左/右子节点
//     * @param node
//     * @param e
//     * @return 节点
//     */
//    private Node<E> add(Node<E> node, E e) {
//        if (node == null) {
//            return new Node<>(e, null, null);
//        }
//        int res = e.compareTo(node.element);
//        if (res < 0) {
//            node.left = add(node.left, e);
//        }
//        if (res > 0) {
//            node.right = add(node.right, e);
//        }
//        return node;
//    }
//
//    /**
//     *
//     */
//    private Node<E> remove(Node<E> node, E e) {
//
//    }
//
//
//}

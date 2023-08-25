package com.cj.data_structure.Tree.Trie.baseArray;

/**
 * 前缀树：一种 N 叉形数据结构
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie () {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 插入一个单词（非递归形式）
     * @param word
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }
    /**
     * 插入一个单词（递归形式）
     * @param word
     */
    public void insert(String word, int index, Trie node) {
        if (index == word.length()) {
            node.isEnd = true;
            return;
        }
        char ch = word.charAt(index);
        if (node.children[ch - 'a'] == null) {
            node.children[ch - 'a'] = new Trie();
        }
        insert(word, index + 1, node.children[ch - 'a']);
    }
    /**
     * 查询前缀是否存在
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
    /**
     * 查询前缀是否为完整前缀
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isEnd;
    }
}

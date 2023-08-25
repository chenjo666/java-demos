package com.cj.data_structure.Tree.Trie.baseArray;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc", 0, trie);
        System.out.println(trie.search("abc"));
    }
}

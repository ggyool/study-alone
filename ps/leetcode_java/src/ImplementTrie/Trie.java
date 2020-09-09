package ImplementTrie;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// Node 만들 수도 있고, 안 만들수도 있고
// 재귀로 할 수도 반복문으로할 수도.
public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        int len = word.length();
        Node cur = root;
        for(int i=0; i<len; ++i){
            char c = word.charAt(i);
            if(cur.isExisted(c)){
                cur = cur.getChild(c);
            }
            else{
                cur = cur.addChild(c);
            }
            if(i==len-1) cur.setTerminal();
        }
    }
    public boolean search(String word) {
        int len = word.length();
        Node cur = root;
        for(int i=0; i<len; ++i){
            char c = word.charAt(i);
            if(cur.isExisted(c)) {
                cur = cur.getChild(c);
            }
            else{
                return false;
            }
        }
        return cur.isTerminal();
    }
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node cur = root;
        for(int i=0; i<len; ++i){
            char c = prefix.charAt(i);
            if(cur.isExisted(c)) {
                cur = cur.getChild(c);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

class Node {
    HashMap<Character, Node> mp;
    boolean terminal;
    public Node() {
        mp = new HashMap<>();
        this.terminal = false;
    }
    boolean isExisted(char c){
        return mp.containsKey(c);
    }
    Node getChild(char c) {
        return mp.get(c);
    }
    Node addChild(char c) {
        Node newNode = new Node();
        mp.put(c, newNode);
        return newNode;
    }
    void setTerminal(){
        this.terminal = true;
    }
    boolean isTerminal(){
        return this.terminal;
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.InputMap;

public class Trie {
    private class Node{
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }

        public char toChar() {
            return this.value;
        }
        
        public void addChar(char ch) {
            children.put(ch, new Node(ch));
        }
        public Node getChild(char ch) {
            return children.get(ch);
        }
        public boolean hasChild(char ch) {
            return children.get(ch) != null;
        }
        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        public void remove(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');
    public void insert(String input) {
        
        var current = root;
        for (char ch : input.toCharArray()) {
            if(!current.hasChild(ch)){
                current.addChar(ch);
                // System.out.println(ch);
            }
            current = current.children.get(ch);
            
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String input){
        var current = root;
        for (char ch : input.toCharArray()) {
            if(current.getChild(ch) == null){
                return false;
            }
            System.out.println(ch);
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }

    public boolean containsRecursive(String input) {
        return containsRecursive(root, input, 0);
    }
    int index;
    private boolean containsRecursive(Node root, String input, int index) {
        if (index == input.length())
            return root.isEndOfWord;

        if (root == null)
            return false;

        var ch = input.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return false;

        return containsRecursive(child, input, index + 1);
    }

    public void traverse() {
        traverse(root);
    }
    private void traverse(Node current){
        for(Node child: current.getChildren()){
            traverse(child);
        }
        System.out.println(current.value);
    }

    public void remove(String word) {
        if (word == null)
          return;
    
        remove(root, word, 0);
      }
    
    private void remove(Node current, String word, int index) {
        if (index == word.length()) {
            current.isEndOfWord = false;
            return;
        }
    
        var ch = word.charAt(index);
        var child = current.getChild(ch);
        if (child == null)
            return;
    
        remove(child, word, index + 1);
    
        if (!child.hasChild(ch) && !child.isEndOfWord)
            current.remove(ch);
    }
    public void countWords(){
        countWords(root);
        System.out.println("Count of words : " + indexs);
    }
    int indexs = 0;
    private void countWords(Node root) {
        for (var child : root.getChildren()) {
            indexs++;
            countWords(child);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
    
        return words;
    }
    
    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null)
          return;
    
        if (root.isEndOfWord)
          words.add(prefix);
    
        for (var child : root.getChildren())
          findWords(child, prefix + child.value, words);
    }
    
    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;
    
        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                    return null;
            current = child;
        }
        return current;
    }
}

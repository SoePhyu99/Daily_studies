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

    public void autoComplete(String input) {
        var current = root;
        String word = "";
        List<String> words;

        for (char ch : input.toCharArray()) {
            if(current.hasChild(ch)){
                current = current.getChild(ch);
                word += ch;
            }
        }
        System.out.println(word);

    }
}

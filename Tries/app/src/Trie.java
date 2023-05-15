import java.util.HashMap;

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
    }

    private Node root = new Node(' ');
    public void insert(String input) {
        
        var current = root;
        for (char ch : input.toCharArray()) {
            if(current.children.get(ch) == null){
                current.children.put(ch, new Node(ch));
                current = current.children.get(ch);
                System.out.println(current.toChar());
            }else{
                current = current.children.get(ch);
            }
        }
        current.isEndOfWord = true;
    }
}

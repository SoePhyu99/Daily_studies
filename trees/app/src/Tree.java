import java.util.ArrayList;

public class Tree {
    
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    public void insert(int item) {
        Node node = new Node(item);
        if(root == null){
            root = node;
        }
        Node current = root;
        while (true) {
            if(item < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else if(item > current.value){
                if(current.rightChild != null){
                    current = current.rightChild;
                }else{
                    current.rightChild = node;
                    break;
                }
            }
            else{
                break;
            }
        }
    }

    public boolean find(int item) {
        Node current = root;
        while(current != null){
            if(item < current.value){
                current = current.leftChild;
            }else if(item > current.value){
                current = current.rightChild;
            }else{
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.println("hi");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null){
            return -1;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    public int min(){
        return min(root);
    }

    private int min(Node root) {
        if(isLeaf(root)){
            return root.value;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 0;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.max(Math.max(left, right), root.value);
    }

    public boolean equals(Tree other){
        System.out.println(root.value + "original");
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null){
            System.out.println(first.value + " && " + second.value);
            return first.value == second.value
                && equals(first.leftChild, second.leftChild)
                && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
    
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
    
        if (root.value < min || root.value > max)
            return false;
        System.out.println(max + " max " + root.value);
        System.out.println(min + " min " + root.value);
        return
                isBinarySearchTree(root.leftChild, min, root.value - 1)
                        && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
          return;
    
        if (distance == 0) {
          list.add(root.value);
          return;
        }
        // System.out.println(distance - 1 + " ^ " + list);
    
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }
    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
          for (var value : getNodesAtDistance(i))
            System.out.println(value);
        }
    }
}

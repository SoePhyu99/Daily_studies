import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private class Node{
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if(fromNode == null){
            throw new NullPointerException();
        }
        var toNode = nodes.get(to);
        if(toNode == null){
            throw new NullPointerException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var result = adjacencyList.get(source);
            if(!result.isEmpty()){
                System.out.println(source + " is connected to :" + result);
            }
        }
    }

    public void remove(String label) {
        var node = nodes.get(label);
        if(node == null){
            return;
        }
        for (var n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }
    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null){
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirstRec(String root) {
        var node = nodes.get(root);
        if (node == null){
            return;
        }    
    
        traverseDepthFirstRec(node, new HashSet<>());
      }
    
    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
    
        for (var node : adjacencyList.get(root)){
            if (!visited.contains(node)){
                traverseDepthFirstRec(node, visited);
            }
        }
    }
    
    public void traverseDepthFirst(String root) {
        var node = nodes.get(root);
        if (node == null){
          return;
        }
        Set<Node> visited = new HashSet<>();
    
        Stack<Node> stack = new Stack<>();
        stack.push(node);
    
        while (!stack.isEmpty()) {
            var current = stack.pop();
    
            if (visited.contains(current)){
                continue;
            }
            System.out.println(current);
            visited.add(current);
    
            for (var neighbour : adjacencyList.get(current)){
                if (!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
        }
    }
    
    public void traverseBreadthFirst(String root) {
        var node = nodes.get(root);
        if (node == null){
            return;
        }
    
        Set<Node> visited = new HashSet<>();
    
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
    
        while (!queue.isEmpty()) {
            var current = queue.remove();
        
            if (visited.contains(current)){
                continue;
            }
        
            System.out.println(current);
            visited.add(current);
        
            for (var neighbour : adjacencyList.get(current)){
                if (!visited.contains(neighbour))
                queue.add(neighbour);
            }
        }
    }
    
    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
    
        for (var node : nodes.values()){
            topologicalSort(node, visited, stack);
        }
    
        List<String> sorted = new ArrayList<>();
        while (!stack.empty()){
            sorted.add(stack.pop().label);
        }
    
        return sorted;
    }
    
    private void topologicalSort(
        Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)){
            return;
        }

        visited.add(node);

        for (var neighbour : adjacencyList.get(node)){
            topologicalSort(neighbour, visited, stack);
        }

        stack.push(node);
    }
    
    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
            return true;
        }

        return false;
    }
    
    private boolean hasCycle(Node node, Set<Node> all,
                    Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour)){
                continue;
            }

            if (visiting.contains(neighbour)){
                return true;
            }

            if (hasCycle(neighbour, all, visiting, visited)){
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        graph.addNode("June");
        graph.addNode("July");
        graph.addNode("May");
        graph.addEdge("June", "May");
        graph.addEdge("June", "July");
        graph.remove("May");
        graph.print();
        System.out.println();
    }
}

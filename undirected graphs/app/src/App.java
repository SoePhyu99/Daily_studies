public class App {
    public static void main(String[] args) throws Exception {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addEdge("A", "B", 1);
        weightedGraph.addEdge("A", "B", 1);
        System.out.println();
    }
}

package Graph;

/**
 * Created by Jakub on 2017-11-14.
 */
public class GraphRunner {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("D");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("E");

        graph.addDependency("A", "C");
        graph.addDependency("A", "B");
        graph.addDependency("C", "B");
        graph.addDependency("D", "A");
        graph.addDependency("B", "E");

        System.out.println(graph.toString());

        graph.DFS();

        System.out.println(graph.topologicalSort());
    }
}

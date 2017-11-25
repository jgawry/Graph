/*
 * A -> B
 * B -> C
 * A -> C
 * c -> D
 */

package Graph;

import java.util.*;

/**
 * Created by Jakub on 2017-11-14.
 */
public class Graph {
    HashMap<String, Node> vertexMap;

    class Node {
        String label;
        String description;
        Set<Node> vertices;
        Set<Node> parents;

        public Node(String label, String description) {
            this.label = label;
            this.vertices = new HashSet();
            this.parents = new HashSet();
            this.description = description;
        }

        public void addVertex(Node vertex) {
            if (vertices == null) {
                vertices = new HashSet<Node>(2);
            }

            vertices.add(vertex);
            vertex.addParent(this);
        }

        public void removeParent(Node vertex) {
            parents.remove(vertex);
        }

        public boolean hasNoParents() {
            return parents.isEmpty();
        }

        public void addParent(Node vertex) {
            this.parents.add(vertex);
        }

        public String toString() {
            return label;
        }

        public int hashCode() {
            return label.hashCode();
        }

        public boolean equals(Object o) {
            if (!(o instanceof Node)){
                return false;
            }

            Node that = (Node)o;
            boolean allEqual = true;

            if (!that.label.equals(this.label)) {
                return false;
            }

            for (Node dep : vertices) {
                allEqual = that.vertices.contains(dep);

                if (!allEqual) {
                    return false;
                }
            }

            return true;
        }
    }

    public Graph() {}

    public void addVertex(String label, String description) {
        if (vertexMap == null) {
            vertexMap = new HashMap<String, Node>(2);
        }

        if (!vertexMap.containsKey(label)) {
            vertexMap.put(label, new Node(label, description));
        }
    }


    public void addDependency(String parent, String child) {
        Node sourceVertex = findVertex(parent);
        Node destVertex = findVertex(child);

        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addVertex(destVertex);
        } else if (sourceVertex == null) {
            throw new IllegalArgumentException("Parent vertex not found: " + parent);
        } else {
            throw new IllegalArgumentException("Child vertex not found: " + child);
        }
    }

    public Node findVertex(String label) {
        if (vertexMap == null) {
            return null;
        }

        return vertexMap.get(label);
    }

    public String toString() {
        if (vertexMap == null) {
            return "Empty Graph.";
        }

        StringBuilder sb = new StringBuilder();

        for (String label : vertexMap.keySet()) {
            sb.append(label + " ");
        }

        return sb.toString();
    }

    public void BFS() {
        if (vertexMap == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>(vertexMap.size());
        List<Node> queue = findVerticesWithNoParents();

        while(!queue.isEmpty()) {
            Node node = queue.remove(0);
            String nodeLabel = node.label;

            if (!visited.contains(nodeLabel)) {
                System.out.println("Visiting: " + nodeLabel);

                visited.add(nodeLabel);
                sb.append(nodeLabel).append(" -> ");

                if (node.vertices != null) {
                    for (Node dep : node.vertices) {
                        sb.append(dep.label).append(", ");
                        queue.add(dep);
                    }
                }

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public List<Node> topologicalSort() {
        List<Node> sortedVertices = new ArrayList<>();
        List<Node> noIncomingEdgeNodes = findVerticesWithNoParents();

        while(!noIncomingEdgeNodes.isEmpty()) {
            Node node = noIncomingEdgeNodes.remove(0);

            sortedVertices.add(node);

            for(Node dep : node.vertices) {
                dep.removeParent(node);

                if (dep.hasNoParents()) {
                    noIncomingEdgeNodes.add(dep);
                }
            }
        }

        return sortedVertices;
    }

    private ArrayList<Node> findVerticesWithNoParents() {
        ArrayList<Node> noParentsList = new ArrayList<>(2);

        for(Node node : vertexMap.values()) {
            if(node.hasNoParents()) {
                noParentsList.add(node);
            }
        }

        return  noParentsList;
    }
}
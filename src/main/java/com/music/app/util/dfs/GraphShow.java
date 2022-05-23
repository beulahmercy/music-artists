package com.music.app.util.dfs;

public class GraphShow {
    public static void main(String[] args) {

        Graph graph = new Graph(true);
        Node a = new Node(0, "A");
        Node b = new Node(1, "B");
        Node c = new Node(2, "C");
        Node d = new Node(3, "D");
        Node e = new Node(4, "E");

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(c, e);
        graph.addEdge(b, a);

        graph.printEdges();

        System.out.println(graph.hasEdge(a, b));
        System.out.println(graph.hasEdge(d, a));
    }
}
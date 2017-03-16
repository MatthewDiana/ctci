package com.matthewdiana.ctci.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class Question4_1 {

    public static void main(String[] args) {
        Graph g = initializeGraph();
        System.out.println(routeExists(g.nodes[0], g.nodes[2]));
        System.out.println(routeExists(g.nodes[1], g.nodes[3]));
        System.out.println(routeExists(g.nodes[0], g.nodes[4]));
        System.out.println(routeExists(g.nodes[5], g.nodes[5]));
    }

    private static boolean routeExists(GraphNode n1, GraphNode n2) {
        Queue<GraphNode> nodes = new LinkedList<>();
        nodes.add(n1);
        while (!nodes.isEmpty()) {
            GraphNode curr = nodes.poll();
            if (curr == n2) return true;
            curr.visited = true;
            for (GraphNode n : curr.children) {
                if (!n.visited) nodes.add(n);
            }
        }
        return false;
    }

    private static Graph initializeGraph() {
        Graph g = new Graph();
        g.nodes = new GraphNode[7];
        for (int i = 0; i < g.nodes.length; i++) {
            g.nodes[i] = new GraphNode();
            g.nodes[i].name = Integer.toString(i);
        }
        g.nodes[0].children = new GraphNode[1];
        g.nodes[0].children[0] = g.nodes[1];
        g.nodes[1].children = new GraphNode[1];
        g.nodes[1].children[0] = g.nodes[2];
        g.nodes[2].children = new GraphNode[2];
        g.nodes[2].children[0] = g.nodes[0];
        g.nodes[2].children[1] = g.nodes[3];
        g.nodes[3].children = new GraphNode[1];
        g.nodes[3].children[0] = g.nodes[2];
        g.nodes[4].children = new GraphNode[1];
        g.nodes[4].children[0] = g.nodes[6];
        g.nodes[5].children = new GraphNode[1];
        g.nodes[5].children[0] = g.nodes[4];
        g.nodes[6].children = new GraphNode[1];
        g.nodes[6].children[0] = g.nodes[5];
        return g;
    }

}

class Graph {
    GraphNode[] nodes;
}

class GraphNode {
    public String name;
    public boolean visited;
    public GraphNode[] children;
}

package hw1_graph;

import java.util.ArrayList;

/**
 * Created by howardos on 26.05.2016.
 */

public class Graph {
    public ArrayList<Edge> edges;
    int[][] matrix;
    ArrayList<SuperNode> superNodes;

    public Graph(ArrayList edges) {
        this.edges = edges;
    }

    ArrayList<Edge> getEdgesList() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i).getA() + ", " + edges.get(i).getB());
        }
        return edges;
    }

    public int[][] getAdjecencyMatrix() {
        matrix = new int[edges.size()][edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            matrix[edges.get(i).getA() - 1][edges.get(i).getB() - 1] = 1;
        }
        return matrix;
    }

    public void toString(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public ArrayList<SuperNode> getAdjList() {
        superNodes = new ArrayList<>();
        for (int i = 1; i <= edges.size(); i++) {

        }
        return null;
    }


    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(0, new Edge(1, 2));
        edges.add(1, new Edge(2, 3));
        edges.add(2, new Edge(3, 1));
        Graph g = new Graph(edges);
        g.getEdgesList();
        g.toString(g.getAdjecencyMatrix());
    }

    public class SuperNode {
        ArrayList<Integer> v;

        public SuperNode(int k) {
            for (int i = 1; i <= edges.size(); i++) {
                if (edges.get(i - 1).isEdge(k, i)) {
                    v.add(i - 1, i);
                }
            }
        }
    }

    public static class Edge {
        public int a, b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public boolean isEdge(int a, int b) {
            return ((getA() == a || getB() == a) && (getA() == b || getB() == b));
        }
    }
}

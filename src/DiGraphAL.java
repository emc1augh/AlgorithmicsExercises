/**
 * DiGraph with Adjacency Matrix.
 *
 * This code is just a fragment for illustrative purposes.
 */
public class DiGraphAL {

    private class Edge {
        Vertex successor;
        Edge next;
        double weight;

        public Edge(Vertex succ, Edge n, double w) {
            successor = succ;
            next = n;
            weight = w;
        }
    }

    private class Vertex {
        String label;
        Vertex next;
        Edge edges;

        public Vertex(String l, Vertex n) {
            label = l;
            next = n;
            edges = null;
        }
    }

    // Single protected data item which
    // references the top of the vertex list
    private Vertex vList;

    public DiGraphAL() {
        vList = null;
    }

    public void insertVertex(String l) {
        // Missing: a check that the vertex isn't
        // already in the graph.

        // Link in the new vertex
        vList = new Vertex(l, vList);
    }



    public void insertEdge(String pred, String succ,
                           double weight) {
        // Missing: checks that both Strings represent
        // valid vertices in the graph.

        Vertex vPred = vList;
        while (!vPred.label.equals(pred)) {
            vPred = vPred.next;
        }

        Vertex vSucc = vList;
        while (!vSucc.label.equals(succ)) {
            vSucc = vSucc.next;
        }

        // Missing: a check that the edge isn't already
        // contained in the graph.

        // Link in new edge at start of list
        vPred.edges = new Edge(vSucc, vPred.edges, weight);
    }
}

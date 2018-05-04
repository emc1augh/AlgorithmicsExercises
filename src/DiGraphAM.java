/**
 * DiGraph with Adjacency Matrix.
 *
 * This code is just an outline with pseudo code.
 *
 * It does not compile as it is not valid Java.
 */

import java.util.Hashtable;

public class DiGraphAM {
    protected double[][] aMatrix;
    protected Hashtable<String, Integer> vertLUT;
    protected int nextVert;

    public DiGraphAM(int maxVerts) {
        aMatrix = new double[maxVerts][maxVerts];

        // Initialise to be not zero.
        for (int i=0; i < maxVerts; i++) {
            for (int j=0; j < maxVerts; j++) {
                aMatrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        vertLUT = new Hashtable<String, Integer>(maxVerts*3/2);
        nextVert = 0;
    }

    public void insertVertex(String l) {
        // Include a check that the vertex isn't
        // already in the graph.

        // Check that the adjacency matrix isn't
        // full up already.

        // Add vertex to the hash table
        vertLUT.put(l, new Integer(nextVert));

        // Increment the index for the next vertex
        // inserted
        nextVert += 1;
    }


    private int indexOf(String l) {
        Integer index = vertLUT.get(l);
        return index.intValue();
    }

    public void insertEdge(String pred, String succ,
                           double weight) {
        int pIndex = indexOf(pred);
        int sIndex = indexOf(succ);

        aMatrix[pIndex][sIndex] = weight;
    }

    public void depthFirstPrint() {
        boolean[] visited = new boolean[no.vertices];
        // The whole array is set to false.

        for (each vertex v in V) {
            if (!visited[indexOf(v)]) {
                dFTraverse(v, visited);
            }
        }
    }

    protected void dFTraverse(Vertex v, boolean[] visited) {
        // Visit the vertex
        System.out.println(v.label);

        visited[indexOf(v)] = true;

        for (each vertex w such that: (v,w) is in E) {
            if (!visited[indexOf(w)]) {
                dFTraverse(w, visited);
            }
        }
    }

    public void breadthFirstPrint() {
        boolean visited[] = new boolean[no.vertices];
        // The whole array is set to false.

        for (each vertex v in V) {
            if (!visited[indexOf(v)]) {
                bFTraverse(v, visited);
            }
        }
    }

    protected void bFTraverse(Vertex v, boolean[] visited) {
        visited[indexOf(v)] = true;

        Queue q = new Queue();
        q.enQueue(v);

        while (!q.empty()) {
            Vertex v = q.deQueue();
            System.out.println(v.label);
            for (each w such that: (v, w) is in E) {
                if (!visited[indexOf(w)]) {
                    q.enQueue(w);
                    visited[indexOf(w)] = true;
                }
            }
        }
    }

    public shortestPath(Vertex v1, Vertex v2) {
        boolean[] distanceFound = new boolean[no.vertices];
        double[] distance = new double[no.vertices];

        for (each w such that: (v1, w) is in E) {
            distance[indexOf(w)] = cost(v1, w);
        }

        distanceFound[indexOf(v1)] = true;
        v = v1;

        for (int i=0; i < no.verts; i++) {
            double min = infinity;
            for (each w in V) {
                if (!distanceFound[indexOf(w)]
                    && distance[indexOf(w)] < min) {
                    v = w;
                    min = distance[indexOf(w)];
                }
            }

            distanceFound[indexOf(v)] = true;

            for (each w such that: (v, w) is in E) {
                if (min + cost(v,w) < distance[indexOf(w)]) {
                    distance[indexOf(w)] = min + cost(v,w);
                }
            }
        }

        return distance[indexOf(v2)];
    }
}


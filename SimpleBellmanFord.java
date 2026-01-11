import java.util.*;

class SimpleBellmanFord {
    private int[] distances;
    private int vertices;
    private static final int INF = 9999; // Represents infinity

    public SimpleBellmanFord(int vertices) {
        this.vertices = vertices;
        this.distances = new int[vertices + 1]; // 1-based indexing
    }

    public void findShortestPaths(int source, int[][] graph) {
        // Step 1: Initialize distances
        for (int i = 1; i <= vertices; i++) {
            distances[i] = INF;
        }
        distances[source] = 0;

        // Step 2: Relax all edges (vertices-1) times
        for (int i = 1; i <= vertices - 1; i++) {
            for (int u = 1; u <= vertices; u++) {
                for (int v = 1; v <= vertices; v++) {
                    if (graph[u][v] != INF && distances[u] != INF) {
                        if (distances[v] > distances[u] + graph[u][v]) {
                            distances[v] = distances[u] + graph[u][v];
                        }
                    }
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (int u = 1; u <= vertices; u++) {
            for (int v = 1; v <= vertices; v++) {
                if (graph[u][v] != INF && distances[u] != INF) {
                    if (distances[v] > distances[u] + graph[u][v]) {
                        System.out.println("❌ Graph contains negative weight cycle!");
                        return;
                    }
                }
            }
        }

        // Step 4: Print results
        printDistances(source);
    }

    private void printDistances(int source) {
        System.out.println("\n📊 Shortest distances from source " + source + ":");
        for (int i = 1; i <= vertices; i++) {
            if (distances[i] == INF) {
                System.out.println("To vertex " + i + ": UNREACHABLE");
            } else {
                System.out.println("To vertex " + i + ": " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices + 1][vertices + 1];

        // Initialize graph with INF (no edge)
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (i == j) {
                    graph[i][j] = 0; // Distance to self is 0
                } else {
                    graph[i][j] = INF; // No edge by default
                }
            }
        }

        // Input edges
        System.out.println("\nEnter the adjacency matrix (use 0 for no edge):");
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                int weight = scanner.nextInt();
                if (weight != 0 && i != j) {
                    graph[i][j] = weight;
                }
            }
        }

        System.out.print("\nEnter source vertex: ");
        int source = scanner.nextInt();

        SimpleBellmanFord bellman = new SimpleBellmanFord(vertices);
        bellman.findShortestPaths(source, graph);

        scanner.close();
    }
}
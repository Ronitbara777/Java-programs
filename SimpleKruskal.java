import java.util.*;

public class SimpleKruskal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Step 1: Input the graph
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        
        // Store edges as [src, dest, weight]
        int[][] edges = new int[E][3];
        
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt(); // Source
            edges[i][1] = sc.nextInt(); // Destination
            edges[i][2] = sc.nextInt(); // Weight
        }
        
        // Step 2: Sort all edges by weight (ascending order)
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        // Step 3: Initialize parent array for Union-Find
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i; // Each node is its own parent initially
        }
        
        int mstWeight = 0;
        System.out.println("\nEdges in MST:");
        
        // Step 4: Process each edge in sorted order
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            
            // Find parents of u and v
            int rootU = findParent(parent, u);
            int rootV = findParent(parent, v);
            
            // If including this edge doesn't cause cycle
            if (rootU != rootV) {
                System.out.println(u + " -- " + v + " == " + weight);
                mstWeight += weight;
                parent[rootV] = rootU; // Union operation
            }
        }
        
        System.out.println("Total MST weight: " + mstWeight);
    }
    
    // Helper function to find parent of a node (with path compression)
    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]); // Path compression
        }
        return parent[node];
    }
}
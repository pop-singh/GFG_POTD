class Solution {
    public int makeConnected(int n, int[][] connections) {
        // If the number of edges is less than n - 1, it is impossible to connect all computers.
        if (connections.length < n - 1) {
            return -1;
        }
        
        // Create a union-find data structure.
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Merge nodes that are connected by edges.
        for (int[] connection : connections) {
            int root1 = find(connection[0], parent);
            int root2 = find(connection[1], parent);
            if (root1 != root2) {
                parent[root1] = root2;
            }
        }
        
        // Count the number of disjoint sets in the union-find data structure.
        int numSets = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                numSets++;
            }
        }
        
        // Return the minimum number of cables to connect all computers.
        return numSets - 1;
    }
    
    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node], parent);
        return parent[node];
    }
}
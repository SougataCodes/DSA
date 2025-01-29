class Solution {
    class DSU {
        int[] parent, rank;
        
        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) parent[i] = i;
        }
        
        public int find(int x) {
            if (parent[x] != x) 
                parent[x] = find(parent[x]); // Path compression
            return parent[x];
        }
        
        public boolean unite(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false; // Cycle detected
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        
        for (int[] edge : edges) {
            if (!dsu.unite(edge[0], edge[1])) {
                return edge;  // This is the redundant connection
            }
        }
        return new int[]{};
    }
}
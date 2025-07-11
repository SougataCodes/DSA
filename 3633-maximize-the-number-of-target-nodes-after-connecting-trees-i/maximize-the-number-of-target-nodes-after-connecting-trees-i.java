class Solution {
    private void dfs(int node, int parent, int distance, int root, int k, int[] good, List<List<Integer>> adj) {
        if (distance >= k) return;

        good[root]++;
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, distance + 1, root, k, good, adj);
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = new ArrayList<>(n);
        List<List<Integer>> adj2 = new ArrayList<>(m);

        for (int i = 0; i < n; i++) adj1.add(new ArrayList<>());
        for (int i = 0; i < m; i++) adj2.add(new ArrayList<>());

        for (int[] edge : edges1) {
            int u = edge[0], v = edge[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        for (int[] edge : edges2) {
            int u = edge[0], v = edge[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int[] good1 = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(i, -1, 0, i, k + 1, good1, adj1);
        }

        int[] good2 = new int[m];
        for (int i = 0; i < m; i++) {
            dfs(i, -1, 0, i, k, good2, adj2);
        }

        int maxGood2 = Arrays.stream(good2).max().getAsInt();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = good1[i] + maxGood2;
        }

        return result;
    }
}
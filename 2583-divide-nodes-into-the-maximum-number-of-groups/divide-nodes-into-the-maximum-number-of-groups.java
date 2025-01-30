class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] != -1) continue;
            List<Integer> nodes = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 0;
            boolean isBipartite = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                nodes.add(node);
                for (int neighbor : graph.get(node)) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        queue.add(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        isBipartite = false;
                    }
                }
            }

            if (!isBipartite) return -1;

            int maxDepth = 0;
            for (int node : nodes) {
                Queue<Integer> q = new LinkedList<>();
                Set<Integer> visited = new HashSet<>();
                q.add(node);
                visited.add(node);
                int depth = 0;

                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int cur = q.poll();
                        for (int next : graph.get(cur)) {
                            if (!visited.contains(next)) {
                                visited.add(next);
                                q.add(next);
                            }
                        }
                    }
                    depth++;
                }
                maxDepth = Math.max(maxDepth, depth);
            }
            result += maxDepth;
        }
        return result; 
    }
}
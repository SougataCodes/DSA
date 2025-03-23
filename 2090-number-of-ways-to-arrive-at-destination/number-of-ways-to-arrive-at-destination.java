class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); 

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long timeTaken = curr[1];

            if (timeTaken > dist[node]) continue; 
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long newTime = timeTaken + neighbor[1];

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextNode, newTime});
                } else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
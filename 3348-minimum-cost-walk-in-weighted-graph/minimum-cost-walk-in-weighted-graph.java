class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        var cs = new int[n];
        for (int i = 0; i < n; i++) cs[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int e0 = calcCs(edges[i][0], cs);
            int e1 = calcCs(edges[i][1], cs);
            cs[Math.max(e0, e1)] = Math.min(e0, e1);
        }
        for (int i = 0; i < n; i++) calcCs(i, cs);

        var cw = new int[n];
        Arrays.fill(cw, Integer.MAX_VALUE);
        for (int i = 0; i < edges.length; i++) cw[cs[edges[i][0]]] &= edges[i][2];
        
        var res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            var q = query[i];
            if (cs[q[0]] != cs[q[1]]) res[i] = -1;
            else res[i] = cw[cs[q[0]]];
        }
        return res;
    }

    private int calcCs(int i, int[] cs) {
        if (cs[i] == i) return i;
        cs[i] = calcCs(cs[i], cs);
        return cs[i];
    }
}
class Solution {
    public long putMarbles(int[] w, int k) {
        int len = w.length;
        long pairs[] = new long[len-1];
        for(int i = 0; i < len-1; i++) 
            pairs[i] = w[i] + w[i+1];
        Arrays.sort(pairs);
        long ret = 0;
        for(int i = 0; i < k-1; i++) 
            ret += pairs[len - 2 - i] - pairs[i];

        return ret;
    }
}
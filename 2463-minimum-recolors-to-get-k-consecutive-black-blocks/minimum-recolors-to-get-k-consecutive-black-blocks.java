class Solution {
    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        int[] ar = new int[len];
        if(blocks.charAt(0) == 'B')ar[0] = 1;
        for(int i = 1 ; i < len ; i++){
            if(blocks.charAt(i) == 'B')ar[i] = 1;
            ar[i] += ar[i-1];
        }
        // System.out.println(Arrays.toString(ar));
        int min = k - ar[k-1];
        for(int i = k ; i < len ; i++){
            int req = k - (ar[i] - ar[i-k]);
            min = Math.min(min , req);
        }
        return min;
    }
}
class Solution {
    public long countBadPairs(int[] nums) {
          int n = nums.length;
          long totalPairs = (long)n*(n-1)/2;
          long goodPairs = 0;
          Map<Integer,Integer> hm = new HashMap<>();
          for(int i=0;i<n;i++){
            int diff = nums[i]-i;
            goodPairs += hm.getOrDefault(diff,0);
            hm.put(diff,hm.getOrDefault(diff,0)+1);
          }
          return totalPairs-goodPairs;
    }
}
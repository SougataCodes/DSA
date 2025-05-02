class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        final int len = nums.length;
        int maxCount = 0;//storing the size of the array since we are overwriting nums
        for(int i = 0; i < len;i++) {
            if(max < nums[i]) {
                max = nums[i];
                maxCount = 0;
            }
            if(max==nums[i]) nums[maxCount++] = i;
        }
        if(maxCount < k) return 0;
        long count = 0;
        int prev = -1;
        for(int i = 0; i <= maxCount-k; i++){
            int start = nums[i];
            int end = nums[i+k-1];
            count += (long)(start-prev) * (nums.length-end);
            prev = start;
        } 
        return count;
    }
}
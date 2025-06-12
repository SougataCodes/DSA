class Solution {
    public int maxAdjacentDistance(int[] nums) {

        int maxDiff = 0 ;

        int n = nums.length ;

        for(int i=1; i<n; ++i) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i]-nums[i-1])) ;
        }

        maxDiff = Math.max(maxDiff, Math.abs(nums[0]-nums[n-1])) ;

        return maxDiff ;
    }
}
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        int l=0,r=0;
        long res=0,sum=0;

        while (r<n) {
            sum+=nums[r];
            while (l<=r && sum*(r-l+1) >= k) {
                res+=n-r;
                sum-=nums[l];
                l++;
            }
            r++;
        }

        return ((long) n*(n+1))/2-res;
    }
}
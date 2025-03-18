class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, res = 1, mask = 0;
        
        while (r < n) {
            // If the current number has overlapping bits, shrink the window
            while ((mask & nums[r]) != 0) {
                mask ^= nums[l]; // Remove nums[l] from the mask
                l++;
            }
            // Update the result with the new valid subarray size
            res = Math.max(res, r - l + 1);
            // Add nums[r] to the mask
            mask |= nums[r];
            r++;
        }
        
        return res; 
    }
}
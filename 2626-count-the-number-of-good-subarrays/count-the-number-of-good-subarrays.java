class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        long ans = 0;     
        int pairs = 0;      
        int left = 0, right = 0; 
        while (right < nums.length) 
        {
            pairs += map.getOrDefault(nums[right], 0);  
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while (pairs>=k) 
            {
                map.put(nums[left], map.get(nums[left]) - 1);
                pairs -= map.get(nums[left]);
                left++;
            }
            ans += left;    
            right++;
        }
        return ans;
    }
}
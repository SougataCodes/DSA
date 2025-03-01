class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n-1; i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]*=2;
                nums[i+1]=0;
                i++;
            }
        }
        
        int count=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i]!=0){
                nums[count++]=nums[i];
            }
        }
        while (count < n) 
        {    
            nums[count++] = 0; 
        }
        return nums;
    }
}
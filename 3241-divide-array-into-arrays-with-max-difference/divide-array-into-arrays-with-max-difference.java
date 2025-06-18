class Solution {
    public int[][] divideArray(int[] nums, int k) 
    {
        int n = nums.length;
        
        int res[][] = new int[n/3][3];
        
        Arrays.sort(nums);
        
        int p=0;
        
        for(int i=2;i<n;i+=3)
        {
        	if(nums[i]-nums[i-3+1]<=k)
        	{
        		res[p][0] = nums[i-2];
        		res[p][1] = nums[i-1];
        		res[p][2] = nums[i];
        	}
        	
            else
        	{
        		return new int[0][0];
        	}

        	p++;        		
        }
        
        return res; 
    }
}
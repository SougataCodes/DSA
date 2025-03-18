class Solution {
    public boolean divideArray(int[] nums) {
        boolean x = true;
        if(nums.length%2 != 0)
        {
            return false;
        }
    Arrays.sort(nums);
    int i = 0;
    int j = 1;
    while(i<nums.length && j<nums.length)
    {
        if(nums[i] == nums[j])
        {
            x = true;
        }
        else
        {
            x = false;
            break;
        }
        i = i+2;
        j = j+2;
    }
    return x;  
    }
}
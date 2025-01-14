class Solution {
    private int func(int[] nums, int firstLen, int secondLen){

        int n = nums.length;
        int[] prefSum = new int[n+1];

        prefSum[0]=0;
        for(int i=1; i<n+1; i++)
            prefSum[i]=prefSum[i-1]+nums[i-1];

        int maxLen=0; 
        int result=0; 
        for(int i=firstLen+secondLen; i<=n; i++)
        {
            maxLen = Math.max(maxLen, prefSum[i-secondLen] - (prefSum[i - firstLen - secondLen]));
            result = Math.max(result, maxLen + (prefSum[i] - prefSum[i - secondLen]));
        }

        return result;
    } 

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(func(nums, firstLen, secondLen), func(nums, secondLen, firstLen));
    }
}
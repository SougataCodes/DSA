class Solution {
    public int numOfSubarrays(int[] arr) {
        int modulo=1000000007,n=arr.length;
        int[] dp=new int[2];
        dp[((arr[0]%2==0))?0:1]++;
        long sum=dp[1];
        for(int i=1;i<n;sum+=dp[1],i++){
            if(arr[i]%2==1) {
                int save=dp[1];
                dp[1]=dp[0]+1;
                dp[0]=save;
            }
            else 
                dp[0]++;
        }
        return (int)(sum%modulo);
    }
}
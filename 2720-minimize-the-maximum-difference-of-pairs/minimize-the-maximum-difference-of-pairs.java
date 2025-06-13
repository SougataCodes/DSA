class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        //my renage 0,1,2,3,4,-----
        int n  = nums.length;
        int l = 0;
        int r = nums[n-1]-nums[0];
        int result = 0;
        while(l<=r){
           int mid = l+(r-l)/2;

           if(isValid(nums , mid , p)){
              //try to get more minimum 
              r = mid-1;
              result = mid;

           }
           else{
              l = mid+1;
           }
        }
        return result; 
    }

    public boolean isValid(int [] nums , int mid , int p  ){
        int n   = nums.length;
        int count = 0;
        for(int i = 1; i<n;){
           int k = nums[i]-nums[i-1];
           if(k<=mid){
            count++;
            i+=2;
            }
            else i++;
        }
        return count>=p;
    }
}
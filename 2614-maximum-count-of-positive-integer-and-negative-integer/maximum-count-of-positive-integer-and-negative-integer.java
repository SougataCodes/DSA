class Solution {
    public int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int nidx=-1;
        int pidx= 2001;
        if(nums[0] < 0){
            //search the maximum -ve index 
            while(start<=end){
                int mid = start + (end-start)/2;
                if(nums[mid]<0){
                    nidx = Math.max(nidx,mid);
                    start = mid+1;
                }else end = mid-1;
            }
        }
        start = 0;
        end = nums.length-1;
        if(nums[end] > 0){
            //search the lowest +ve index
            while(start<=end){
                int mid = start + (end-start)/2;
                if(nums[mid]>0){
                    pidx = Math.min(pidx,mid);
                    end = mid-1;
                }else start = mid+1;
            }
        }
        if(pidx == 2001) pidx = nums.length+1;
        //return the max of -ve and +ve elements
        return Math.max(nidx+1,nums.length-pidx); 
    }
}
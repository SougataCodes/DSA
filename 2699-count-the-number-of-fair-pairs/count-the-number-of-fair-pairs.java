class Solution {
    public long countFairPairs(int[] nums, int l, int u) {
        int i=0;
        int j=nums.length-1;
        long count=0;
        Arrays.sort(nums);
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum<l) i++;
            else if(sum>u) j--;
            else{
              int left = lowerBoundSearch(nums,nums[i],l,i+1,j);
              int right = upperBoundSearch(nums,nums[i],u,i+1,j);
              count = count+right-left+1;
              i++;
            }
        }
        return count;
    }


    public int lowerBoundSearch(int[] arr,int val, int target,int s, int e){
        int result = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]+val>=target){
                result = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return result;
    }


     public int upperBoundSearch(int[] arr,int val, int target,int s, int e){
        int result = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]+val<=target){
                result = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return result;
    }
}
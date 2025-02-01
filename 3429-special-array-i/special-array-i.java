class Solution {
    public boolean isArraySpecial(int[] nums) {
        int l = nums.length;
        boolean check = true;
        for(int i=0; i<l-1; i++){
            if(!((nums[i]%2==0 && nums[i+1]%2==1) || (nums[i]%2==1 && nums[i+1]%2==0))){
                check = false;
                break;
            }
        }
        return check;
    }
}
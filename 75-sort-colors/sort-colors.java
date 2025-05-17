class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                c0++;
            } else if (nums[i] == 1) {
                c1++;
            } else {
                c2++;
            }
        }
        Arrays.fill(nums,0);
        int i=0;
        while(c0!=0)
        {
            nums[i]=0;
            c0--;
            i++;
        }
        while(c1!=0)
        {
            nums[i]=1;
            c1--;
            i++;
        }
        while(c2!=0)
        {
            nums[i]=2;
            c2--;
            i++;
        }
    }
}
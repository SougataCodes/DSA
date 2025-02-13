class Solution {
    public int minOperations(int[] nums, int k) {
        if (nums.length < 2){
            return 0;
        }

        Arrays.sort(nums);
        int indexPointer = 0;
        int skippedIndexes = 0;
        int minValueSkipped = Integer.MAX_VALUE;

        if (nums[0] == nums[nums.length-1] && nums[indexPointer]*2 > k){
            return (nums.length+1)/2;
        }

        while(nums[indexPointer] < k && indexPointer+1 < nums.length){
            if ((indexPointer < nums.length && nums[indexPointer] >= minValueSkipped) 
                  || indexPointer+1 < nums.length && nums[indexPointer+1] >= minValueSkipped){
                indexPointer -= skippedIndexes;
                skippedIndexes = 0;
                Arrays.sort(nums);
            }
            
            int x = nums[indexPointer];
            indexPointer++;
            int y = nums[indexPointer];
            int newValue = x*2 + y;
            nums[indexPointer-1] = Integer.MIN_VALUE;
            if (newValue > 0){
                nums[indexPointer] = newValue;
            }
            else{
                // Integer max value exceeded.
                nums[indexPointer] = Integer.MAX_VALUE;
            }

            if (skippedIndexes == 0){
                minValueSkipped = newValue;
            }

            indexPointer++;
            skippedIndexes++;
            
            if ((indexPointer < nums.length && nums[indexPointer] >= k) 
                    || (indexPointer+1 >= nums.length && skippedIndexes > 0)){
                indexPointer -= skippedIndexes;
                skippedIndexes = 0;
                Arrays.sort(nums);
            }
        }

        return indexPointer;
    }
}
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length, sortedNums[] = new int[n];
        for(int i = 0; i < nums.length; i++)    sortedNums[i] = nums[i];
        Arrays.sort(sortedNums);
        Map<Integer, Integer> belongsToGrp = new HashMap<>();
        List<Integer> grpPointers = new ArrayList<>();
        int prev = sortedNums[0];
        grpPointers.add(0);
        belongsToGrp.put(prev, 0);
        for(int i = 1; i < n; i++){
            if(Math.abs(sortedNums[i] - prev) > limit)    grpPointers.add(i);
            prev = sortedNums[i];
            belongsToGrp.put(prev, grpPointers.size() - 1);
        }
        int grpPointerArr[] = new int[grpPointers.size()];
        for(int i = 0; i < grpPointers.size(); i++)    grpPointerArr[i] = grpPointers.get(i);
        for(int i = 0; i < n; i++){
            int grp = belongsToGrp.get(nums[i]);
            nums[i] = sortedNums[grpPointerArr[grp]++];
        }
        return nums;
    }
}
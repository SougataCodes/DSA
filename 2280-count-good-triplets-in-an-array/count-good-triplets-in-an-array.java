class Solution {
    private int binarySearch(List<Integer> nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums1.length;
        int[] indexMap1 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            indexMap1[nums1[i]] = i;
        }
        int[] perm2 = new int[n];
        for (int i = 0; i < n; i++) {
            perm2[i] = indexMap1[nums2[i]];
        }
        int[] leftSmaller = new int[n];
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = binarySearch(sortedList, perm2[i]);
            leftSmaller[i] = index;
            sortedList.add(index, perm2[i]);
        }
        int[] rightGreater = new int[n];
        sortedList.clear();
        for (int i = n - 1; i >= 0; i--) {
            int index = binarySearch(sortedList, perm2[i]);
            rightGreater[i] = sortedList.size() - index;
            sortedList.add(index, perm2[i]);
        }
        for (int i = 0; i < n; i++) {
            count += (long) leftSmaller[i] * rightGreater[i];
        }
        return count;
    }
}
class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int prod = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                prod = nums[i] * nums[j];
                if (map.containsKey(prod)) {
                    int k = map.get(prod);
                    count += 8*k;
                    map.put(prod, k+1);
                } else {
                    map.put(prod, 1);
                }
            }
        }
        return count;
    }
}
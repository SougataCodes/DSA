class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr){
            numSet.add(num);
        }
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                int a = arr[i], b = arr[j];
                int length = 2;
                while (numSet.contains(a + b)){
                    int temp = a + b;
                    a = b;
                    b = temp;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength > 2 ? maxLength : 0;
    }
}
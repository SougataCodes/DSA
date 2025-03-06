class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNums = n * n; // Numbers in range [1, n²]

        HashSet<Integer> seen = new HashSet<>();
        int duplicate = -1, missing = -1;

        // Step 1: Find the duplicate number
        for (int[] row : grid) {
            for (int num : row) {
                if (!seen.add(num)) { // If already in set, it's duplicate
                    duplicate = num;
                }
            }
        }

        // Step 2: Find the missing number
        for (int i = 1; i <= totalNums; i++) {
            if (!seen.contains(i)) { // Number not in set is missing
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
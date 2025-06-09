class Solution {
    public int findKthNumber(int n, int k) {
        int currentPrefix = 1; // Start with prefix '1'
        k--; // Decrement k because we're already considering 1 as the first number
        
        // Loop until we find the k-th number
        while (k > 0) {
            long firstNumber = currentPrefix;
            long nextNumber = currentPrefix + 1;
            int count = 0;

            // Count how many numbers exist under the current prefix
            while (firstNumber <= n) {
                count += Math.min(n + 1, nextNumber) - firstNumber;
                firstNumber *= 10;
                nextNumber *= 10;
            }

            // If k is greater than the count of this prefix, skip to the next prefix
            if (k >= count) {
                currentPrefix++;
                k -= count; // Reduce k by the number of skipped numbers
            } 
            // Otherwise, go deeper into the current prefix
            else {
                currentPrefix *= 10;
                k--; // Move one step deeper in the prefix tree
            }
        }

        return currentPrefix; 
    }
}
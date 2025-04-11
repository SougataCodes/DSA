class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
         
        for (int i = low;i <= high; i++) {
            if (isSymetric(i)) {
                res += 1;
            }
        }
        return res;
    }

    boolean isSymetric(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() % 2 != 0) return false;
        String part1 = numStr.substring(0, numStr.length() / 2);
        String part2 = numStr.substring(numStr.length() / 2);
        int sum1 = sumDigits(part1);
        int sum2 = sumDigits(part2);
        if (sum1 == sum2)
            return true;
        return false;
    }

    public static int sumDigits(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }
}
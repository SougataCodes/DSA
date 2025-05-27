class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (isDivisible(i, m)) {
                num2 += i;
            }
            else num1 += i;
        }

        return num1 - num2;
    }

    public static boolean isDivisible(int dividend, int divisor) {
        double quotient = (double)dividend / (double)divisor;

        if (quotient == dividend / divisor) {
            return true;
        }

        return false;
    }
}
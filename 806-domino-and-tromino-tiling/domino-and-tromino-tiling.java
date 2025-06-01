class Solution {
    int MOD = 1000000007;
    public int numTilings(int n) {
        if(n < 3)
         return n;
        int first = 1 , second = 1 , third = 2;
        int temp = 0;
        for(int i=3;i<n+1;i++)
        {
        temp = (int)(((2L * third) + first) % MOD);
        first = second;
        second = third;
        third = temp;
        }

        return third;
    }
}
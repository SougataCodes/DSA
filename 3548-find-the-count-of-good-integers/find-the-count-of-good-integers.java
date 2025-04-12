class Solution {
    long ans = 0;
    Set<String> set;
    Long[] fact;
    public long countGoodIntegers(int n, int k) {
        char[] str = new char[n];
        fact = new Long[11];
        set = new HashSet<>();
        Arrays.fill(str, ' ');
        getAllFact(fact);
        generate(str, 0, k, n);
        return ans;
    }
    private void getAllFact(Long[] fact){
        fact[0] = 1L;
        fact[1] = 1L;
        for(int i=2;i<=10;i++)
            fact[i] = 1L*i*fact[i-1];
    }
    private boolean isKPalindrome(char[] str, int k){
        long val = Long.valueOf(new String(str));
        if(val%k==0){
            return true;
        }
        return false;
    }
    private long getPermutation(int[] freq, int n){
        long totalPerm = fact[n];
        for(int i=0;i<=9;i++){
            totalPerm /= fact[freq[i]];
        }
        return totalPerm;
    }
    private long getAllKPalindrome(char[] str){
        char[] copied = str.clone();
        Arrays.sort(copied);
        String num = new String(copied);  
        if(set.contains(num))
            return 0;
        set.add(num);
        int[] freq = new int[10];
        for(int i=0;i<str.length;i++){
            int val = str[i]-'0';
            freq[val]++;
        }
        long validPerm = getPermutation(freq, str.length);
        long invalidPerm = 0L;
        if(freq[0]>0){
            freq[0]--;
            invalidPerm = getPermutation(freq, str.length-1);
        }
        return validPerm - invalidPerm;
    }
    private void generate(char[] str, int pos, int k, int n){
        if(pos>=(n+1)/2){
            if(isKPalindrome(str, k))
                ans += getAllKPalindrome(str);
            return;
        }
        char start = pos==0?'1':'0';
        for(;start<='9';start++){
            str[pos] = start;
            str[n-pos-1] = start;
            generate(str, pos+1, k, n);
            str[pos] = ' ';
        }
    }
}
class Solution {
    public int minimumLength(String s) {
        
        int[] charFreq = new int[26];
        int total = 0;

        for(char c : s.toCharArray()){
            charFreq[c - 'a']++;
        }

        for(int freq : charFreq){
            if(freq == 0) continue;
            if(freq % 2 == 0) {
                total += 2;
            }
            else{
                total += 1;
            }
        }
        return total;
    }
}
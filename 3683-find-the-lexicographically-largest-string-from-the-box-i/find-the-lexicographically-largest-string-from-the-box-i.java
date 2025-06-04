class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;

        int n = word.length();
        int ansStart = 0;
        for(int i=1; i<n; i++) {
            int j = 0;
            while(i+j < n && word.charAt(i+j) == word.charAt(ansStart + j)) {
                j++;
            }

            if(i + j >= n) break;

            if(word.charAt(i+j) > word.charAt(ansStart + j)) {
                i = Math.max(ansStart + j, i);
                ansStart = i;
            } else if(word.charAt(i+j) < word.charAt(ansStart + j)){
                i = i + j;
            }
        }
        
        return word.substring(ansStart, Math.min(ansStart + n - numFriends + 1, n));
    }
}
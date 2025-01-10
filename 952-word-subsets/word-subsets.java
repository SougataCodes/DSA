class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        int[] fre = new int[26]; 

        
        for (String i : words2) {
            int[] temp = new int[26];
            for (int j = 0; j < i.length(); j++)
                temp[i.charAt(j) - 'a']++;
            for (int k = 0; k < 26; k++)
                fre[k] = Math.max(fre[k], temp[k]); 
        }

        List<String> ans = new ArrayList<>();

        here: for (int i = 0; i < words1.length; i++) {
            int[] x = new int[26];

            for (int j = 0; j < words1[i].length(); j++) {
                x[words1[i].charAt(j) - 'a']++;
            }

            for (int k = 0; k < 26; k++) 
                if (x[k] < fre[k]) 
                    continue here;

            ans.add(words1[i]);

        }

        return ans;
    }
}
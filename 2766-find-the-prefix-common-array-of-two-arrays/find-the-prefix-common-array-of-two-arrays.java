class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> hash=new HashMap<>(); 
        int count=0; 
        int n=A.length;
        int[] ans=new int[n];
        
        if(A[0]==B[0]){
            count++;
            ans[0]=count;
        }
        
        hash.put(A[0], 1);
        hash.put(B[0], 1);
        
        for(int i=1; i<n; i++)
        {
            if(A[i]==B[i])
                count++;
            else
            {
                if(hash.containsKey(A[i]))
                    count++;
                if(hash.containsKey(B[i]))
                    count++;
            }
            
            ans[i]=count;
            hash.put(A[i], hash.getOrDefault(A[i], 0)+1);
            hash.put(B[i], hash.getOrDefault(B[i], 0)+1);
        }
        
        return ans;
    }
}
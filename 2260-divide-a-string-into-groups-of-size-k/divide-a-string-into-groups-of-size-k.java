class Solution {
    public String[] divideString(String s, int k, char fill) {
        int j=0;
        String result[] = new String[(s.length()+k-1)/k];
        for(int i=0;i<s.length();i=i+k){
            String str;
            if(i+k-1>=s.length())
            {
                 str = s.substring(i,s.length());
            }
            else{
                 str = s.substring(i,i+k);
            }
            if(str.length()<k){
                int num = str.length();
                StringBuilder sb = new StringBuilder(str);
                while(sb.length()<k){
                    sb.append(fill);
                }
                result[j] = sb.toString();
                break;
            }
            result[j++]= str;
            
        } 
        return result;
    }
}
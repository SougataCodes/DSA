class Solution {
    public int maxDiff(int num) {
        StringBuilder str=new StringBuilder(Integer.toString(num));
        int n=str.length();
        StringBuilder maxStr=new StringBuilder(str);
        char found_dig='9';

        for(int i=0;i<n;i++){
            if(maxStr.charAt(i)!='9'){
                found_dig=maxStr.charAt(i);
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(maxStr.charAt(i)==found_dig){
                maxStr.setCharAt(i, '9');
            }
        }

        int maxInt=Integer.parseInt(maxStr.toString());

        //------------------------------------------------------------

        StringBuilder minStr=new StringBuilder(str);
        char found_digit='9';

        for(int i=0;i<n;i++){
            if(minStr.charAt(i)!='0' && minStr.charAt(i)!='1'){
                found_digit=minStr.charAt(i);
                break;
            }
        }

        char y='0';
        if(minStr.charAt(0)==found_digit)y='1';

        for(int i=0;i<n;i++){
            if(minStr.charAt(i)==found_digit){
                minStr.setCharAt(i, y);
            }
        }

        int minInt=Integer.parseInt(minStr.toString());
        return maxInt-minInt;
    }
}
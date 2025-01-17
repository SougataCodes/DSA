class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length-1;
        int xsum=0;
        for(int i=0;i<=n;i++){
            xsum^=derived[i];
        }
        if(xsum!=0){
            return false;
        }else{
            return true;
        }
    }
}
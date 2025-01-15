class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitCount=Integer.bitCount(num2);
        int x=0;
        //loop 1
        for(int i=31;i>=0 && setBitCount>0; i--){
            if((num1 & (1<<i))!=0){
                x^=(1<<i);
                setBitCount--;
            }
        }
        //loop 2
        for(int i=0;i<32 && setBitCount>0 ;i++){
            if((num1 & (1<<i))==0){
                x^=(1<<i);
                setBitCount--;
            }
        }
        return x;
    }
}
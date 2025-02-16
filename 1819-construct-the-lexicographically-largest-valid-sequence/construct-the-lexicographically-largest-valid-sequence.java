class Solution {
    private boolean b=false;
    public void backtrack(int index,boolean[] arr,int[] output){
        if(index==output.length){b=true;return;}
        if(output[index]!=0){backtrack(index+1,arr,output);if(b) return;}
        else{
            for(int i=arr.length-1;i>0;i--){
                if(i==1){
                    if(!arr[i]){
                        arr[i]=true;
                        output[index]=i;
                        backtrack(index+1,arr,output);
                        if(b) return;
                        arr[i]=false;
                        output[index]=0;
                    }
                }
                else{
                    if(!arr[i]){
                        if(index+i<output.length && output[index+i]==0){
                            arr[i]=true;
                            output[index]=i;output[index+i]=i;
                            backtrack(index+1,arr,output);
                            if(b) return;
                            arr[i]=false;
                            output[index]=0;output[index+i]=0;
                        }
                    }
                }
            }
        }
    }
    public int[] constructDistancedSequence(int n) {
        boolean[] arr=new boolean[n+1];
        int[] output=new int[2*n-1];
        backtrack(0,arr,output);
        return output;
    }
}
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] face = new int[7];

        for(int i = 0; i < tops.length; i++){
            face[tops[i]]++;

            if(tops[i] != bottoms[i]){
                face[bottoms[i]]++;
            }
        }
         
        int rotation = Integer.MAX_VALUE;

        for(int i = 1; i < 7; i++){
            if(face[i] < tops.length) continue;

            else{
                rotation = Math.min(rotation, (isPossible(i, tops, bottoms)));
            }
        }

        return rotation == Integer.MAX_VALUE ? -1 : rotation;
    }


    public int isPossible(int val, int[] tops, int[] bottoms){
        int topSwap = 0;
        int bottomSwap = 0;

        for(int i = 0; i < tops.length; i++){
            if(tops[i] != val){
                if(bottoms[i] == val){
                    topSwap++;
                }
                else{
                    return Integer.MAX_VALUE;
                }
            }
            if(bottoms[i] != val){
                if(tops[i] == val){
                    bottomSwap++;
                }
                else{
                    return Integer.MAX_VALUE;
                }
            }
        }

        return Math.min(topSwap, bottomSwap);
    }
}
class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int time;
        int br;
        public Pair(int x,int y,int t,int b){
            this.x=x;
            this.y=y;
            this.time=t;
            this.br=b;
        }
        @Override
        public int compareTo(Pair p2){
            return this.time-p2.time;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,0,1));
        long dp[][]=new long[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Long.MAX_VALUE);
        dp[0][0]=0;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
           Pair p=pq.remove();
           int i=p.x;
           int j=p.y;
           int time=p.time;
           int br=p.br;
           int newbr=(br==1)?2:1;
           int newT=time;
           for(int k=0;k<4;k++){
              int nx=i+dir[k][0];
              int ny=j+dir[k][1];
              if(nx>=0 && ny>=0 && nx<n && ny<m){
                  if(time>=moveTime[nx][ny]){
                     if(time+br<dp[nx][ny]) {
                        dp[nx][ny]=time+br;
                        pq.add(new Pair(nx,ny,time+br,newbr));
                     }
                  }
                  else{
                      int newwT=moveTime[nx][ny]+br;
                       if(newwT<dp[nx][ny]) {
                        dp[nx][ny]=newwT;
                        pq.add(new Pair(nx,ny,newwT,newbr));
                     }
                  }
                 
                 
              }
           }
        }
        return (int)dp[n-1][m-1];
    }
}
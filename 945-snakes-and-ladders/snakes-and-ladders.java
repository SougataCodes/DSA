class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int rolls=0;  // this is the number of steps to return.
        Queue<Integer> q=new LinkedList<>(); // creating Queue as in the approach for BFS.
        // Now initial pos is 1 so push it to queue.
        q.add(1);

        boolean[][] visited=new boolean[n][n];
        visited[n-1][0]=true;// this is for startng position.

        while(!q.isEmpty()){
            int size=q.size();// need size so that we know how many pos we can go in the curr step.

            for(int i=0;i<size;i++){
                int x=q.poll();// this is the value where we can reach.
                if(x==n*n) return rolls; // if x is our destination return steps.

                for(int j=1;j<=6;j++){// here j is no of steps we can move in the curr roll or dice.
                    if(x+j>n*n) break; // if out of board then no need to add in queue.

                    int [] pos=findPos(x+j,n);// need to find the row and col value for current x+j
                    int r=pos[0];// storing the row value in r
                    int c=pos[1];// storing the col value in c
                    
                    if(visited[r][c]) continue;// if the value at r,c is viited then no need to add it in the queue.

                    // else mark it as visited and...
                    visited[r][c]=true;

                    // add in the queue.
                    if(board[r][c]==-1){
                        q.add(x+j);
                    }
                    else{// this part is for the snake or ladder,that where we will reach by taking this snake or ladder.
                        q.add(board[r][c]);
                    }
                }
            }
            // now here we increase the dice roll.
            rolls++;
        }

        return -1; // this is dummy return as our logic will return from the above.
    }
    private int[] findPos(int curr, int n){
        int[] pos={-1,-1};

        int r=n-1-(curr-1)/n;
        int c=(curr-1)%n;
        if(r%2==n%2){// need this as we have zig-zag board of Snake And Ladders.
            c=n-1-c;
        }
        pos[0]=r;
        pos[1]=c;

        return pos;
    }
}
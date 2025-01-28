class Solution {
    public int findMaxFish(int[][] grid) {
        int max=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]!=0){
                   
                    max=Math.max(dfs(r,c,grid),max);
                     // System.out.println(max);
                }
                
            }

        }
        return max;
        
    }
    public static int dfs(int r,int c,int[][] grid){
        if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c]==0){
            return 0;
        }
        int res=grid[r][c];
        grid[r][c]=0;
        
        res+=dfs(r,c+1,grid)+dfs(r,c-1,grid)+dfs(r+1,c,grid)+dfs(r-1,c,grid);
        
        // System.out.println(res);
        
        return res;
    }
}
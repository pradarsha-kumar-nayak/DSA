class Solution {
    long sum=0;
    public void solve(int[][] grid,int r,int c){
    
        if(grid[r][c] !=0){
            sum+=grid[r][c];
            grid[r][c]=0;
        }

        //upper
        if(r-1 >=0 && grid[r-1][c] !=0){
            solve(grid,r-1,c);
        }

         //down
        if(r+1 <grid.length && grid[r+1][c] !=0){
            solve(grid,r+1,c);
        }

         //left
        if(c-1 >=0 && grid[r][c-1] !=0){
            solve(grid,r,c-1);
        }

         //right
        if(c+1 <grid[0].length && grid[r][c+1] !=0){
            solve(grid,r,c+1);
        }

         
    }
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] !=0){
                    sum=0;
                    solve(grid,i,j);

                    if(sum%k == 0){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
class Solution {
    public boolean checkcol(int[][] grid,int col){
         int count=0;

         for(int i=0;i<grid.length;i++){
            if(grid[i][col] == 1){
                count ++;
            }
         }

         if(count >1){
            return true;
         }else{
            return false;
         }
    }
    public int checkrow(int[][] grid,int row,int col){
        int count=0;
        for(int i=col;i<grid[0].length;i++){
            if(grid[row][i] ==1){
                count++;
            }
        }
        return count;
    }
    public int countServers(int[][] grid) {
        
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j] ==1){
                    int val=checkrow(grid,i,j);
                    if(val>1){
                        ans+=val;
                        break;
                    }else{
                       if(checkcol(grid,j)){
                         ans++;
                       }
                    }
                }
            }
        }

        return ans;
    }
}
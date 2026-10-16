class Solution {
    ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    int r=0;
    int c=0;
    int n;
    int m;
    public void solve(int row,int col,int[][] land,ArrayList<Integer>ar){
        land[row][col]=0;

        if(r == row){
          c=Math.max(c,col);
        }else{
            r=row;
            c=col;
        }

        //right
        if(col+1<m && land[row][col+1]==1){
            solve(row,col+1,land,ar);
        }
        
        //left
        if(col-1>=0 && land[row][col-1]==1){
            solve(row,col-1,land,ar);
        }

        //top
        if(row-1>=0 && land[row-1][col]==1){
            solve(row-1,col,land,ar);
        }

        //down
        if(row+1 <n && land[row+1][col]==1){
            solve(row+1,col,land,ar);
        }

        ar.add(r);
        ar.add(c);

    }
    public int[][] findFarmland(int[][] land) {
         n=land.length;
         m=land[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ArrayList<Integer>ar=new ArrayList<>();

                if(land[i][j] ==1){
                    ar.add(i);
                    ar.add(j);
                    solve(i,j,land,ar);
                    r=0;
                    c=0;
                    ans.add(ar);
                }
                
            }
        }

        int rlen=ans.size();
        int clen=4;

        int res[][]=new int[rlen][clen];

        for(int i=0;i<rlen;i++){
            for(int j=0;j<clen;j++){
                res[i][j]=ans.get(i).get(j);
            }
        }

        return res;
        
    }
}
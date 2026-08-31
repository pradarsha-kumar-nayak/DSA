class Solution {
    class hlp{
        int dif;
        int row;
        int col;

        public hlp(int dif,int row,int col){
            this.dif=dif;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int diff[][]=new int[n][m];
        boolean vis[][]=new boolean[n][m];
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]=Integer.MAX_VALUE;
            }
        }
         diff[0][0]=0;
        PriorityQueue<hlp>pq=new PriorityQueue<>((a,b)->a.dif-b.dif);
        
        pq.add(new hlp(0,0,0));

        while(!pq.isEmpty()){
           hlp cur=pq.remove();
           int prevdif=cur.dif;
           int i=cur.row;
           int j=cur.col;
           int prevval=heights[i][j];

           if(vis[i][j]==true)continue;

           vis[i][j]=true;

           if(i==n-1 && j==m-1){
            return prevdif;
           }
          
        
        //right
           if(j+1 < m){
            int curval=heights[i][j+1];
            int curdif=Math.abs(prevval-curval);
            int maxdif=Math.max(prevdif,curdif);
            diff[i][j+1]=Math.min(diff[i][j+1],maxdif);
            pq.add(new hlp(maxdif,i,j+1));
           }

        //left
           if(j-1 >=0){
            int curval=heights[i][j-1];
            int curdif=Math.abs(prevval-curval);
            int maxdif=Math.max(prevdif,curdif);
            diff[i][j-1]=Math.min(diff[i][j-1],maxdif);
             pq.add(new hlp(maxdif,i,j-1));
           }

        //down
           if(i+1 <n){
            int curval=heights[i+1][j];
            int curdif=Math.abs(prevval-curval);
            int maxdif=Math.max(prevdif,curdif);
            diff[i+1][j]=Math.min(diff[i+1][j],maxdif);
             pq.add(new hlp(maxdif,i+1,j));
           }

        //top
           if(i-1 >=0){
            int curval=heights[i-1][j];
            int curdif=Math.abs(prevval-curval);
            int maxdif=Math.max(prevdif,curdif);
            diff[i-1][j]=Math.min(diff[i-1][j],maxdif);
             pq.add(new hlp(maxdif,i-1,j));
           }

        }

        return diff[n-1][m-1];

    }
}
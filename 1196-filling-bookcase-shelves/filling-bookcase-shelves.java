class Solution {
    int width;
    int dp[][];
    public int solve(int[][] books,int i,int remwdth,int height){
        if(i == books.length){
            return height;
        }

        if(dp[i][remwdth] !=-1){
            return dp[i][remwdth];
        }

        int bookw=books[i][0];
        int bookh=books[i][1];

        int keep=Integer.MAX_VALUE;
        int skip=Integer.MAX_VALUE;

        if(remwdth >= bookw){
            keep=solve(books,i+1,remwdth-bookw,Math.max(height,bookh));
        }

        skip= height + solve(books,i+1,width-bookw,bookh);

        return dp[i][remwdth]=Math.min(keep,skip);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp=new int[1001][1001];

        for(int i=0;i<1001;i++){
            Arrays.fill(dp[i],-1);
        }
        width=shelfWidth;
        return solve(books,0,shelfWidth,0);
    }
}
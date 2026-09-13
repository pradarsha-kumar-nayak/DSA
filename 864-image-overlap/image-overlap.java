class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        ArrayList<int[]>A=new ArrayList<>();
        ArrayList<int[]>B=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(img1[i][j] ==1){
                    A.add(new int[]{i,j});
                }
                if(img2[i][j]==1){
                    B.add(new int[]{i,j});
                }
            }
        }

        int cnt[][]=new int[n*2][n*2];
        int best=0;
        for(int[] a:A ){
            for(int[] b:B){
                int row=b[0]-a[0]+n;
                int col=b[1]-a[1]+n;

                best=Math.max(best,++cnt[row][col]);
            }
        }

        return best;
    }
}
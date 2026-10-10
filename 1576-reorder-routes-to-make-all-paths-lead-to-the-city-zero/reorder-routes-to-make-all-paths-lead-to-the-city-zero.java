class Solution {
    class edg{
        int src;
        int dst;
        int dir;

        public edg(int src,int dst, int dir){
            this.src=src;
            this.dst=dst;
            this.dir=dir;
        }
    }
    int anscount=0;

    public void solve(ArrayList<edg>gph[],boolean vis[],int s){

        vis[s]=true;

        for(int i=0;i<gph[s].size();i++){

            edg e=gph[s].get(i);

            if(!vis[e.dst]){
                if(e.dir==1){
                    anscount++;
                }
                solve(gph,vis,e.dst);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        
        ArrayList<edg>gph[]=new ArrayList[n];

        for(int i=0;i<n;i++){
            gph[i]=new ArrayList<>();
        }

        for(int i=0;i<connections.length;i++){

            int ar[]=connections[i];

            gph[ar[0]].add(new edg(ar[0],ar[1],1));
            gph[ar[1]].add(new edg(ar[1],ar[0],0));
        }

        boolean vis[]=new boolean[n];

        solve(gph,vis,0);

        return anscount;
    }
}
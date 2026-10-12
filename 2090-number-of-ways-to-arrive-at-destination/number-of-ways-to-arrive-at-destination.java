class Solution {
    class edg{
        int src;
        int dst;
        int wt;

        public edg(int src,int dst, int wt){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
        }
    }
    
     class pair implements Comparable<pair>{
        int n;
        long min;

        public pair(int n,long min){
            this.n=n;
            this.min=min;
        }

        @Override
        public int compareTo(pair p2){
           return Long.compare(this.min,p2.min);
        }
     }
     
     int mod=1000000007;
    public int solve( ArrayList<edg>gph[],int s,long min,int tar,long w,boolean vis[],int dp[], long dist[]){
        if(w>min){
            return 0;
        }
        
        if(dp[s]!=-1){
            return dp[s];
        }
        if(s ==tar){
            return 1;
        }
        
        if(vis[s]==true){
            return 0;
        }

        vis[s]=true;
        int res=0;
        
            for(int i=0;i<gph[s].size();i++){
               edg e=gph[s].get(i);
               if(dist[s]+e.wt == dist[e.dst]){
                  res=(res+solve(gph,e.dst,min,tar,w+e.wt,vis,dp,dist))%mod;
               }
               
            }
     

        vis[s]=false;
        
        return dp[s]=res;
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<edg>gph[]=new ArrayList[n];

        for(int i=0;i<n;i++){
            gph[i]=new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){
            int arr[]=roads[i];

            gph[arr[0]].add(new edg(arr[0],arr[1],arr[2]));
            gph[arr[1]].add(new edg(arr[1],arr[0],arr[2]));
        }

        long dist[]=new long[n];

        for(int i=1;i<n;i++){

            dist[i]=Long.MAX_VALUE;
        }

        PriorityQueue<pair>pq=new PriorityQueue<>();
        boolean vis[]=new boolean[n];

        pq.add(new pair(0,0));

        while(!pq.isEmpty()){

            pair cur=pq.remove();

            if(!vis[cur.n]){

                vis[cur.n]=true;

                for(int i=0;i<gph[cur.n].size();i++){
                    edg e=gph[cur.n].get(i);

                    int s=e.src;
                    int d=e.dst;
                    int w=e.wt;

                    if(dist[s]+w < dist[d]){
                        dist[d]=dist[s]+w;
                         pq.add(new pair(d, dist[d]));
                    }
                }
            }
        }

         boolean visit[]=new boolean[n];
         int dp[]=new int[n];
         Arrays.fill(dp,-1);

     return  (int) solve(gph,0,dist[n-1],n-1,0,visit,dp,dist);

    }
}
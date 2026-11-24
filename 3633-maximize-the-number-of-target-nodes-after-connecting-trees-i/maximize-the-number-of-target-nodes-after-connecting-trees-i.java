class Solution {
    class edg{
        int src;
        int dst;

        public edg(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
    }
    
    public int solve(int s,ArrayList<edg>graph[],boolean vis[],int k){
         if(k <0){
            return 0;
         }
         vis[s]=true;

         if(k ==0){
            return 1;
         }

         int sum=1;

         for(int i=0;i<graph[s].size();i++){

            edg e=graph[s].get(i);

            if(!vis[e.dst]){
               sum+=solve(e.dst,graph,vis,k-1);
            }
         }
        
        return sum;

    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length;
        int m=edges2.length;
        ArrayList<edg>graph1[]=new ArrayList[n+1];
        ArrayList<edg>graph2[]=new ArrayList[m+1];

        for(int i=0;i<n+1;i++){
            graph1[i]=new ArrayList<>();
        }

        for(int i=0;i<m+1;i++){
            graph2[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
           
           int arr[]=edges1[i];

           int s=arr[0];
           int d=arr[1];

           graph1[s].add(new edg(s,d));
           graph1[d].add(new edg(d,s));
        }

        for(int i=0;i<m;i++){
           
           int arr[]=edges2[i];

           int s=arr[0];
           int d=arr[1];

           graph2[s].add(new edg(s,d));
           graph2[d].add(new edg(d,s));
        }

        int ans[]=new int[n+1];

        for(int i=0;i<n+1;i++){
            
            boolean vis[]=new boolean[n+1];

            ans[i]=solve(i,graph1,vis,k);
        }

        int edg2[]=new int[m+1];

         for(int i=0;i<m+1;i++){
            
            boolean vis[]=new boolean[m+1];

            edg2[i]=solve(i,graph2,vis,k-1);

        }

        int max=0;

        for(int i=0;i<edg2.length;i++){
            max=Math.max(edg2[i],max);
        }

        for(int i=0;i<ans.length;i++){
            ans[i]+=max;
        }

      return ans;
    }
}
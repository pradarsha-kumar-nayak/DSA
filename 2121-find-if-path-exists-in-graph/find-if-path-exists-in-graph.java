class Solution {
    class edg{
        int src;
        int dst;

        public edg(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
    }

    public boolean solve(int s,int d,ArrayList<edg>graph[],boolean vis[]){
       
       vis[s]=true;

       if(s==d){
        return true;
       }


       for(int i=0;i<graph[s].size();i++){
          edg e=graph[s].get(i);
          if(!vis[e.dst] && solve(e.dst,d,graph,vis)){
            return true;
          }
       }

       return false;

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       ArrayList<edg>graph[]=new ArrayList[n];

       for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
       }

       for(int i=0;i<edges.length;i++){
           
           int arr[]=edges[i];

           int s=arr[0];
           int d=arr[1];

           graph[s].add(new edg(s,d));
           graph[d].add(new edg(d,s));

       }

       boolean vis[]=new boolean[n];

      return solve(source,destination,graph,vis);

    }
}
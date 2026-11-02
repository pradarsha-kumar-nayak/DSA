class Solution {
    class hlp{
        boolean v;
        int curentcount;

        public hlp(boolean v,int curentcount){
            this.v=v;
            this.curentcount=curentcount;
        }
    }
    int maxlen=-1;
    public void solve(int[] edges,boolean vis[],hlp stack[],int i,int count){
       vis[i]=true;
       stack[i]=new hlp(true,count);

       if(edges[i]==-1){
        stack[i]=null;
        return;
       }

       if(stack[edges[i]] != null && stack[edges[i]].v){
         maxlen=Math.max(maxlen,count-stack[edges[i]].curentcount+1);
        
       }
       else if(!vis[edges[i]]){
          solve(edges,vis,stack,edges[i],count+1);
       }
       
       

       stack[i]=null;


    }
    public int longestCycle(int[] edges) {
      
      int n=edges.length;

      boolean vis[]=new boolean[n];
      hlp stack[]=new hlp[n];

      for(int i=0;i<n;i++){

        if(vis[i] == false){
            solve(edges,vis,stack,i,1);
        }
      }

      return maxlen;

    }
}
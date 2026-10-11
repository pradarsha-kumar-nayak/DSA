class Solution {
    class edg{
        int src;
        int dst;
        // int tim;

        public edg(int src,int dst){
            this.src=src;
            this.dst=dst;
            // this.tim=tim;
        }
    }
    
    public void helper(ArrayList<edg>gph[],int index[]){
        

        for(int i=0;i<gph.length;i++){
            for(int j=0;j<gph[i].size();j++){
                edg e=gph[i].get(j);

                index[e.dst]++;
            }
        }
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<edg>gph[]=new ArrayList[n];

        for(int i=0;i<n;i++){
            gph[i]=new ArrayList<>();
        }

        for(int i=0;i<relations.length;i++){
            int arr[]=relations[i];
            
            int s=arr[0]-1;
            int d=arr[1]-1;
            gph[s].add(new edg(s,d));
        }

        int index[]=new int[n];
        helper(gph,index);

        int finish[]=new int[n];
         
        Queue<Integer>q=new LinkedList<>();

        for(int i=0;i<n;i++){
            
            if(index[i] ==0){
               
                q.add(i);
                finish[i]=time[i];
            }
        }
        
        int ans=0;
       

        while(! q.isEmpty()){
                 
                 int cur=q.remove();
                 ans=Math.max(ans,finish[cur]);

                 for(int i=0;i<gph[cur].size();i++){
                     edg e=gph[cur].get(i);
                     index[e.dst]--;

                     finish[e.dst]=Math.max(finish[e.dst],finish[cur]+time[e.dst]);

                     if(index[e.dst] ==0){
                        
                         q.add(e.dst);
                     }
                 }
                
            
           
        }

      return ans;

    }
}
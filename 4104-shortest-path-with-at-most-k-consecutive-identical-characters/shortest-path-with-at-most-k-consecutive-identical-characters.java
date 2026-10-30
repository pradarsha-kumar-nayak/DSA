class Solution {
    class node {
        int src;
        int dst;
        int wt;
        char ch;

        public node(int src,int dst,int wt,char ch){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
            this.ch=ch;
          
        }
    }

    class pair implements Comparable<pair>{
            
            int n;
            int dist;
            char c;
            int k;

            public pair(int n,int dist,char c, int k){
                this.n=n;
                this.dist=dist;
                this.c=c;
                this.k=k;
            }

            @Override

            public int compareTo(pair p2){
                return this.dist - p2.dist;
            }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        ArrayList<node>graph[]=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){

            int arr[]=edges[i];

            int s=arr[0];
            int d=arr[1];
            int w=arr[2];

            graph[s].add(new node(s,d,w,labels.charAt(s)));
        }


        PriorityQueue<pair> pq=new PriorityQueue<>();
        int distance[][]=new int[n][k+1];

        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        distance[0][k]=0;

        pq.add(new pair(0,0,labels.charAt(0),k));

        while(! pq.isEmpty()){
              
              pair cur=pq.remove();

              if(cur.n == n-1){
                return cur.dist;
              }

            for(int i=0;i<graph[cur.n].size();i++){

                node e=graph[cur.n].get(i);

                int s=e.src;
                int d=e.dst;
                int w=e.wt;
                
                int nk;
                if(labels.charAt(d) == e.ch){
                    nk=cur.k-1;

                    if(nk ==0){
                        continue;
                    }
                }else{
                    nk=k;
                }

                int nd=cur.dist+w;

                if(nd < distance[d][nk]){
                    distance[d][nk]=nd;
                    pq.add(new pair(d,nd,labels.charAt(d),nk));
                }

            }
        }

        return -1;
    }
}
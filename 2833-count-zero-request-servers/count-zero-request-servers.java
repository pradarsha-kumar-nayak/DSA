class Solution {
    class qry{
        int e;
        int i;

        public qry(int e,int i){
            this.e=e;
            this.i=i;
        }
    }
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m=logs.length;
        
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int ans[]=new int[queries.length];

        qry query[]=new qry[queries.length];

        for(int i=0;i<query.length;i++){
            query[i]=new qry(queries[i],i);
        }

        Arrays.sort(query,(a,b)->a.e-b.e);
        
        int j=0;
        int k=0;

        HashMap<Integer,Integer>hm=new HashMap<>();

        for(int i=0;i<query.length;i++){
           
            int fst=query[i].e-x;
            int lst=query[i].e;
            int idx=query[i].i;

            while(j<m && k<m){

                if(logs[j][1] >=fst && logs[k][1]>lst ){
                    ans[idx]=n-hm.size();
                    break;
                }

                // if(logs[j][1] >= fst && logs[j][1] <= lst && logs[k][1]>lst){
                //     ans[idx]=n-hm.size();
                //     break;
                // }

                if(logs[j][1] < fst && logs[k][1] < fst){
                    
                    if(hm.containsKey(logs[j][0])){

                        hm.put(logs[j][0],hm.get(logs[j][0])-1);
                        if(hm.get(logs[j][0]) == 0){
                           hm.remove(logs[j][0]);
                        }
                    }

                    j++;
                    k++;
                }
                else if(logs[j][1] <fst && logs[k][1] >=fst && logs[k][1] <= lst){
                    if(hm.containsKey(logs[j][0])){

                        hm.put(logs[j][0],hm.get(logs[j][0])-1);
                        if(hm.get(logs[j][0]) == 0){
                           hm.remove(logs[j][0]);
                        }
                    }
                    j++;
                }
                else if(logs[j][1] >=fst && logs[j][1]<=lst && logs[k][1] >=fst && logs[k][1] <= lst){
                       
                       hm.put(logs[k][0],hm.getOrDefault(logs[k][0],0)+1);
                       k++;

                }
                else if( logs[j][1] < fst && logs[k][1] >lst){
                    if(hm.containsKey(logs[j][0])){

                        hm.put(logs[j][0],hm.get(logs[j][0])-1);
                        if(hm.get(logs[j][0]) == 0){
                           hm.remove(logs[j][0]);
                        }
                    }
                    j++;
                }
            }

            
            if(k == m){

                while(j <m){


                     if(logs[j][1] >= fst){
                       ans[idx]=n-hm.size();
                       break;
                     }

                     if(logs[j][1] <fst){
                        if(hm.containsKey(logs[j][0])){

                        hm.put(logs[j][0],hm.get(logs[j][0])-1);
                        if(hm.get(logs[j][0]) == 0){
                           hm.remove(logs[j][0]);
                        }
                      }
                    j++;
                  }

                }

                if(j==m){
                     ans[idx]=n-hm.size();
                }
            }

 
        }

       
        return ans;
    }
}
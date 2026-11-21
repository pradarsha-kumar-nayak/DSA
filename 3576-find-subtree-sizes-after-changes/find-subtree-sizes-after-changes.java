class Solution {
    HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
    int res[];
    int nxtchar[];

    public void solve(int[] parent, String s,int cur){

        int c=s.charAt(cur)-'a';

        int nxtnei=nxtchar[c];

        nxtchar[c]=cur;
        
        if(hm.containsKey(cur)){
            for(int i=0;i<hm.get(cur).size();i++){
               int nxt= hm.get(cur).get(i);

               solve(parent,s,nxt);
          }
        }
       

        nxtchar[c]=nxtnei;

        if(cur != 0){
            int nxtpar=parent[cur];

            if(nxtnei !=-1){
                nxtpar=nxtnei;
            }

            res[nxtpar]+=res[cur];
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        res=new int[n];
        nxtchar=new int[26];

        Arrays.fill(res,1);
        Arrays.fill(nxtchar,-1);

        for(int i=1;i<parent.length;i++){

            int u=parent[i];
            int v=i;

            if(!hm.containsKey(u)){
                ArrayList<Integer>ar=new ArrayList<>();
                ar.add(v);
                hm.put(u,ar);
            }else{
               ArrayList<Integer>ar=hm.get(u);
               ar.add(v);
            }

            
        }

        solve(parent,s,0);

        return res;


    }
}
class Solution {
    public int helper(String str1,String str2){
        int i=0;
        int j=0;
        int count=0;
        while(i<str1.length()){

            if(str1.charAt(i) != str2.charAt(j)){
             count++;
            }
            i++;
            j++;
        }

        return count;
    }
    int n;
    int rank[];
    int par[];
    public int findpar(int x){
        
        if(x == par[x]){
            return x;
        }

        return par[x]=findpar(par[x]);
    }

    public void dsu(int i, int j){
        int parA=findpar(i);
        int parB=findpar(j);

        if(rank[parA] == rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    public int numSimilarGroups(String[] strs) {
        n=strs.length;
        rank=new int[n];
        par=new int[n];
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int dif=helper(strs[i],strs[j]);

                if(dif ==0 || dif ==2){
                    dsu(i,j);
                }
            }
        }

        HashSet<Integer>hs=new HashSet<>();

        for(int i=0;i<strs.length;i++){
           int par= findpar(i);

           hs.add(par);
        }

        return hs.size();
    }
}
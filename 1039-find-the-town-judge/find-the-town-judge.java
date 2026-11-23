class Solution {
    public int findJudge(int n, int[][] trust) {
        
       HashSet<Integer>hs=new HashSet<>();
       HashMap<Integer,Integer>hm=new HashMap<>();

        for(int i=0;i<trust.length;i++){

            int arr[]=trust[i];

            hm.put(arr[1],hm.getOrDefault(arr[1],0)+1);

            hs.add(arr[0]);
        }
       
       if(trust .length >0){
            for(int i=1;i<=n;i++){
            if(!hs.contains(i) &&  hm.getOrDefault(i,0)==n-1){
                return i;
            }
        }
       }else if(trust.length ==0 && n==1){
        return 1;
       }
       

        return -1;
    }
}
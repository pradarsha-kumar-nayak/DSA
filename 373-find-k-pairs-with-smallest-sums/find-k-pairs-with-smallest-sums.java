class Solution {
    class pair{
        int sum;
        int idx1;
        int idx2;

        public pair(int sum,int idx1,int idx2){
            this.sum=sum;
            this.idx1=idx1;
            this.idx2=idx2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      int n=nums1.length;
      int m=nums2.length;
      List<List<Integer>>ans=new ArrayList<>();
      PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
        return a.sum-b.sum;
      });
      HashSet<String>hs=new HashSet<>();

      pq.add(new pair(nums1[0]+nums2[0],0,0));
      while(k >0 && pq.size() >0){
          
          pair cur=pq.remove();
          
        //   hs.add(cur.idx1+"_"+(cur.idx2));
          List<Integer>li=new ArrayList<>();
          li.add(nums1[cur.idx1]);
          li.add(nums2[cur.idx2]);

          ans.add(li);

         if(cur.idx1+1 <n && !hs.contains(cur.idx1+1+"_"+(cur.idx2))){
             hs.add(cur.idx1+1+"_"+(cur.idx2));
            pq.add(new pair(nums1[cur.idx1+1]+nums2[cur.idx2],cur.idx1+1,cur.idx2));
         }

         if(cur.idx2+1 <m && !hs.contains(cur.idx1+"_"+(cur.idx2+1))){
             hs.add(cur.idx1+"_"+(cur.idx2+1));
            pq.add(new pair(nums2[cur.idx2+1]+nums1[cur.idx1],cur.idx1,cur.idx2+1));
         }

         k--;

      }

      return ans;
      
    }
}
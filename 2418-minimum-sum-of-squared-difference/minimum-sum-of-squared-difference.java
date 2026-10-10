class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int k=k1+k2;
        int arr[]=new int[100001];

        for(int i=0;i<nums1.length;i++){

            int dif=Math.abs(nums1[i]-nums2[i]);
            arr[dif]++;
        }

        for(int i=100000;i>0;i--){
           
           if(k==0){
            break;
           }

           if(arr[i] >0){
             int mindif=Math.min(arr[i],k);
            
             arr[i]-=mindif;
             arr[i-1]+=mindif;

             k-=mindif;
           }
        }
        long ans=0;

        for(int i=0;i<100001;i++){
            
            if(arr[i] >0){
               long sqr=(long)i*i*arr[i];
               ans+=sqr;
            }
           
        }
        return ans;
    }
}
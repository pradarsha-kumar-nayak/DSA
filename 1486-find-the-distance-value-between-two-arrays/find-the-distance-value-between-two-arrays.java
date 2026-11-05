class Solution {
    public boolean checktrue(int[] arr2,int tar,int d){
        int lft=0;
        int rit=arr2.length-1;

        while(lft <= rit){

            int mid=(lft +rit)/2;

            if(Math.abs(tar-arr2[mid]) <=d){
                return false;
            }

            if(tar > arr2[mid]){
                lft=mid+1;
            }else{
                rit=mid-1;
            }
        }

        return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        Arrays.sort(arr2);
        int ans=0;

        for(int i=0;i<arr1.length;i++){
             
             if(checktrue(arr2,arr1[i],d)){
                ans++;
             }
        }

        return ans;
    }
}
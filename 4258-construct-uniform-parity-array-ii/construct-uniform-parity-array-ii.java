class Solution {
    public boolean uniformArray(int[] nums) {
        int n=nums.length;
        int oddcnt=0;
        int evncnt=0;

        boolean sameodd=true;
        int prifixodd[]=new int[n];
        int sufixodd[]=new int[n];

        boolean fst=true;
        int fstodd=-1;

        if(nums[0] %2 !=0){
            prifixodd[0]=nums[0];
        }else{
            prifixodd[0]=Integer.MAX_VALUE;
        }

        if(nums[n-1] %2 !=0){
            sufixodd[n-1]=nums[n-1];
        }else{
            sufixodd[n-1]=Integer.MAX_VALUE;
        }

        //prifixodd

        for(int i=1;i<n;i++){
            if(nums[i] %2!=0){
               prifixodd[i]=Math.min(prifixodd[i-1],nums[i]);
            }else{
                prifixodd[i]=prifixodd[i-1];
            }
        }

        //sufixodd

        for(int i=n-2;i>=0;i--){
            if(nums[i] %2 !=0){
                sufixodd[i]=Math.min(sufixodd[i+1],nums[i]);
            }else{
                sufixodd[i]=sufixodd[i+1];
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i] %2 !=0){
                oddcnt++;
                if(fst){
                    fstodd=nums[i];
                    fst=false;
                }else{
                    if(fstodd != nums[i]){
                        sameodd=false;
                    }
                }
            }else{
                evncnt++;
            }
        }

        if(oddcnt ==n || evncnt ==n){
            return true;
        }

        boolean point[]=new boolean[n];

        for(int i=0;i<n;i++){

            if(nums[i] %2 ==0){

                if(prifixodd[i] < nums[i] || sufixodd[i]< nums[i]){
                    point[i]=true;
                }
            }else{
               point[i]=true;
            }
        }

        boolean boolpnt=true;

        for(int i=0;i<n;i++){
            if(point[i] == false){
                boolpnt=false;
            }
        }

        if(boolpnt){
            return true;
        }

        if(sameodd == true && oddcnt >1){
            return true;
        }else{
            return false;
        }


    }
}
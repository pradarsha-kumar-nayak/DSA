class Solution {
    public int[] minsecmin(ArrayList<int[]>ar){
        int min=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;

        for(int i=0;i<ar.size();i++){

            if(ar.get(i)[0] <= min){
                secmin=min;
                min=ar.get(i)[0];
            }
        }

        for(int i=0;i<ar.size();i++){
            if(ar.get(i)[0] >min && ar.get(i)[0] <secmin ){
                secmin=ar.get(i)[0];
            }
        }

        return new int[]{min,secmin};
    }
    public int[] splminsecmin(ArrayList<Integer>ar){
        int min=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;

        for(int i=0;i<ar.size();i++){

            if(ar.get(i) <= min){
                secmin=min;
                min=ar.get(i);
            }
        }

        for(int i=0;i<ar.size();i++){
            if(ar.get(i) >min && ar.get(i) <secmin ){
                secmin=ar.get(i);
            }
        }

        return new int[]{min,secmin};
    }
    public int minSumOfLengths(int[] arr, int target) {
        int lft=0;
        long sum=0;
        int spllft=0;
        int splsum=0;
        ArrayList<Integer>splar=new ArrayList<>();
        ArrayList<int[]>ar=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            splsum+=arr[i];


             while(splsum > target){
                splsum-=arr[spllft];
                spllft++;
            }

            if(splsum == target){
                int len=i-spllft+1;
                splar.add(len);
                spllft=i+1;
                splsum=0;
            }
            
           
            while(sum > target){
                sum-=arr[lft];
                lft++;
            }
             if(sum == target){
                // ar.add(i-lft+1);
                int len=i-lft+1;
                int res[]=new int[2];
                res[0]=len;
                res[1]=i;

                if(ar.size() >0){
                    int prevlen[]=ar.get(ar.size()-1);
                    if(prevlen[1] >=lft && prevlen[0] >=len){
                        prevlen[0]=len;
                        prevlen[1]=i;
                    }else if(prevlen[1] < lft){
                        ar.add(res);
                    }
                }else{
                    ar.add(res);
                }
            }

        }
        
        int splminsecmin[]=splminsecmin(splar);
        int splval=splminsecmin[0]+splminsecmin[1];

        if(ar.size() <2 && splar.size() >1){
            return splval;
        }

        if(ar.size() <2 && splar.size() <2){
            return -1;
        }
        

        int minsecmin[]=minsecmin(ar);

        return Math.min(minsecmin[0]+minsecmin[1],splval);
    }
}
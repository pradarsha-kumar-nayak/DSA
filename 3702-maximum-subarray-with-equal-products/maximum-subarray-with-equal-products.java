class Solution {

    public int solveGcd(int n1,int n2){

        while(n1%n2 !=0){
            int ref=n1%n2;
            n1=n2;
            n2=ref;
        }

        return n2;
    }

    public int solveLcm(int n1,int n2){

        int max=Math.max(n1,n2);

        while(true){

            if(max%n1 ==0 && max%n2==0){
                return max;
            }
            max++;
        }
       
    }
    public int maxLength(int[] nums) {
        
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int gcd=0;
            int lcm=1;
            int pro=1;

            for(int j=i;j<nums.length;j++){
                pro*=nums[j];

                int G=solveGcd(gcd,nums[j]);
                int L=solveLcm(lcm,nums[j]);

                if(pro == G*L){
                    ans=Math.max(ans,j-i+1);
                }

                gcd=G;
                lcm=L;
            }

        }

        return ans;
    }
}
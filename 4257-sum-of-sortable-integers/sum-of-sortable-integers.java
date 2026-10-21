class Solution {
    
    public void findlps(int lps[],int pat[]){

        int n=pat.length;
        int i=1;
        int len=0;

        while(i<n){

            if(pat[i] == pat[len]){
                len++;
                lps[i]=len;
                i++;
            }else{

                if(len !=0){
                  len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
    public boolean useingKMP(int num[],int pat[]){

        int cpynum[]=new int[num.length+num.length];

        for(int i=0;i<cpynum.length;i++){

            cpynum[i]=num[i%num.length];
        }

        int n=cpynum.length;
        int m=pat.length;

        int lps[]=new int[m];

        findlps(lps,pat);

        int i=0;
        int j=0;
        while(i<n){
          
          if(cpynum[i] == pat[j]){
            i++;
            j++;
          }

          if(j ==m){
            return true;
          }
          else if(i<n && cpynum[i] != pat[j]){

            if(j!=0){
              j=lps[j-1];
            }else{
                i++;
            }
          }

        }
        return false;
    }
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int copy[]=new int[n];

        for(int i=0;i<n;i++){
            copy[i]=nums[i];
        }

        Arrays.sort(copy);

        int ans=0;

        for(int k=1;k<=n;k++){

            if(n%k !=0){
                continue;
            }
            

            boolean com=true;

            for(int i=0;i<n;i+=k){

                int end=i+k;

                int pat[]=new int[k];
                int num[]=new int[k];
                int idx=0;
                for(int j=i;j<end;j++){
                    pat[idx]=nums[j];
                    num[idx]=copy[j];
                    idx++;
                }

                if(!useingKMP(num,pat)){
                    com=false;
                    break;
                }
            }

            if(com){
                ans+=k;
            }

        }

        return ans;

    }
}
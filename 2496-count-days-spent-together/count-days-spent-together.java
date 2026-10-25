class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arr[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int prifixsum[]=new int[12];
        prifixsum[0]=31;
        for(int i=1;i<prifixsum.length;i++){
            prifixsum[i]=prifixsum[i-1]+arr[i];
        }

        String alisariv[]=arriveAlice.split("-");
        String alisleav[]=leaveAlice.split("-");

        String bobariv[]=arriveBob.split("-");
        String bobleav[]=leaveBob.split("-");
        
        //alic
        int alicstart=Integer.parseInt(alisariv[0]);
        int alicdate=Integer.parseInt(alisariv[1]);

        int aliclev=Integer.parseInt(alisleav[0]);
        int aliclevdate=Integer.parseInt(alisleav[1]);
        
        //bob
        int bobstart=Integer.parseInt(bobariv[0]);
        int bobdate=Integer.parseInt(bobariv[1]);

        int boblev=Integer.parseInt(bobleav[0]);
        int boblevdate=Integer.parseInt(bobleav[1]);


        int Alicstart=(alicstart==1?0:prifixsum[alicstart-2])+alicdate;
        int Alicend=(aliclev==1?0:prifixsum[aliclev-2])+aliclevdate;

        int Bobstart=(bobstart==1?0:prifixsum[bobstart-2])+bobdate;
        int Bobend=(boblev==1?0:prifixsum[boblev-2])+boblevdate;


        if(Bobend < Alicstart){
            return 0;
        }

        if(Bobstart < Alicstart){
           return Math.min(Bobend,Alicend)-Alicstart+1;
        }

        if(Bobstart > Alicend){
            return 0;
        }

        if(Bobstart <= Alicend && Bobend <=Alicend){
            return Bobend-Bobstart+1;
        }
        
       
        return Alicend-Bobstart+1;


    }
}
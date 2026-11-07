class Solution {
    class free_ser{
        int e;
        int i;

        public free_ser(int e,int i){
            this.e=e;
            this.i=i;
        }
    }

    class busy_ser{
        long time;
        free_ser ser;

        public busy_ser(long time,free_ser ser){
            
            this.time=time;
            this.ser=ser;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<free_ser>free=new PriorityQueue<>((a,b)->{
            if(a.e == b.e) return a.i-b.i;

            return a.e-b.e;
        });

        PriorityQueue<busy_ser>busy=new PriorityQueue<>((a,b)->{
            
            if(a.time == b.time){
               
               if(a.ser.e== b.ser.e){
                 return a.ser.i-b.ser.i;
               }

               return a.ser.e-b.ser.e;
            }

            return Long.compare(a.time,b.time);
        });


        for(int i=0;i<servers.length;i++){

            free.add(new free_ser(servers[i],i));
        }

        int ans[]=new int[tasks.length];

        for(int i=0;i<tasks.length;i++){

            while(!busy.isEmpty() && busy.peek().time <=i){
                busy_ser cur=busy.remove();
                free.add(cur.ser);
            }

            if(!free.isEmpty()){
                free_ser cur=free.remove();
                ans[i]=cur.i;
                busy.add(new busy_ser(i+tasks[i],cur));
            }else{

                if(!busy.isEmpty()){
                      busy_ser cur=busy.remove();
                      ans[i]=cur.ser.i;
                      busy.add(new busy_ser(cur.time+tasks[i],cur.ser));
                }
            }
        }

      return ans;
    }
}
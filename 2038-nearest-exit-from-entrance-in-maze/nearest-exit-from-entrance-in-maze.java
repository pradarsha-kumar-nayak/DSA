class Solution {
    class path{
        int r;
        int c;
        int lev;
        boolean st;

        public path(int r,int c, int lev,boolean st){
            this.r=r;
            this.c=c;
            this.lev=lev;
            this.st=st;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;

        Queue<path>q=new LinkedList<>();

        q.add(new path(entrance[0],entrance[1],0,true));
        maze[entrance[0]][entrance[1]]='+';

        while(!q.isEmpty()){

         
                path cur=q.remove();
                
                if(!cur.st){

                    if((cur.r==0 || cur.r==n-1) || (cur.c==0 || cur.c==m-1)){
                        return cur.lev;
                    }
                }

              

                //top
                if(cur.r >0 && maze[cur.r-1][cur.c] == '.'){
                    maze[cur.r-1][cur.c]='+';
                    q.add(new path(cur.r-1,cur.c,cur.lev+1,false));
                }

                //down
                if(cur.r <n-1 && maze[cur.r+1][cur.c] == '.'){
                    maze[cur.r+1][cur.c]='+';
                    q.add(new path(cur.r+1,cur.c,cur.lev+1,false));
                }

                //left
                if(cur.c >0 && maze[cur.r][cur.c-1] == '.'){
                    maze[cur.r][cur.c-1]='+';
                    q.add(new path(cur.r,cur.c-1,cur.lev+1,false));
                }

                //right
                if(cur.c <m-1 && maze[cur.r][cur.c+1] == '.'){
                    maze[cur.r][cur.c+1]='+';
                    q.add(new path(cur.r,cur.c+1,cur.lev+1,false));
                }

                
        }

        return -1;
    }
}
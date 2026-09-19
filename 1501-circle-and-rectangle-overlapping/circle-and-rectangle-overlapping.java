class Solution {
    public boolean checkOverlap(int radius, int xC, int yC, int x1, int y1, int x2, int y2) {
       int xi=0;
       int yi=0;

       if(x1 > xC){
        xi=x1;
       }else if(x2 < xC){
        xi=x2;
       }else{
        xi=xC;
       }

       if(y1 >yC){
        yi=y1;
       }else if(y2 < yC){
        yi=y2;
       }else{
        yi=yC;
       }
       int dis=(xi-xC)*(xi-xC)+(yi-yC)*(yi-yC);
       
       return dis <= radius * radius;
    }
}
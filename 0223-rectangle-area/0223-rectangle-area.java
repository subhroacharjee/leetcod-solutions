class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1=(D-B)*(C-A);
        int rect2 =(G-E)*(H-F);
        int overlap=0;
        if(overlaps(A,B,C,D,E,F,G,H)){
                int overlapY1=Math.max(F,B);
                int overlapX1=Math.max(E,A);
                int overlapY2=Math.min(H,D);
                int overlapX2=Math.min(G,C);
                overlap=(overlapX2-overlapX1)*(overlapY2-overlapY1);
        }
        return rect1+rect2-overlap;
       
    }
    
    private boolean overlaps(int A, int B, int C, int D, int E, int F, int G, int H){
        if(!(B>H || D<F  || A>G || C<E  )){
            return true;
        }
        return false;
    }
    
}
class Solution {
    public int maxDepth(String s) {
         
        int depth = 0;
        int maxDepth = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth+=1;
                maxDepth = Math.max(maxDepth, depth);
            }else if(s.charAt(i)==')'){
                depth-=1;
            }
        }
         
        return maxDepth;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] tmps) {
        int[] answer = new int[tmps.length];
        Stack<Pair> stack = new Stack<>();
        for (int i =0; i < tmps.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(tmps[i], i));
            } else {
                
                while(!stack.isEmpty() && stack.peek().tmp < tmps[i]) {
                    int tmp = stack.peek().tmp;
                    int index = stack.peek().index;
                    
                    stack.pop();
                    answer[index] = i - index;
                }
                
                stack.push(new Pair(tmps[i], i));
            }
        }
        
        return answer;
    }
}

class Pair {
    public int tmp;
    public int index;
    
    public Pair(int i, int j) {
        tmp = i;
        index = j;
    }
}
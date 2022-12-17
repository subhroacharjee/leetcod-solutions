class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(doOperation(a, b, token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isNumber(String token) {
        if (token.equals("+")) return false;
        else if(token.equals("-")) return false;
        else if(token.equals("*")) return false;
        else if (token.equals("/")) return false;
        
        return true;
    }
    
    private int doOperation(int a, int b, String operand) {
        if (operand.equals("+")) {
            return a + b;
        }
        
        if (operand.equals("-")) {
            return a - b;
        }
            
        if (operand.equals("*")) {
            return a * b;
        }
            
        if (operand.equals("/")) {
            if (b == 0) return 0;
            return a / b;
        }
            
        return 0;
    }
}
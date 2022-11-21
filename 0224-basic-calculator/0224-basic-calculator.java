class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++ ) {
         if (Character.isDigit(s.charAt(i))) {
             int number = 0;
            
             while (i < s.length() && Character.isDigit(s.charAt(i))) {
                  number = number* 10 + (s.charAt(i) - '0');
                 i++;
             }
             res += sign * number;
             i--;
         } else if (s.charAt(i) == '+') {
             sign = 1;
         } else if (s.charAt(i) == '-') {
             sign = -1;
         } else if (s.charAt(i) == '(') {
             stack.push(res);
             stack.push(sign);
             res = 0;
             sign = 1;
         } else if (s.charAt(i) == ')') {
             int sn = stack.pop();
             int x = stack.pop();
             res = x + sn * res;
         } else {
             continue;
         }
          
       }
        System.out.println(stack);
        return res;
    }
}
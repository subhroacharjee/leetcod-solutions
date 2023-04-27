class Solution {
    public String decodeString(String s) {
         System.out.println(s);
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                ans += s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                int k = Integer.valueOf("" + s.charAt(i));
                while(Character.isDigit(s.charAt(++i))) {
                    k = k * 10 + Integer.valueOf("" + s.charAt(i));
                }
                
                int sum = 1;
                
                String substring = "";
                for (int j = i+1; j < s.length(); j++) {
                    
                    if (s.charAt(j) == '[') sum++;
                    else if (s.charAt(j) == ']') sum--;
                    if (sum == 0) {
                        String sub = decodeString(substring);
                        while(k > 0) {
                            ans += sub;
                            k--;
                        }
                        i = j;
                        break;
                    } else {
                        substring += s.charAt(j);
                        
                    }
                }
               
            }
        }
        
        return ans;
    }
}
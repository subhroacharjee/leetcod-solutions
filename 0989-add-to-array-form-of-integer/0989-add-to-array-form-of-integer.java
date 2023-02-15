class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        
        int n = k;
        int lastIdx = num.length - 1;
        while(n > 0 && lastIdx >= 0) {
            int lastBit = n % 10;
            int sum = lastBit + num[lastIdx];
            ans.add(sum % 10);
            int carry  = 0;
            if (sum >= 10) carry = sum / 10;
            
            n = n/10;
            n+=carry;
            lastIdx--;
        }
        
        while( lastIdx >= 0) {
            ans.add(num[lastIdx--]);
        }
        
        while(n > 0) {
            int lastBit = n % 10;
            ans.add(lastBit);
            n = n/10;
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
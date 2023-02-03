class Solution {
    String index(String s, int i) {
        return String.valueOf(s.charAt(i));
    }
    public String convert(String s, int numRows) {
        if (numRows <=1) return s;
        String[] arr = new String[numRows];
        for (int i =0; i<numRows; i++) arr[i] = "";
        int offset = 1, direction = -1;
        
        int n = s.length();
        
        for (int i =0; i<n; i++) {
            offset += direction;
            arr[offset] += index(s,i);
            if (offset == 0) direction = 1;
            else if ((offset) == (numRows-1)) direction = -1;
            
            
        }
        
        String res = "";
        for (int i = 0; i < numRows; i ++) res+= arr[i];
        
        return res;
    }
}
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        getIpAddress(0,0,s);
        return ans;
    }
    
    public boolean checkState(String st) {
        if (st.length() < 1 || st.length() > 3) return false;
        if (st.length() > 1 && st.startsWith("0")) return false;
        try {
            int val = Integer.valueOf(st);
            if (val >= 0 && val <= 255) return true;
            
        } catch (Exception e) {
            // do nothing
        }
        return false;
    }
    
    public boolean isValidState(int noOfDots, String s) {
        if (noOfDots > 3) return false;
         
        String[] arr = s.split("\\.");
        
        
        boolean flag = checkState(arr[noOfDots-1]);
        if (noOfDots == 3) flag = flag && checkState(arr[noOfDots]);
        // System.out.println(s+" "+flag);
        return flag;
    }
    
    public void getIpAddress(int index, int noOfDots, String s) {
        if (s.length() <= index) return;

        String newStr = s.substring(0, index) + "." + s.substring(index);
        if (isValidState(noOfDots + 1, newStr)) {
            if ((noOfDots+1) == 3) {
                ans.add(newStr);
            } else {
                getIpAddress(index+1, noOfDots+1, newStr);
            }
        }
        getIpAddress(index+1, noOfDots, s);
    }
}
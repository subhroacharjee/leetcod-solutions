class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> ends = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        int[] dr = {1,-1};
        if (ends.contains("0000") || ends.contains(target)) return -1;
        Queue<Lock> q = new LinkedList<>();
        
        q.add(new Lock("0000", 0));
        visited.add("0000");
        
        while(!q.isEmpty()) {
            String lock = q.peek().lock;
            int d = q.peek().d;
            q.poll();
            
            if (lock.equals(target)) return d;
            char[] lockDigit = lock.toCharArray();
            
            for (int i = 0; i < 4; i++) {
                
                int original = lockDigit[i] - '0';
                
                for (int j =0; j < 2; j++) {
                    
                    int digit = (original + dr[j]) < 0 ? 9 : (original + dr[j])%10;
                    char nextDigit = (char)(digit + '0');
                    
                    lockDigit[i] =  nextDigit;
                    
                    String s = String.valueOf(lockDigit);
                    
                    if (!visited.contains(s) && !ends.contains(s)) {
                        
                        visited.add(s);
                        q.add(new Lock(s, d+1));
                    }
                    
                }
                
                lockDigit[i] = (char)(original + '0');
            }
        }
        
        return -1;
    }
}

class Lock {
    public String lock;
    public int d;
    public Lock(String lock, int d) {
        this.lock = lock;
        this.d = d;
    }
}
class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        
        int i = 1;
        while( (i * i) <= n){ 
            perfectSquares.add(i*i);
            i++;
        }
        
        int size = perfectSquares.size();
        int[] perfSqs = new int[size];
        
        i = 0;
        for (int num: perfectSquares) {
            perfSqs[i] = num;
            i++;
        }
        
        return sum(perfSqs, n);
        
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    
    int sum(int[] sqs, int target) {
        if (map.containsKey(target)) return map.get(target);
        if (target < 0) return -1;
        if (target == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < sqs.length; j++) {
            int curr = sum(sqs,  target - sqs[j]);
            if (curr == -1) continue;
            
            min = Integer.min(min, curr+1);
        }
        
        map.put(target, min);
        return min;
    }
}
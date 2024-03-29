class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (map.containsKey(n)) return map.get(n);
        
        map.put(n, tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1));
        return map.get(n);
    }
}
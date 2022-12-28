class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < piles.length; i++) {
            pQ.add(piles[i]);
        }
        
        while(!pQ.isEmpty() && k > 0) {
            int top = pQ.poll();
            top = top - (int)Math.floor(top/2);
            pQ.add(top);
            k--;
        }
        
        int sum = 0;
        while(!pQ.isEmpty()) {
            int top = pQ.poll();
            sum += top;
        }
        
        return sum;
    }
}
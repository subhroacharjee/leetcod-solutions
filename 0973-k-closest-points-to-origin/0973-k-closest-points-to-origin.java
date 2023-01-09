class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Holder> pq = new PriorityQueue<>(new Comparator<Holder>() {
            @Override
            public int compare(Holder a, Holder b){
                return a.distance - b.distance;
            }
        });
        
        for (int[] coord : points) {
            pq.add(new Holder(coord));
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().coordinate;
        }
        
        return ans;
    }
}

class Holder {
    public int[] coordinate;
    public int distance;
    
    public Holder(int[] coordinate) {
        distance = (coordinate[0] * coordinate[0]) + (coordinate[1]* coordinate[1]);
        this.coordinate = coordinate;
    }
}
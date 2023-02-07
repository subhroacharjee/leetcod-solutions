class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int Inf = Integer.MAX_VALUE;
        int[] distanceAr = new int[n+1];
        List<Pair>[] adjList = createGraph(n+1);
        Arrays.fill(distanceAr, Inf);
        
        for (int[] edge: times) {
            
            adjList[edge[0]].add(new Pair(edge[1], edge[2]));
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, k));
        
        while(!q.isEmpty()) {
            
            int node = q.peek().y;
            int distance = q.peek().x;
            q.poll();
            if (distanceAr[node] <= distance) continue;
            distanceAr[node] = distance;
            for (Pair adjNode: adjList[node]) {
                int wt = adjNode.y + distance;
                q.add(new Pair(wt, adjNode.x));
            }
        }
        

        
       int max = 0;
        for (int i = 1; i < n+1; i++) {
            max = Math.max(distanceAr[i], max);
        }
        
        return max == Inf? -1: max;
    }
    
    public List<Pair>[] createGraph(int n) {
        List<Pair>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        return adjList;
    }
}

class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "[" + x + " "+ y + "]";
    }
}
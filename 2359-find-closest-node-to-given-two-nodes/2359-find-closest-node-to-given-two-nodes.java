class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int[] distance1 = BFS(edges, node1);
        int[] distance2 = BFS(edges, node2);
        
        int index = -1;
        int min = Integer.MAX_VALUE;
        
        for(int i= 0; i < edges.length; i++) {
            if(distance1[i] == -1 || distance2[i] == -1) continue;
            int max = Math.max(distance1[i], distance2[i]);
            if(max < min) {
                min = max;
                index = i;
            }
        }
        
        return index;
    }
    
    private int[] BFS(int[] edges, int node) {
        int[] path = new int[edges.length];
        Arrays.fill(path, -1);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        int distance = 0;
        queue.add(node);
        hashSet.add(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                path[curr] = distance;
                int next = edges[curr];
                if(next == -1 || hashSet.contains(next)) continue;
                hashSet.add(next);
                queue.add(next);
            }
            distance += 1;
        }
        return path;
    }
}
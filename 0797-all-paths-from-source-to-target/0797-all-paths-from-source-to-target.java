class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int N = graph.length;
        Queue<Stack<Integer>> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        q.add(st);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        while(!q.isEmpty()) {
            Stack<Integer> curr = q.poll();
            int lastNode = curr.peek();
            if (lastNode == N-1) {
                ans.add(new ArrayList<>(curr));
                continue;
            }
            for (int adjNode : graph[curr.peek()]) {
                Stack<Integer> newSt = new Stack<>();
                newSt.addAll(curr);
                newSt.push(adjNode);
                q.add(newSt);
            }
            
            
        }
        
        return ans;
    }
}
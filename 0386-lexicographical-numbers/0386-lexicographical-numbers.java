class Solution {
    int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, answer);
        }
        return answer;
    }
    
    private void dfs(int i, List<Integer> answer) {
        if (i > n) return;
        answer.add(i);
        int base = i * 10;
        dfs(base, answer);
        for (int j = 1; j < 10; j++) {
            dfs(base + j, answer);
        }
    }
}
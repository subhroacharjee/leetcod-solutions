class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, getNoOfSoliders(mat[i])));
        }
        
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.y == b.y) return a.x - b.x;
                return a.y - b.y;
            }
        });
        
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i ++) {
            ans[i] = list.get(i).x;
        }
        
        return ans;
    }
    
    public int getNoOfSoliders(int[] arr) {
        int l = -1; int r = arr.length;
        while(l+1 < r) {
            int m = l + (r - l)/2;
            if (arr[m] == 1) l= m;
            else r = m;
        }
        
        return l+1;
    }
}

class Pair {
    public int x;
    public int y;
    public Pair(int _x, int _y) {
        x = _x;
        y = _y;
    }
}
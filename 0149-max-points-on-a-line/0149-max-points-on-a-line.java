class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 1) return points.length;
        HashMap<String, HashSet<int[]>> map = new HashMap<>();
        
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String key = getLineIdentifier(points[i], points[j]);
                if (!map.containsKey(key)) map.put(key, new HashSet<>());
                map.get(key).add(points[i]);
                map.get(key).add(points[j]);
            }
        }
        
        int largestList = 0;
        
        for (String key: map.keySet()) {
            largestList = Integer.max(largestList, map.get(key).size());
        }
        return largestList;
    }
    
    
    private String getLineIdentifier(int[] p1, int[]p2) {
        int delX = p2[0] - p1[0];
        int delY = p2[1] - p1[1];
        
        if (delX == 0) return "INF_"+p1[0]+"_INF";
        double slope = delY/(double)delX;
        double intercept = p1[1] - slope * p1[0];
        
        return slope + "_" + intercept;
    }
}
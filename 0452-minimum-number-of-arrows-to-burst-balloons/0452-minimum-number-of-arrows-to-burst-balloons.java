class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int n = points.length;
        long end = points[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= end) continue;
            count++;
            end = points[i][1];
        }
        
        return count + 1 ;
    }
}
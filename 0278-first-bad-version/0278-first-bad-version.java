/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 0; long r = n;
        r++;
        
        while(l+1 < r) {
            long mid = (l + (r - l)/2);
            if (!isBadVersion((int)mid)) l = mid;
            else r = mid;
        }
        return (int)r;
    }
}
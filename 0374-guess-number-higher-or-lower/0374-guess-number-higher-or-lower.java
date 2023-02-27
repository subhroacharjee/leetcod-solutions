/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       
        long l = 0, r= (long)n + 1;
        while(l+1 < r) {
            long m = l + (r - l)/2;
            if (guess((int)m) >= 0) l = m;
            else r = m;
        }
        
        return (int)l;
    }

}
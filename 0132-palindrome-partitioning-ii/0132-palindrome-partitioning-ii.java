class Solution {
    
    HashSet<String> set = new HashSet<>();
    public int minCut(String s) {
        int n = s.length();
        
        boolean[][] isValid = new boolean[n][n];
        for(int len=1;len<=n;len++) //length of string
        {
            for(int i=0;i<=n-len;i++) // left
            {
                int j=i+len-1; //right
                if(s.charAt(i)!=s.charAt(j))
                    continue;
                if(j-i<=2) 
                    isValid[i][j] = true;
                else
                    isValid[i][j] = isValid[i+1][j-1];
            }
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp,n);
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<=i;k++)
            {
                if(isValid[k][i])
                {
                    if(k==0)
                    {
                        dp[i] = 0; //best case
                        break;
                    }
                    dp[i] = Math.min(dp[i],dp[k-1]+1);
                }
            }
        }
        return dp[n-1];
    }
    
    
    
}
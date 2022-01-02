class Solution {
    public int longestPalindromeSubseq(String s) {
        /*
        DP: f[i, j] the longest subsequence start with i and end with j
        0 <= i <= j < n
        if si == sj, f[i, j] = f[i+1, j-1] + 2;
        if si != sj, either use start with si, or end with sj, not increasing the max length 
        f[i, j] = max(f[i+1, j], f[i, j-1])
        
        f[i, j] relies on i+1 and j-1, so i should be in descending iteration and j ascending
        
        boundary f[i, i] = 1
        */
        
        int max = 1;
        int n = s.length();
        int[][] f = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
                max = Math.max(max, f[i][j]);
            }
        }
        
        return max;
    }
}
class Solution {
    public int numSquares(int n) {
        // not use i: f[i-1][j]
        // use i: f[i-1][j-i*i] + 1
        
        int[] f = new int[n + 1];
        Arrays.fill(f, 10000);
        f[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                f[j] = Math.min(f[j - i * i] + 1, f[j]);
            }
        }
        
        return f[n];
    }
}
class Solution {
    public int jump(int[] nums) {
        /*
        DP: f(i) the minimum step to reach i
        already at f(i), can go to any pos from i + 1 to i + nums[i], so update
        f(i + j) = min(f(i) + 1, f(i + j))
        */
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 10000);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                f[i + j] = Math.min(f[i + j], f[i] + 1);
            }
        }
        
        return f[n - 1];      
    }
}
class Solution {
    
    int[] fa;
    int m;
    int n;
    
    public int numIslands(char[][] grid) {
        // solution: find number of union sets of 1s
        
        // makeSet
        m = grid.length;
        n = grid[0].length;
        
        fa = new int[m * n];
        for (int i = 0; i < m * n; i++) fa[i] = i;
        
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        
        // iterate the whole grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                for (int k = 0; k < 2; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                    if (grid[ni][nj] == '1') {
                        unionSet(num(i, j), num(ni, nj));
                    }   
                }   
            }
        }
        
        Set<Integer> ans = new HashSet<>();
        // count number of unique roots
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int curRoot = find(num(i, j));
                    if (!ans.contains(curRoot)) {
                        ans.add(curRoot);
                    }
                }         
            }
        }
        
        return ans.size();
    }
    
    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }
    
    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) fa[x] = y;   
    }
    
    private int num(int i, int j) {
        return i * n + j;
    }
}
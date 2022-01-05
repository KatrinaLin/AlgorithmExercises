class Solution {
    int[] fa;
    
    public int[] findRedundantConnection(int[][] edges) {
        // if there is an edge from i - j, then i j is in the same union set
        // if i, j is already in a union set, then this edge is redundant
        // MakeSet
        int n = edges.length; // because there is only 1 additional edge
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;
        
        int[] ans = new int[2];
        
        for (int i = 0; i < n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (find(x) == find(y)) {
                ans[0] = x;
                ans[1] = y;
            } else {
                unionSet(x, y);
            }
        }
        
        return ans;
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
}
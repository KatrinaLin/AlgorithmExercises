class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        if (n == 1) return 1;
        
        boolean[][] startVisited = new boolean[n][n];
        boolean[][] endVisited = new boolean[n][n];
        
        Queue<Pair<Integer, Integer>> startQueue = new LinkedList<>();
        Queue<Pair<Integer, Integer>> endQueue = new LinkedList<>();
        
        startQueue.add(new Pair(0, 0));
        startVisited[0][0] = true;
        int startPath = 1;
        
        endQueue.add(new Pair(n - 1, n - 1));
        endVisited[n - 1][n - 1] = true;
        int endPath = 1;
        
        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            if (expandAndMeet(startQueue, startVisited, endVisited, grid)) return startPath + endPath;
            startPath++;
            
            if (expandAndMeet(endQueue, endVisited, startVisited, grid)) return startPath + endPath;
            endPath++;         
        }
        
        return -1;
    }
    
    private boolean expandAndMeet(Queue<Pair<Integer, Integer>> q, boolean[][] visited, boolean[][] otherVisited, int[][] grid) {
        int n = grid.length;
        int size = q.size();
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
            
        // iterate this level
        for (int k = 0; k < size; k++) {
            Pair<Integer, Integer> pair = q.poll();

            int x = pair.getKey();
            int y = pair.getValue();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // out of bound or visited or not a valid path
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || grid[nx][ny] != 0) continue;

                // if reach a point that has been visited by the other side, then return
                if (otherVisited[nx][ny]) return true;

                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
        
        return false;
    }   
}
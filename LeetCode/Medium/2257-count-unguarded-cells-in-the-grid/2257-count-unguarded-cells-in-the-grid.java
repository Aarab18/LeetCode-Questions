class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = -1;
            
        for (int[] guard : guards)
            grid[guard[0]][guard[1]] = 1;

        int unguardedCells = m * n;
        unguardedCells -= walls.length + guards.length;
        
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            for (int i = y + 1; i < n; i++)
                if (Math.abs(grid[x][i]) == 1)
                    break;
                else if (grid[x][i] == 0) {
                    grid[x][i] = 2;
                    unguardedCells--;
                }

            for (int i = y - 1; i >= 0; i--)
                if (Math.abs(grid[x][i]) == 1)
                    break;
                else if (grid[x][i] == 0) {
                    grid[x][i] = 2;
                    unguardedCells--;
                }

            for (int i = x + 1; i < m; i++)
                if (Math.abs(grid[i][y]) == 1)
                    break;
                else if (grid[i][y] == 0) {
                    grid[i][y] = 2;
                    unguardedCells--;
                }
                
            for (int i = x - 1; i >= 0; i--)
                if (Math.abs(grid[i][y]) == 1)
                    break;
                else if (grid[i][y] == 0) {
                    grid[i][y] = 2;
                    unguardedCells--;
                }
        }

        return unguardedCells;
    }
}
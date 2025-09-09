import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }
        backtrack(solutions, board, n, 0);
        return solutions;
    }
    private void backtrack(List<List<String>> solutions, List<String> board, int n, int row) {
        if (row == n) {
            solutions.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                backtrack(solutions, board, n, row + 1);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
    
    private boolean isSafe(List<String> board, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}

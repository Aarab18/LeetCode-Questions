class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startR = 0, endR = matrix.length - 1, startC = 0, endC = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();
        while (startR <= endR && startC <= endC) {
            for (int j = startC; j <= endC; j++) {
                spiral.add(matrix[startR][j]);
            }
            for (int i = startR + 1; i <= endR; i++) {
                spiral.add(matrix[i][endC]);
            }
            if (startR < endR) {
                for (int j = endC - 1; j >= startC; j--) {
                    spiral.add(matrix[endR][j]);
                }
            }
            if (startC < endC) {
                for (int i = endR - 1; i > startR; i--) {
                    spiral.add(matrix[i][startC]);
                }
            }
            startR++;
            startC++;
            endR--;
            endC--;
        }
        return spiral;
    }
}
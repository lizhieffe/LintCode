package Finished;

public class SetZero {

	/**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstRowZero = true;
                    else
                        matrix[i][0] = 0;
                    if (j == 0)
                        firstColumnZero = true;
                    else
                        matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i)
            if (matrix[i][0] == 0)
                setRowZero(matrix, i);
        for (int j = 1; j < matrix[0].length; ++j)
            if (matrix[0][j] == 0)
                setColumnZero(matrix, j);
        if (firstRowZero)
            setRowZero(matrix, 0);
        if (firstColumnZero)
            setColumnZero(matrix, 0);
    }
    
    private void setRowZero(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; ++j)
            matrix[i][j] = 0;
    }
    
    private void setColumnZero(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; ++i)
            matrix[i][j] = 0;
    }
}

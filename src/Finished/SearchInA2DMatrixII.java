package Finished;

public class SearchInA2DMatrixII {

	/**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int occurance = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return occurance;
        int i = matrix.length - 1;
        int j = 0;
        while (true) {
            if (matrix[i][j] == target)
                ++occurance;
            if (matrix[i][j] > target) {
                if (i > 0)
                    --i;
                else
                    break;
            }
            else {
                if (j < matrix[0].length - 1)
                    ++j;
                else
                    break;
            }
        }
        return occurance;
    }
}

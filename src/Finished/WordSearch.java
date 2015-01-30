package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        if (word == null || word.length() == 0)
            return false;
        if (board.length * board[0].length < word.length())
            return false;
        char[] c = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (exist(board, i, j, c, 0, visited))
                    return true;
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, char[] c, int beg, boolean[][] visited) {
        if (beg == c.length - 1)
            return board[i][j] == c[beg] ? true : false;
        if (board[i][j] != c[beg]) {
            return false;
        }
        visited[i][j] = true;
        boolean result = false;
        if (i > 0 && !visited[i - 1][j])
            result = exist(board, i - 1, j, c, beg + 1, visited);
        if (!result && i < board.length - 1 && !visited[i + 1][j])
            result = exist(board, i + 1, j, c, beg + 1, visited);
        if (!result && j > 0 && !visited[i][j - 1])
            result = exist(board, i, j - 1, c, beg + 1, visited);
        if (!result && j < board[0].length - 1 && !visited[i][j + 1])
            result = exist(board, i, j + 1, c, beg + 1, visited);
        visited[i][j] = false;
        return result;
    }
    
    @Test
    public void tc01() {
    	char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
    	String word = "ABCESEEEFS";
    	assertTrue(new WordSearch().exist(board, word) == true);
    }
}

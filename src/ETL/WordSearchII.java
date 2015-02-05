package ETL;

import java.util.ArrayList;

public class WordSearchII {

	/**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.size() == 0)
            return result;
        Trie trie = new Trie();
        trie.buildTrie(board);
        for (String s : words)
            if (trie.findString(s))
                result.add(s);
        return result;
    }
}

class Trie {
    
    TrieNode root = new TrieNode();
    
    public void buildTrie(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                buildTrie(board, visited, i, j, root);
    }
    
    private void buildTrie(char[][] board, boolean[][] visited, int x, int y, TrieNode node) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        node.addNode(board[x][y]);
        TrieNode curr = node.getNode(board[x][y]);
        if (x > 0 && !visited[x - 1][y])
            buildTrie(board, visited, x - 1, y, curr);
        if (x < board.length - 1 && !visited[x + 1][y])
            buildTrie(board, visited, x + 1, y, curr);
        if (y > 0 && !visited[x][y - 1])
            buildTrie(board, visited, x, y - 1, curr);
        if (y < board[0].length - 1 && !visited[x][y + 1])
            buildTrie(board, visited, x, y + 1, curr);
        visited[x][y] = false;
        return;
    }
    
    public boolean findString(String s) {
        if (s == null)
            return false;
        char[] c = s.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < c.length; ++i) {
            if (curr.getNode(c[i]) == null)
                return false;
            else
                curr = curr.getNode(c[i]);
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    public void addNode(char c) {
        if (children[c - 'a'] == null)
            children[c - 'a'] = new TrieNode();
    }
    public TrieNode getNode(char c) {
        return children[c - 'a'];
    }
}


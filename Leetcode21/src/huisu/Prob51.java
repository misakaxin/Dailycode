package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author misakaxin
 */
public class Prob51 {
    static List<List<String>> res =new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] i : board){
            Arrays.fill(i,'.');
        }
        backtrack(board,0);
        return res;
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length){
            res.add(array2List(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col< n; col++) {
            if (!isValid(board,row,col)){
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board,row+1);
            board[row][col] = '.';
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    private static List<String> array2List(char[][] board) {
            List<String> res = new LinkedList<>();
            for (char[] i : board){
                StringBuilder sb = new StringBuilder();
                for (char j : i){
                    sb.append(j);
                }
                res.add(sb.toString());
            }
            return res;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}

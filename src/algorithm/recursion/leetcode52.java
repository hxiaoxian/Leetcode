package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/5/1
 * Time: 22:11
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode52 {
    //利用51题的解法，直接返回size
    class Solution {
        public int totalNQueens(int n) {
            List<List<String>> list = solveNQueens(n);
            return list.size();
        }

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> list = new ArrayList<>();
            helper(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new String[n], list);
            return list;
        }

        private void helper(int x, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<List<String>> list) {
            if (x == board.length) {
                list.add(Arrays.asList(board.clone()));
            } else {
                for (int y = 0; y < board.length; y++) {
                    int id1 = x + y, id2 = x - y + board.length - 1;
                    if (!cols[y] && !d1[id1] && !d2[id2]) {
                        char[] row = new char[board.length];
                        Arrays.fill(row, '.');
                        row[y] = 'Q';
                        board[x] = new String(row);
                        cols[y] = true;
                        d1[id1] = true;
                        d2[id2] = true;
                        helper(x + 1, cols, d1, d2, board, list);
                        cols[y] = false;
                        d1[id1] = false;
                        d2[id2] = false;
                    }
                }
            }
        }

    }
}

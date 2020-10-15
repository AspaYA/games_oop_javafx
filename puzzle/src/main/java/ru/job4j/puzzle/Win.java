package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return isWin(board);
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean rst = true;
        for (int el: board[row]) {
            if (el != 1) {
                rst = false;
                break;
            }
        }
        return rst;
    }

    public static boolean monoVertical(int[][] board, int column) {
        boolean rst = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                rst = false;
                break;
            }
        }
        return rst;
    }


    public static boolean isWin(int[][] board) {
        boolean rst = false;
        for (int i = 0; i < board.length; i++) {
            if (monoHorizontal(board, i) || monoVertical(board, i)) {
                rst = true;
                break;
            }
        }
        return rst;
    }

}

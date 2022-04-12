package hu.aestallon.problems;

import java.util.Arrays;

/**
 * <b>289. Game of Life</b>
 *
 * <p>According to Wikipedia's article: "The <b>Game of Life</b>,
 * also known simply as <b>Life</b>, is a cellular automaton devised
 * by the British mathematician John Horton Conway in 1970."
 *
 * <p>The board is made up of an {@code m x n} grid of cells, where
 * each cell has an initial state: <b>live</b> (represented by a
 * {@code 1}) or <b>dead</b> (represented by a {@code 0}). Each cell
 * interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia
 * article):
 * <ol>
 * <li>Any live cell with fewer than two live neighbors dies as if
 * caused by under-population.
 * <li>Any live cell with two or three live neighbors lives on to
 * the next generation.
 * <li>Any live cell with more than three live neighbors dies, as
 * if by over-population.
 * <li>Any dead cell with exactly three live neighbors becomes a live
 * cell, as if by reproduction.
 * </ol>
 *
 * <p>The next state is created by applying the above rules
 * simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously. Given the current state of the
 * {@code m x n} grid {@code board}, return <i>the next state</i>.
 *
 * <p>Status: <b>ACCEPTED</b>
 * <ul>
 * <li>Speed: <i>0 ms -</i> beats 100.0 % of java submissions.
 * <li>Memory: <i>42 MB -</i> beats 69.86 % of java submissions.
 * </ul>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @since 17.0.2
 */
public class GameOfLife {

    /**
     * Progresses the <i>Game of Life</i> to its next state.
     *
     * @param board an {@code int[][]} board filled with 0s and 1s.
     */
    public void gameOfLife(int[][] board) {
        boolean[][] changes = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int liveNeighbours = getLiveNeighbours(board, r, c);
                if ((board[r][c] == 1 && (liveNeighbours < 2 || liveNeighbours > 3)) ||
                        (board[r][c] == 0 && liveNeighbours == 3)) {
                    changes[r][c] = true;
                }
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int x = 0; x < board[0].length; x++) {
                if (changes[r][x]) board[r][x] = intFlip(board[r][x]);
            }
        }
    }

    /**
     * Counts the live
     * <a href="https://en.wikipedia.org/wiki/Moore_neighborhood">Moore-neighbours</a>
     * of a cell in a <i>Game of Life</i> board.
     *
     * @param board an {@code int[][]} board filled with 0s and 1s.
     * @param r     the {@code int} row of a given cell.
     * @param c     the {@code int} column of a given cell.
     * @return the sum of the live Moore-neighbours of a given cell (0 ... 8).
     */
    private int getLiveNeighbours(int[][] board, int r, int c) {
        final int[] dirs = {-1, 0, 1};
        int sum = -board[r][c];
        for (int dirR : dirs) {
            for (int dirC : dirs) {
                if ((c + dirC >= 0) && (c + dirC < board[0].length)
                        && (r + dirR >= 0) && (r + dirR < board.length)) {
                    sum += board[r + dirR][c + dirC];
                }
            }
        }
        return sum;
    }

    /**
     * Negates an {@code int} based on value-set {@code {0, 1}}.
     *
     * @param i 0 or 1.
     * @return the not-i value from the value-set {@code {0, 1}}.
     */
    private int intFlip(int i) {
        return (i == 0) ? 1 : 0;
    }

    // Driver method for testing
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        GameOfLife life = new GameOfLife();
        life.gameOfLife(board);
    }

    /** Prints an {@code int[][]} board to standard output */
    private static void printBoard(int[][] board) {
        for (int[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    /** Prints a {@code boolean[][]} board to standard output */
    private static void printBoard(boolean[][] board) {
        for (boolean[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }
}

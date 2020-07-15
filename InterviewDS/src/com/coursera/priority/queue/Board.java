package com.coursera.priority.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    // private instance fields
    private int[][] tiles;
    private final int n;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.n = tiles[0].length;
        this.tiles = new int[n][n];
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                this.tiles[row][col] = tiles[row][col];
            }
        }
    }

    private int fetchGoalBoardValues(int row, int col) {
        if (row == this.n - 1 && col == this.n - 1) return 0;
        else return (row) * this.n + col + 1;
    }

    private int fetchGoalRow(int value) {
        if (value % this.n == 0) {
            return value / this.n - 1;
        } else {
            return value / this.n;
        }
    }

    private int fetchGoalCol(int value) {
        return value % this.n == 0 ? this.n - 1 : value % this.n - 1;
    }

    private int[][] copy(int[][] blocks) {
        int[][] copy = new int[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                copy[i][j] = blocks[i][j];
            }
        }
        return copy;
    }

    private int[][] swap(int i1, int j1, int i2, int j2) {
        int[][] copy = copy(tiles);
        int temp = copy[i1][j1];
        copy[i1][j1] = copy[i2][j2];
        copy[i2][j2] = temp;
        return copy;
    }

    private Board exchange(int row, int col, String pos) {
        Board neighbor = null;

        if (pos.equalsIgnoreCase("top")) {
            if ((0 <= row - 1 && row - 1 < this.n) && (0 <= col && col < this.n)) {
                neighbor = new Board(this.tiles);
                int tmp = this.tiles[row - 1][col];
                neighbor.tiles[row][col] = tmp;
                neighbor.tiles[row - 1][col] = 0;
            }
        } else if (pos.equalsIgnoreCase("bottom")) {
            if ((0 <= row + 1 && row + 1 < this.n) && (0 <= col && col < this.n)) {
                neighbor = new Board(this.tiles);
                int tmp = this.tiles[row + 1][col];
                neighbor.tiles[row][col] = tmp;
                neighbor.tiles[row + 1][col] = 0;
            }
        } else if (pos.equalsIgnoreCase("left")) {
            if ((0 <= row && row < this.n) && (0 <= col - 1 && col - 1 < this.n)) {
                neighbor = new Board(this.tiles);
                int tmp = this.tiles[row][col - 1];
                neighbor.tiles[row][col] = tmp;
                neighbor.tiles[row][col - 1] = 0;
            }
        } else {
            if ((0 <= row && row < this.n) && (0 <= col + 1 && col + 1 < this.n)) {
                neighbor = new Board(this.tiles);
                int tmp = this.tiles[row][col + 1];
                neighbor.tiles[row][col] = tmp;
                neighbor.tiles[row][col + 1] = 0;
            }
        }
        return neighbor;

    }

    // string representation of this board
    public String toString() {
        String result = this.n + "\n";
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                result += this.tiles[row][col] + " ";
            }
            result += "\n";
        }
        return result;
    }

    // board dimension n
    public int dimension() {
        return this.n;
    }

    // number of tiles out of place
    public int hamming() {
        int count = 0;
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                if (this.tiles[row][col] != fetchGoalBoardValues(row, col) && !(this.tiles[row][col] == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int runningSum = 0;
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                if (!(this.tiles[row][col] == 0)) {
                    int fRow = fetchGoalRow(this.tiles[row][col]);
                    int fCol = fetchGoalCol(this.tiles[row][col]);
                    // if (!(row == (this.n - 1) && col == (this.n - 2))) {
                    // System.out.println(Math.abs(fRow - row) + Math.abs(fCol - col));
                    runningSum += Math.abs(fRow - row) + Math.abs(fCol - col);
                }
            }
        }
        return runningSum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        // if (!Arrays.equals(this.tiles, that.tiles)) return false;
        // return true;
        return this.toString().equals(that.toString());
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighborList = new ArrayList<>();
        int zRow = 0;
        int zCol = 0;
        for (int row = 0; row < this.n; row++) {
            for (int col = 0; col < this.n; col++) {
                if (this.tiles[row][col] == 0) {
                    zRow = row;
                    zCol = col;
                    // System.out.println(zRow+"-"+zCol);
                    // break;
                }
            }
        }
        if (exchange(zRow, zCol, "top") != null) neighborList.add(exchange(zRow, zCol, "top"));
        if (exchange(zRow, zCol, "bottom") != null) neighborList.add(exchange(zRow, zCol, "bottom"));
        if (exchange(zRow, zCol, "left") != null) neighborList.add(exchange(zRow, zCol, "left"));
        if (exchange(zRow, zCol, "right") != null) neighborList.add(exchange(zRow, zCol, "right"));
        return neighborList;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] twinTiles = copy(this.tiles);

        if (twinTiles[0][0] != 0 && twinTiles[0][1] != 0)
            return new Board(swap(0, 0, 0, 1));
        else
            return new Board(swap(1, 0, 1, 1));
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        // int[][] input = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        int[][] target1 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        int[][] target2 = {{8, 1, 2}, {4, 0, 3}, {7, 6, 5}};
        // int[][] input1 = {{1, 0, 3}, {4, 2, 5}, {7, 8, 6}};
        // int[][] input2 = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        int n = 10;
        int[][] input = new int[n][n];
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++)
                if (r == n - 1 && c == n - 1) input[r][c] = 0;
                else input[r][c] = (r) * n + (c + 1);
        }
        Board b = new Board(input);
        System.out.println(b.toString());
        System.out.println("dimension: " + b.dimension());
        System.out.println("hamming: " + b.hamming());
        System.out.println("manhattan: " + b.manhattan());
        System.out.println("goal: " + b.isGoal());
        System.out.println("equals: " + b.equals(new Board(target1)) + "-" + b.equals(new Board(target2)));
        System.out.println("neighbors:");
        b.neighbors().forEach(r -> System.out.println(r.toString()));
        System.out.println("twins:");
        System.out.println(b.twin().toString());
    }
}

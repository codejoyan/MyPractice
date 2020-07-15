package com.coursera.priority.queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Deque;
import java.util.ArrayDeque;


public class Solver {

    private final class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final int moves;
        private final SearchNode prevNode;
        private final int priority;

        public SearchNode(Board board, int moves, SearchNode prevNode) {
            this.board = board;
            this.moves = moves;
            this.prevNode = prevNode;
            this.priority = this.board.manhattan() + this.moves;
        }

        @Override
        public int compareTo(SearchNode target) {
            int srcPriority = this.priority;
            int tgtPriority = target.priority;
            // return srcPriority.compareTo(tgtPriority);
            return srcPriority - tgtPriority;
        }
    }

    // private SearchNode searchNode;
    private MinPQ<SearchNode> minPQ;
    private MinPQ<SearchNode> twinPQ;
    private boolean solvable;
    private SearchNode goalNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException("Null Board passed");
        // this.searchNode = new SearchNode(initial, 0, null);
        this.minPQ = new MinPQ<>();
        this.twinPQ = new MinPQ<>();
        minPQ.insert(new SearchNode(initial, 0, null));
        twinPQ.insert(new SearchNode(initial.twin(), 0, null));
        compute();
    }


    private void compute() {
        SearchNode node = minPQ.delMin();
        SearchNode twinNode = twinPQ.delMin();
        while (!node.board.isGoal() && !twinNode.board.isGoal()) {
            for (Board b : node.board.neighbors()) {
                if (node.prevNode == null || !b.equals(node.prevNode.board)) {
                    SearchNode s = new SearchNode(b, node.moves + 1, node);
                    minPQ.insert(s);
                }
            }

            for (Board b : twinNode.board.neighbors()) {
                if (twinNode.prevNode == null || !b.equals(twinNode.prevNode.board)) {
                    SearchNode s1 = new SearchNode(b, twinNode.moves + 1, twinNode);
                    twinPQ.insert(s1);
                }
            }
            node = minPQ.delMin();
            twinNode = twinPQ.delMin();
        }

        if (!node.board.isGoal() && twinNode.board.isGoal()) {
            this.solvable = false;
        } else {
            this.solvable = true;
            this.goalNode = node;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return this.solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        // return this.countMoves;
        if (this.isSolvable()) {
            return this.goalNode.moves;
        } else {
            return -1;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        // Stack<Board> s = new Stack<>();
        Deque<Board> s = new ArrayDeque<Board>();
        if (this.isSolvable()) {
            for (SearchNode e = this.goalNode; e != null; e = e.prevNode) {
                s.push(e.board);
            }
        } else {
            return null;
        }
        minPQ = null;
        twinPQ = null;
        return s;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);
/*        int[][] tiles = {{5, 1, 3, 4}, {9, 2, 7, 8}, {13, 0, 10, 12}, {14, 6, 11, 15}};
        Board initial = new Board(tiles); */

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}

package com.coursera.dynamic.connectivity;

//import edu.princeton.cs.algs4.WeightedQuickUnionUF1;

public class Percolation {

    private int n;
    private boolean[][] openBlockedGrid;
    private WeightedQuickUnionUF1 origSitesGrid;
    private WeightedQuickUnionUF1 origAndVirtualSitesGrid;

    public WeightedQuickUnionUF1 getOrigSitesGrid() {
        return origSitesGrid;
    }

    public WeightedQuickUnionUF1 getOrigAndVirtualSitesGrid() {
        return origAndVirtualSitesGrid;
    }

    private boolean checkBounds(int row, int col) {
        if (row >= 1 && row <= n && col >= 1 && col <= n) {
            return true;
        } else {
            return false;
        }
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be > 0");
        }
        this.n = n;
        this.openBlockedGrid = new boolean[n][n];
        this.origSitesGrid = new WeightedQuickUnionUF1(n*n);
        this.origAndVirtualSitesGrid = new WeightedQuickUnionUF1(n*n+2);

        for (int i=1; i<=n; i++) { origAndVirtualSitesGrid.union(0, i); };
        for (int i=(n-1)*n+1; i<=n*n; i++) { origAndVirtualSitesGrid.union(i, n*n+1); };

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException("Row and Columns not within limits");
        }
        int index = (row-1)*n+col-1;
        if (!isOpen(row, col) && checkBounds(row, col)) {
            openBlockedGrid[row-1][col-1] = true;
            if (checkBounds(row - 1, col) && isOpen(row - 1, col)) {
                origSitesGrid.union(index, (row-2)*n + col-1);
                origAndVirtualSitesGrid.union(index+1, (row-2)*n + col-1+1);
            }
            if (checkBounds(row + 1, col) && isOpen(row + 1, col)) {
                origSitesGrid.union(index, row*n + col-1);
                origAndVirtualSitesGrid.union(index+1, row*n + col-1+1);
            }
            if (checkBounds(row, col +1) && isOpen(row, col + 1)) {
                origSitesGrid.union(index, (row-1)*n + col+1-1);
                origAndVirtualSitesGrid.union(index+1, (row-1)*n + col+1-1+1);
            }
            if (checkBounds(row, col-1) && isOpen(row, col - 1)) {
                origSitesGrid.union(index, (row-1)*n + col-1-1);
                origAndVirtualSitesGrid.union(index+1, (row-1)*n + col-1-1+1);
            }
        }
    }

    // is the site (row, col) open?
/*    public boolean isOpen(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException("Row and Columns not within limits");
        }
        int index = (row-1)*n+col-1;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        if (checkBounds(row, col)) {
            flag1 = checkBounds(row - 1, col) == true ? (origSitesGrid.find(index) == origSitesGrid.find((row-2)*n + col-1)) : false;
            flag2 = checkBounds(row + 1, col) == true ? (origSitesGrid.find(index) == origSitesGrid.find(row*n + col-1)) : false;
            flag3 = checkBounds(row , col + 1) == true ? (origSitesGrid.find(index) == origSitesGrid.find((row-1)*n + col+1-1)) : false;
            flag4 = checkBounds(row , col-1) == true ? (origSitesGrid.find(index) == origSitesGrid.find((row-1)*n + col-1-1)) : false;
            // System.out.println(flag1);
            // System.out.println(flag2);
            // System.out.println(flag3);
            // System.out.println(flag4);
        }

        return flag1 || flag2 || flag3 || flag4;
    }*/

    public boolean isOpen(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException("Row and Columns not within limits");
        }
        return openBlockedGrid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = (row-1)*n+col;
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException("Row and Columns not within limits");
        }

        if (isOpen(row, col) && row > 1) {
            return origAndVirtualSitesGrid.find(index) == origAndVirtualSitesGrid.find(0);
        } else if (isOpen(row, col) && row == 1) {
            return true;
        } else {
            return false;
        }

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (isOpen(r, c)) {
                    // System.out.println("r:"+r+"::c:"+c);
                    count++;
                }
            }
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return origAndVirtualSitesGrid.find(n*n+1) == origAndVirtualSitesGrid.find(0);
    }

    // test client (optional)
    public static void main(String[] args) {
        // Test Case 1:
        Percolation p1 = new Percolation(10);
        //System.out.println(p.isFull(2, 1));
        //System.out.println(p.isOpen(2, 1));
        System.out.println(p1.isOpen(10, 3));
        p1.open(5,6);
        p1.open(10,3);
        System.out.println(p1.isOpen(10, 3));

        // Test Case 2:
        Percolation p3 = new Percolation(10);
        System.out.println(p3.isFull(1,1));
        System.out.println(p3.isOpen(1,1));

        // Test Case 3:

        Percolation p2 = new Percolation(5);
        p2.open(1, 1);
        p2.open(1, 2);
        p2.open(1, 4);
        p2.open(2, 4);
        p2.open(3, 4);
        p2.open(3, 5);
        p2.open(4, 1);
        p2.open(5, 1);
        p2.open(5, 2);
        p2.open(5, 4);
        p2.open(5, 5);
        p2.open(4, 5);
        /*p.getOrigSitesGrid().union(0, 1);
        p.getOrigSitesGrid().union(3, 8);
        p.getOrigSitesGrid().union(8,13);
        p.getOrigSitesGrid().union(13, 14);
        p.getOrigSitesGrid().union(15, 20);
        p.getOrigSitesGrid().union(20, 21);
        p.getOrigSitesGrid().union(14, 19);
        p.getOrigSitesGrid().union(19, 24);
        p.getOrigSitesGrid().union(23, 24);

        p.getOrigAndVirtualSitesGrid().union(1, 2);
        p.getOrigAndVirtualSitesGrid().union(4, 9);
        p.getOrigAndVirtualSitesGrid().union(9,14);
        p.getOrigAndVirtualSitesGrid().union(14, 15);
        p.getOrigAndVirtualSitesGrid().union(16, 21);
        p.getOrigAndVirtualSitesGrid().union(21, 22);
        p.getOrigAndVirtualSitesGrid().union(15, 20);
        p.getOrigAndVirtualSitesGrid().union(20, 25);
        p.getOrigAndVirtualSitesGrid().union(24, 25);
        System.out.println("------");
        System.out.println(p.isOpen(0,1));
        System.out.println("------");
        System.out.println(p.numberOfOpenSites());
        System.out.println("------");*/

       /*  for (int i=0; i < p.getOrigSitesGrid().getParent().length; i++) {
            System.out.println(p.getOrigSitesGrid().getParent()[i]);
        }

      for (int i=0; i < p.getOrigAndVirtualSitesGrid().getParent().length; i++) {
            System.out.println(p.getOrigAndVirtualSitesGrid().getParent()[i]);
        } */
        System.out.println("------");
        System.out.println(p2.isFull(2,4));
        System.out.println(p2.percolates());
    }
}

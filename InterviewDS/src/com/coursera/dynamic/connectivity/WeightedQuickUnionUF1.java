package com.coursera.dynamic.connectivity;

public class WeightedQuickUnionUF1 {

    private int[] parent;
    private int[] sz;

    public int[] getParent() {
        return parent;
    }

    private void validate(int p) {
        int n = parent.length;
        if (0 > p || p > n) {
            throw new IllegalArgumentException("Row and Column outside limits");
        }
    }

    public int find (int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }
    }

    public WeightedQuickUnionUF1(int n) {
        parent = new int[n];
        sz = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }
}

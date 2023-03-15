package com.grajber.algorithms.matrice;

public class Matrices {

    private Matrices() {
    }

    public static void matrixMultiply(int[][] a, int[][] b, int[][] c, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
    }

    /**
     * Assuming that size is an exact power of 2.
     */
    public static int[][] matrixMultiplyRecursive(int[][] a, int[][] b, Coords coordsA, Coords coordsB, int size) {

        int[][] c = new int[size][size];

        if (size == 1) {
            c[0][0] = a[coordsA.row][coordsA.col] * b[coordsB.row][coordsB.col];
            return c;

        } else {

            int half = size / 2;

            add(
                    matrixMultiplyRecursive(a, b, coordsA, coordsB, half),
                    matrixMultiplyRecursive(a, b, coordsA.incCol(half), coordsB.incRow(half), half),
                    c, new Coords(0, 0)
            );

            add(
                    matrixMultiplyRecursive(a, b, coordsA, coordsB.incCol(half), half),
                    matrixMultiplyRecursive(a, b, coordsA.incCol(half), coordsB.inc(half), half),
                    c, new Coords(0, half)
            );

            add(
                    matrixMultiplyRecursive(a, b, coordsA.incRow(half), coordsB, half),
                    matrixMultiplyRecursive(a, b, coordsA.inc(half), coordsB.incRow(half), half),
                    c, new Coords(half, 0)
            );

            add(
                    matrixMultiplyRecursive(a, b, coordsA.incRow(half), coordsB.incCol(half), half),
                    matrixMultiplyRecursive(a, b, coordsA.inc(half), coordsB.inc(half), half),
                    c, new Coords(half, half)
            );

        }

        return c;
    }

    private static void add(int[][] a, int[][] b, int[][] c, Coords coordsC) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[coordsC.row + i][coordsC.col + j] = a[i][j] + b[i][j];
    }

    public record Coords(int row, int col) {
        public Coords incRow(int i) {
            return new Coords(row + i, col);
        }

        public Coords incCol(int i) {
            return new Coords(row, col + i);
        }

        public Coords inc(int i) {
            return new Coords(row + i, col + i);
        }
    }

}

package com.grajber.algorithms.matrice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.grajber.algorithms.matrice.Matrices.*;
import static org.junit.jupiter.api.Assertions.*;

class MatricesTest {

    @Test
    void matrixMultiply() {

        // GIVEN
        int[][] a = {{1, 5, 7}, {7, 2, 7}, {7, 89, 1}};
        int[][] b = {{7, 2, 8}, {9, 0, 23}, {6, 4, 1}};
        int[][] c = new int[3][3];
        int[][] expectedArray = {{94, 30, 130}, {109, 42, 109}, {856, 18, 2104}};

        // WHEN
        Matrices.matrixMultiply(a, b, c, 3);

        // THEN
        Assertions.assertArrayEquals(expectedArray, c);
    }

    @Test
    void matrixMultiplyRecursive() {

        // GIVEN
        int[][] a = {{1, 5, 7, 2}, {7, 2, 7, 10}, {7, 89, 1, 0}, {6, 9, 4, 1}};
        int[][] b = {{7, 2, 8, 7}, {9, 0, 23, 3}, {6, 4, 1, 78}, {8, 3, 9, 4}};
        int[][] expectedArray = {{110, 36, 148, 576}, {189, 72, 199, 641}, {856, 18, 2104, 394}, {155, 31, 268, 385}};

        // WHEN
        int[][] c = Matrices.matrixMultiplyRecursive(a, b, new Coords(0, 0), new Coords(0, 0), 4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        // THEN
        Assertions.assertArrayEquals(expectedArray, c);

    }
}
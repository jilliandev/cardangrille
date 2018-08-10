package com.company;


public class Transpose {
	public int[][] transpose(int[][] matrix) {
		int i, j, n = 32;

		int[][] middleware = new int[n][n];

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				middleware[i][j] = matrix[n - j - 1][i];
			}
		}

		return middleware;
	}
}

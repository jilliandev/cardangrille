package com.company;


public class Encryption {
	public String[][] encryption(String text, int[][] cardanGrille) {

		int l = 0, n = 32;

		String[][] matrix = new String[n][n];

		String[] arr = text.split("(?<=\\G.{1})");

		String text2 = "qwertyuiopasdfghjklzxcvbnm[];',./";

		String[] alphabet = text2.split("(?<=\\G.{1})");

		Transpose transpose = new Transpose();

		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (cardanGrille[i][j] == 1) {
						matrix[i][j] = arr[l];
						l++;
					} else if (matrix[i][j] == null) {
						int number = (int) (Math.random() * text2.length());
						matrix[i][j] = alphabet[number];
					}
				}
			}
			cardanGrille = transpose.transpose(cardanGrille);
		}
		return matrix;
	}
}

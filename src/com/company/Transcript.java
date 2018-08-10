package com.company;


public class Transcript {
	public void transcript(String[][] matrix, int[][] Cardanogrille) {
		int l = 0;
		String[] text = new String[160];
		String arr;
		Transpose trans = new Transpose();

		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (Cardanogrille[i][j] == 1) {
						text[l] = matrix[i][j];
						l++;
					}
				}
			}
			Cardanogrille = trans.transpose(Cardanogrille);
		}

		arr = "";

		for (int i = 0; i < text.length; i++) {

			if (text[i] == null) {
			} else {
				arr += (text[i]);
			}
		}

		System.out.println("\nDecrypted message: \n" + arr);
	}

}

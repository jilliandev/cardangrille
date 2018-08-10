package com.company;


public class GrilleBuild {
	public boolean check(int[][] mat1, int[][] mat2) {
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				if (mat1[i][j] == mat2[i][j] && mat1[i][j] == 1) {
					return false;
				} else if (mat1[i][j] == 0 && mat2[i][j] == 1) {
					mat1[i][j] = 1;
				}
			}
		}
		return true;
	}

	public int[][] randomize(int n) {
		int[][] cardanGrille = new int[32][32];

		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 31);

			int y = (int) (Math.random() * 31);

			cardanGrille[x][y] = 1;
		}

		return cardanGrille;
	}

	public int[][] grilleBuild(String text) {
		int n = 32;
		String arr = "";
		int[][] cardanGrille;

		int n2 = (int) Math.ceil(text.length() / 4);

		System.out.println("\n\nThe number of grille openings: " + n2 + "\n");

		Transpose transpose = new Transpose();
		GrilleBuild random = new GrilleBuild();

		int[][] copyOfCardanGrille;
		int[][] ab1;
		int[][] ab2;
		int[][] ab3;

		while (true) {
			cardanGrille = random.randomize(n2);

			copyOfCardanGrille = cardanGrille;

			ab1 = transpose.transpose(cardanGrille);

			ab2 = transpose.transpose(ab1);

			ab3 = transpose.transpose(ab2);

			if (random.check(copyOfCardanGrille, ab1) &&
					random.check(copyOfCardanGrille, ab2) &&
					random.check(copyOfCardanGrille, ab3)) {
				break;
			}
		}

		int[][] result = transpose.transpose(ab3);

		//Conclusion of a grille
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr += result[i][j] + " ";
			}
			arr += "\n";
		}

		System.out.println("\nCardan grille: \n" + arr);

		return result;

	}

}

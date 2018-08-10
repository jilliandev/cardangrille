package com.company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		{
			System.out.println("Enter the text you want to encrypt:");

			Scanner scan = new Scanner(System.in, "CP1251");
			String text = scan.nextLine();

			String arr = "";
			text = text.replace(" ", "");

			//Message check block
			//--------------------------------------------------------------------------------------------
			if (text.length() < 4 || text.length() > 160) {
				System.out.println("The message length must be within the range of from 4 to 160 characters!");
				return;
			}

			System.out.print("\nRemove all spaces from message.\n\nMessage length (without spaces): " + text.length() + " characters.");
			if (text.length() % 4 != 0) {
				System.out.print("Number of characters is not a multiple of four! We supplement the text characters: \"-\"!");
			}

			while (text.length() % 4 != 0) {
				text += "-";
			}
			//--------------------------------------------------------------------------------------------

			String[][] matrix;

			GrilleBuild grilleBuild = new GrilleBuild();

			int[][] cardanGrille = grilleBuild.grilleBuild(text);

			Encryption object = new Encryption();

			matrix = object.encryption(text, cardanGrille);

			//Conclusion of an encrypted message
			//--------------------------------------------------------------------------------------------
			for (int i = 0; i < matrix.length; i++) {

				for (int j = 0; j < matrix.length; j++) {
					arr += matrix[i][j] + " ";
				}

				arr += "\n";

			}
			System.out.println("\nEncrypted message: \n" + arr);
			//--------------------------------------------------------------------------------------------

			Transcript obj = new Transcript();

			obj.transcript(matrix, cardanGrille);
		}
	}
}

import java.util.Scanner;
import java.util.Arrays;

public class tictactoe {
	// -1 = empty
	//  0= player 1
	//  1= player 2
	static int[] A = new int[4];
	static int[] B = new int[4];
	static int[] C = new int[4];
	static Scanner sc = new Scanner(System.in);

	public static void emptyboard() {
		for (int i = 1; i <= 3; i++) {
			A[i] = -1;
			B[i] = -1;
			C[i] = -1;
		}

	}

	public static void main(String[] args) {
		System.out.println(" Welcome to TicTacToe game!!!");
		emptyboard();
		showboard();
		char row;
		int colum;
		for (int i = 1; i <= 9; i++) {
			System.out.println("***Player 1 turn***");
			do {
				System.out.println("Please enter your row: ");
				row = sc.next().charAt(0);
				System.out.println("Please enter your colum: ");
				colum = sc.nextInt();
				if (!validplay(row, colum))
					System.out.println("That is not a valid play.");
			} while (!validplay(row, colum));
			getmove(row, colum, 0);
			showboard();
			if (isgamewon()) {
				System.out.println("***Player 1 Win!!");
				break;
			}
			if (i < 9) {
				System.out.println("***Player 2 turn***");
				do {
					System.out.println("Please enter your row: ");
					row = sc.next().charAt(0);
					System.out.println("Please enter your colum: ");
					colum = sc.nextInt();
					if (!validplay(row, colum))
						System.out.println("That is not a valid play.");
				} while (!validplay(row, colum));
				getmove(row, colum, 1);
				showboard();
				if (isgamewon()) {
					System.out.println("***Player 2 Win!!");
					break;
				}
				i++;
			}
		}
		System.out.println("****Thank you for playing****");
	}

	public static void getmove(char x, int y, int player) {
		char z = Character.toUpperCase(x);
		switch (z) {
		case 'A':
			switch (y) {
			case 1:
				A[1] = player;
				break;
			case 2:
				A[2] = player;
				break;
			case 3:
				A[3] = player;
				break;
			}
			break;
		case 'B':
			switch (y) {
			case 1:
				B[1] = player;
				break;
			case 2:
				B[2] = player;
				break;
			case 3:
				B[3] = player;
				break;
			}
			break;
		case 'C':
			switch (y) {
			case 1:
				C[1] = player;
				break;
			case 2:
				C[2] = player;
				break;
			case 3:
				C[3] = player;
				break;
			}
			break;
		}
	}

	public static boolean validplay(char x, int y) {
		char z = Character.toUpperCase(x);
		switch (z) {
		case 'A':
			switch (y) {
			case 1:
				if (A[1] == -1)
					return true;
				break;
			case 2:
				if (A[2] == -1)
					return true;
				break;
			case 3:
				if (A[3] == -1)
					return true;
				break;
			}
			break;
		case 'B':
			switch (y) {
			case 1:
				if (B[1] == -1)
					return true;
				break;
			case 2:
				if (B[2] == -1)
					return true;
				break;
			case 3:
				if (B[3] == -1)
					return true;
				break;
			}
			break;
		case 'C':
			switch (y) {
			case 1:
				if (C[1] == -1)
					return true;
				break;
			case 2:
				if (C[2] == -1)
					return true;
				break;
			case 3:
				if (C[3] == -1)
					return true;
				break;
			}
			break;
		}
		return false;

	}

	public static boolean isgamewon() {
		if (isRowWon(A[1], A[2], A[3]))
			return true;
		if (isRowWon(B[1], B[2], B[3]))
			return true;
		if (isRowWon(C[1], C[2], C[3]))
			return true;
		if (isRowWon(A[1], B[1], C[1]))
			return true;
		if (isRowWon(A[2], B[2], C[2]))
			return true;
		if (isRowWon(A[3], B[3], C[3]))
			return true;
		if (isRowWon(A[1], B[2], C[3]))
			return true;
		if (isRowWon(A[3], B[2], C[1]))
			return true;
		return false;
	}

	public static boolean isRowWon(int a, int b, int c) {
		return ((a == b) & (a == c) & (a != -1));
	}

	public static void showboard() {
		System.out.println("    1   2   3");
		System.out.println("A : " + getXO(A[1]) + " | " + getXO(A[2]) + " | "
				+ getXO(A[3]));
		System.out.print("    ");
		for (int i = 0; i < 9; i++)
			System.out.print("_");
		System.out.println();
		System.out.println("B : " + getXO(B[1]) + " | " + getXO(B[2]) + " | "
				+ getXO(B[3]));
		System.out.print("    ");
		for (int i = 0; i < 9; i++)
			System.out.print("_");
		System.out.println();
		System.out.println("C : " + getXO(C[1]) + " | " + getXO(C[2]) + " | "
				+ getXO(C[3]));
	}

	public static String getXO(int square) {
		if (square == 0)
			return "X";
		if (square == 1)
			return "O";
		return " ";
	}
}

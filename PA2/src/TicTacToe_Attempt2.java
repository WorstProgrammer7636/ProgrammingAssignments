import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe_Attempt2 {
	// Tic Tac Toe game

	/**
	 * checks if any player has won the game
	 * 
	 * @param grid
	 * @return
	 */
	public static String checkWinLossStatus(String[][] grid) {
		// checks all rows
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 1; j++) {
				if (grid[i][j].equals(grid[i][j + 1]) && grid[i][j].equals(grid[i][j + 2]) && grid[i][j] != "_"
						&& grid[i][j + 1] != "_" && grid[i][j + 2] != "_") {
					if (grid[i][j].equals("X")) {
						return (PA2Strings.YOU_WON_MSG);
					} else {
						return (PA2Strings.YOU_LOST_MSG);
					}
				}
			}
		}

		// checks columns
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j].equals(grid[i + 1][j]) && grid[i][j].equals(grid[i + 2][j]) && grid[i][j] != "_"
						&& grid[i + 1][j] != "_" && grid[i + 2][j] != "_") {
					if (grid[i][j].equals("X")) {
						return (PA2Strings.YOU_WON_MSG);
					} else {
						return (PA2Strings.YOU_LOST_MSG);
					}
				}
			}
		}

		// checks diagonals
		for (int i = 0; i < 1; i++) {
			if (grid[i][i].equals(grid[i + 1][i + 1]) && grid[i][i].equals(grid[i + 2][i + 2]) && grid[i][i] != "_"
					&& grid[i + 1][i + 1] != "_" && grid[i + 2][i + 2] != "_") {
				if (grid[i][i].equals("X")) {
					return (PA2Strings.YOU_WON_MSG);
				} else {
					return (PA2Strings.YOU_LOST_MSG);
				}
			}
		}

		// checks inverse diagonal
		int temp = 2;
		for (int i = 0; i < 1; i++) {
			if (grid[i][temp].equals((grid[i + 1][temp - 1])) && grid[i + 2][temp - 2].equals(grid[i][temp])
					&& grid[i][temp] != "_" && grid[i + 1][temp - 1] != "_" && grid[i + 2][temp - 2] != "_") {
				if (grid[i][temp].equals("X")) {
					return (PA2Strings.YOU_WON_MSG);
				} else {
					return (PA2Strings.YOU_LOST_MSG);
				}
			}
		}

		return "";

	}

	/**
	 * empties the board and replaces each slot with "_" replaces all board index
	 * values with "_"
	 */
	public static void emptyBoard(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = "_";
			}
		}
	}

	/**
	 * (self explanatory)
	 * 
	 * @param grid
	 */
	public static void printBoard(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * picks which player goes first if player chooses gamemode 1
	 * 
	 * @return
	 */
	public static int gamemode() {
		Scanner input = new Scanner(System.in);
		int gamemode = 0;
		while (true) {
			System.out.print(PA2Strings.INSTR);
			gamemode = input.nextInt();
			if (gamemode == 1) {
				break;
			} else if (gamemode == 2) {
				break;
			} else {
				System.out.println(PA2Strings.GAMEMODE_ERR);
				continue;
			}
		}
		return gamemode;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randint = new Random();
		String playOver = "";
		int randNum = randint.nextInt(2);
		int compScore = 0;
		int playerScore = 0;
		int moveCounter = 0;

		int playerOneScore = 0;
		int playerTwoScore = 0;

		int[] coordinates = new int[2];
		String[][] board = new String[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = "_";
			}
		}

		System.out.println(PA2Strings.WELCOME_MSG);
		int gamemode = gamemode();

		if (gamemode == 1) {
			// play against computer
			if (randNum == 0) {
				// player goes first
				System.out.println(PA2Strings.YOUR_TURN_MSG);
				printBoard(board);

				while (moveCounter <= 9) {
					System.out.print(PA2Strings.ENTER_MOVE);

					// checks if coordinates input value is valid
					String coords = input.nextLine();
					if (coords.length() < 3) {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					}
					if (coords.length() == 3
							&& (coords.charAt(0) == '0'
									|| coords.charAt(0) == '1' || coords.charAt(0) == '2' || coords.charAt(0) == '3'
									|| coords.charAt(0) == '4' || coords.charAt(0) == '5' || coords.charAt(0) == '6'
									|| coords.charAt(0) == '7' || coords.charAt(0) == '8' || coords.charAt(0) == '9')
							&& coords.charAt(1) == ' '
							&& (coords.charAt(2) == '0' || coords.charAt(2) == '1' || coords.charAt(2) == '2'
									|| coords.charAt(2) == '3' || coords.charAt(2) == '4' || coords.charAt(2) == '5'
									|| coords.charAt(2) == '6' || coords.charAt(2) == '7' || coords.charAt(2) == '8'
									|| coords.charAt(2) == '9')) {

						String xCoord = coords.substring(0, 1);
						String yCoord = coords.substring(2, 3);
						int x = Integer.parseInt(xCoord);
						int y = Integer.parseInt(yCoord);

						coordinates[0] = x;
						coordinates[1] = y;
					} else if (coords.length() != 3) {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					} else if (coords.charAt(1) != ' ') {
						System.out.println(PA2Strings.NO_SPACE);
						continue;
					} else {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					}

					// srry for the whitespace but it's really helpful for me right now

					// checks if there is invalid row
					if (coordinates[0] > 2 || coordinates[0] < 0) {
						System.out.println(PA2Strings.INVALID_ROW);
						continue;
					}

					// checks if there is invalid column
					else if (coordinates[1] > 2 || coordinates[1] < 0) {
						System.out.println(PA2Strings.INVALID_COL);
						continue;
					}

					// checks if there is an occupied space
					if (board[coordinates[0]][coordinates[1]] != "_") {
						System.out.println(PA2Strings.OCCUPIED_SPACE);
						continue;
					}

					// marks the board with a spot if the move is valid
					if (coordinates[0] >= 0 && coordinates[0] <= 2 && coordinates[1] >= 0 && coordinates[1] <= 2) {
						board[coordinates[0]][coordinates[1]] = "X";
						moveCounter++;
					}

					// computer makes a move and makes sure it's marked spot isn't occupied
					while (true) {
						int compRandNumX = randint.nextInt(3);
						int compRandNumY = randint.nextInt(3);

						if (board[compRandNumX][compRandNumY] != "_") {
							if (moveCounter == 9) {
								break;
							}
						} else {
							board[compRandNumX][compRandNumY] = "O";
							moveCounter++;
							break;
						}
					}

					// checks if a player has won
					if (checkWinLossStatus(board) != "" || (moveCounter == 9 && checkWinLossStatus(board).equals(""))) {
						printBoard(board);
						System.out.println(checkWinLossStatus(board));
						if (checkWinLossStatus(board).equals(PA2Strings.YOU_LOST_MSG)) {
							compScore++;
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						} else if (checkWinLossStatus(board).equals(PA2Strings.YOU_WON_MSG)) {
							playerScore++;
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						} else {
							System.out.println(PA2Strings.TIE_MSG);
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						}

						// checks if player wants to play again
						while (true) {
							System.out.print(PA2Strings.PLAY_AGAIN_MSG);
							playOver = input.nextLine();
							if (playOver.equals("Y")) {
								moveCounter = 0;
								emptyBoard(board);
								break;
							} else if (playOver.equals("N")) {
								System.out.println(PA2Strings.GAME_OVER);
								return;
							} else {
								System.out.println(PA2Strings.INVALID_FORMAT);
							}
						}
					}

					printBoard(board);
					System.out.println(PA2Strings.YOUR_TURN_MSG);
				}

			} else {
				// computer goes first
				int compRandNumX = randint.nextInt(3);
				int compRandNumY = randint.nextInt(3);
				board[compRandNumX][compRandNumY] = "O";
				printBoard(board);
				moveCounter++;

				// iterates while the board is not filled completely
				while (moveCounter <= 9) {
					System.out.print(PA2Strings.ENTER_MOVE);
					String coords = input.nextLine();
					if (coords.length() < 3) {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					}

					// checks if input coordinates are valid
					if (coords.length() == 3
							&& (coords.charAt(0) == '0'
									|| coords.charAt(0) == '1' || coords.charAt(0) == '2' || coords.charAt(0) == '3'
									|| coords.charAt(0) == '4' || coords.charAt(0) == '5' || coords.charAt(0) == '6'
									|| coords.charAt(0) == '7' || coords.charAt(0) == '8' || coords.charAt(0) == '9')
							&& coords.charAt(1) == ' '
							&& (coords.charAt(2) == '0' || coords.charAt(2) == '1' || coords.charAt(2) == '2'
									|| coords.charAt(2) == '3' || coords.charAt(2) == '4' || coords.charAt(2) == '5'
									|| coords.charAt(2) == '6' || coords.charAt(2) == '7' || coords.charAt(2) == '8'
									|| coords.charAt(2) == '9')) {

						String xCoord = coords.substring(0, 1);
						String yCoord = coords.substring(2, 3);
						int x = Integer.parseInt(xCoord);
						int y = Integer.parseInt(yCoord);

						coordinates[0] = x;
						coordinates[1] = y;
					} else if (coords.length() != 3) {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					} else if (coords.charAt(1) != ' ') {
						System.out.println(PA2Strings.NO_SPACE);
						continue;
					} else {
						System.out.println(PA2Strings.INVALID_FORMAT);
						continue;
					}

					// checks if there is invalid row
					if (coordinates[0] > 2 || coordinates[0] < 0) {
						System.out.println(PA2Strings.INVALID_ROW);
						continue;
					}

					// checks if there is invalid column
					else if (coordinates[1] > 2 || coordinates[1] < 0) {
						System.out.println(PA2Strings.INVALID_COL);
						continue;
					}

					// checks if there is an occupied space
					if (board[coordinates[0]][coordinates[1]] != "_") {
						System.out.println(PA2Strings.OCCUPIED_SPACE);
						continue;
					}

					// marks board with spot if move is valid
					if (coordinates[0] >= 0 && coordinates[0] <= 2 && coordinates[1] >= 0 && coordinates[1] <= 2) {
						board[coordinates[0]][coordinates[1]] = "X";
						moveCounter++;
					}

					// computer generates random move
					while (true) {
						compRandNumX = randint.nextInt(3);
						compRandNumY = randint.nextInt(3);

						if (board[compRandNumX][compRandNumY] != "_") {
							if (moveCounter == 9) {
								break;
							}
						} else {
							board[compRandNumX][compRandNumY] = "O";
							moveCounter++;
							break;
						}
					}

					// checks if anybody won
					if (checkWinLossStatus(board) != "" || (moveCounter == 9 && checkWinLossStatus(board).equals(""))) {
						printBoard(board);
						System.out.println(checkWinLossStatus(board));
						if (checkWinLossStatus(board).equals(PA2Strings.YOU_LOST_MSG)) {
							compScore++;
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						} else if (checkWinLossStatus(board).equals(PA2Strings.YOU_WON_MSG)) {
							playerScore++;
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						} else {
							System.out.println(PA2Strings.TIE_MSG);
							System.out.format(PA2Strings.SCOREBOARD1, playerScore, compScore);
						}

						// checks if player wants to play again
						while (true) {
							System.out.print(PA2Strings.PLAY_AGAIN_MSG);
							playOver = input.nextLine();
							if (playOver.equals("Y")) {
								moveCounter = 0;
								emptyBoard(board);
								break;
							} else if (playOver.equals("N")) {
								System.out.println(PA2Strings.GAME_OVER);
								return;
							} else {
								System.out.println(PA2Strings.INVALID_FORMAT);
							}
						}
					}

					printBoard(board);
					System.out.println(PA2Strings.YOUR_TURN_MSG);
				}
			}

		} else {
			// two player mode
			System.out.println(PA2Strings.PLAYER1_TURN_MSG);
			printBoard(board);
			while (moveCounter < 9) {
				System.out.println(PA2Strings.ENTER_MOVE);
				String coords = input.nextLine();
				if (coords.length() < 3) {
					System.out.println(PA2Strings.INVALID_FORMAT);
					continue;
				}

				// checks if input coordinates are valid
				if (coords.length() == 3
						&& (coords.charAt(0) == '0'
								|| coords.charAt(0) == '1' || coords.charAt(0) == '2' || coords.charAt(0) == '3'
								|| coords.charAt(0) == '4' || coords.charAt(0) == '5' || coords.charAt(0) == '6'
								|| coords.charAt(0) == '7' || coords.charAt(0) == '8' || coords.charAt(0) == '9')
						&& coords.charAt(1) == ' '
						&& (coords.charAt(2) == '0' || coords.charAt(2) == '1' || coords.charAt(2) == '2'
								|| coords.charAt(2) == '3' || coords.charAt(2) == '4' || coords.charAt(2) == '5'
								|| coords.charAt(2) == '6' || coords.charAt(2) == '7' || coords.charAt(2) == '8'
								|| coords.charAt(2) == '9')) {

					String xCoord = coords.substring(0, 1);
					String yCoord = coords.substring(2, 3);
					int x = Integer.parseInt(xCoord);
					int y = Integer.parseInt(yCoord);

					coordinates[0] = x;
					coordinates[1] = y;
				} else if (coords.length() != 3) {
					System.out.println(PA2Strings.INVALID_FORMAT);
					continue;
				} else if (coords.charAt(1) != ' ') {
					System.out.println(PA2Strings.NO_SPACE);
					continue;
				} else {
					System.out.println(PA2Strings.INVALID_FORMAT);
					continue;
				}

				// checks if there is invalid row
				if (coordinates[0] > 2 || coordinates[0] < 0) {
					System.out.println(PA2Strings.INVALID_ROW);
					continue;
				}

				// checks if there is invalid column
				else if (coordinates[1] > 2 || coordinates[1] < 0) {
					System.out.println(PA2Strings.INVALID_COL);
					continue;
				}

				// checks if there is an occupied space
				if (board[coordinates[0]][coordinates[1]] != "_") {
					System.out.println(PA2Strings.OCCUPIED_SPACE);
					continue;
				}

				// determines whether player1 is moving or player2
				if (coordinates[0] >= 0 && coordinates[0] <= 2 && coordinates[1] >= 0 && coordinates[1] <= 2) {
					if (moveCounter % 2 == 0) {
						board[coordinates[0]][coordinates[1]] = "X";
						moveCounter++;
					} else if (moveCounter % 2 == 1) {
						board[coordinates[0]][coordinates[1]] = "O";
						moveCounter++;
					}

				}

				// checks if a player won
				if (checkWinLossStatus(board) != "" || (moveCounter == 9 && checkWinLossStatus(board).equals(""))) {
					printBoard(board);

					if (checkWinLossStatus(board).equals(PA2Strings.YOU_WON_MSG)) {
						System.out.println(PA2Strings.PLAYER1_WIN_MSG);
					} else if (checkWinLossStatus(board).equals(PA2Strings.YOU_LOST_MSG)) {
						System.out.println(PA2Strings.PLAYER2_WIN_MSG);
					}

					if (checkWinLossStatus(board).equals(PA2Strings.YOU_LOST_MSG)) {
						playerTwoScore++;
						System.out.format(PA2Strings.SCOREBOARD2, playerOneScore, playerTwoScore);
					} else if (checkWinLossStatus(board).equals(PA2Strings.YOU_WON_MSG)) {
						playerOneScore++;
						System.out.format(PA2Strings.SCOREBOARD2, playerOneScore, playerTwoScore);
					} else {
						System.out.println(PA2Strings.TIE_MSG);
						System.out.format(PA2Strings.SCOREBOARD2, playerOneScore, playerTwoScore);
					}

					// checks if the player wants to play again
					while (true) {
						System.out.print(PA2Strings.PLAY_AGAIN_MSG);
						playOver = input.nextLine();
						if (playOver.equals("Y")) {
							moveCounter = 0;
							emptyBoard(board);
							break;
						} else if (playOver.equals("N")) {
							System.out.println(PA2Strings.GAME_OVER);
							return;
						} else {
							System.out.println(PA2Strings.INVALID_FORMAT);
						}
					}
				}

				printBoard(board);
				if (moveCounter % 2 == 0) {
					System.out.println(PA2Strings.PLAYER1_TURN_MSG);
				} else {
					System.out.println(PA2Strings.PLAYER2_TURN_MSG);
				}
			}
		}
	}
}


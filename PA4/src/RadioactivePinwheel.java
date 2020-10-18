
import java.util.Scanner;

public class RadioactivePinwheel {
	
	/**
	 * checks if inputted size is valid
	 * @param s
	 */
	public static void checkSizeValidity(int s) {
		// checks if size is in range
		if (s < 4 || s > 50) {
			System.out.format(PA4Strings.SIZE_RANGE_ERR, 4, 50);
			System.exit(1);
		}

		// checks if size is even
		if (s % 2 == 1) {
			System.out.println(PA4Strings.SIZE_EVEN_ERR);
			System.exit(1);
		}
	}

	/**
	 * checks if inputted triangle values are valid
	 * @param ch
	 * @return
	 */
	public static boolean checkCharacterValidity(String ch) {
		char x = ch.charAt(0);
		for (int i = 32; i < 127; i++) {
			if ((int) x == (i)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		//print instructions
		Scanner reader = new Scanner(System.in);
		System.out.format(PA4Strings.RADIOACTIVE_PINWHEEL_INSTR, 4, 50, 32, 126, '@', 32, 126, '`');
		System.out.println();
		System.out.print(PA4Strings.SIZE_PROMPT);

		int size = 0;
		// takes size and checks if it is a valid integer
		try {
			String inputSize = reader.nextLine();
			size = Integer.parseInt(inputSize);
		} catch (NumberFormatException e) {
			System.out.println(PA4Strings.SIZE_INT_ERR);
			System.exit(1);
		}

		checkSizeValidity(size);

		// pick up upward and downward triangle characters
		System.out.format(PA4Strings.CHAR_PROMPT, PA4Strings.UPWARD_CHAR_NAME);
		String upwardChar = reader.nextLine();

		// checks if upward arrow character is valid
		if (upwardChar.length() != 1 && !upwardChar.equals("")) {
			System.out.format(PA4Strings.SINGLE_CHAR_ERR, PA4Strings.UPWARD_CHAR_NAME);
			System.exit(1);
		}

		// sets upward triangle default value 
		if (upwardChar.equals("")) {
			upwardChar = "@";
		}
		
		//self explanatory
		if (checkCharacterValidity(upwardChar) == false) {
			System.out.format(PA4Strings.CHAR_RANGE_ERR, PA4Strings.UPWARD_CHAR_NAME, 32, 126);
			System.exit(1);
		}
		
		System.out.format(PA4Strings.CHAR_PROMPT, PA4Strings.DOWNWARD_CHAR_NAME);
		String downwardChar = reader.nextLine();

		// checks if downward arrow character is valid
		if (downwardChar.length() != 1 && !downwardChar.equals("")) {
			System.out.format(PA4Strings.SINGLE_CHAR_ERR, PA4Strings.DOWNWARD_CHAR_NAME);
			System.exit(1);
		}
		
		//checks if both triangle values are identical
		if (!upwardChar.equals("") && !downwardChar.equals("") && upwardChar.equals(downwardChar)) {
			System.out.println(PA4Strings.UPWARD_DOWNWARD_SAME_CHAR_ERR);
			System.exit(1);
		}

		
		//sets downward triangle default value
		if (downwardChar.equals("")) {
			downwardChar = "`";
		}
		
		//self explanatory
		if (checkCharacterValidity(downwardChar) == false) {
			System.out.format(PA4Strings.CHAR_RANGE_ERR, PA4Strings.DOWNWARD_CHAR_NAME, 32, 126);
			System.exit(1);
		}

		// instantiation
		int count = 0;
		int spaces = (size / 2) - 1;
		int row = 0;
		int spaceCounter = 0;
		int upperCharCounter = 1;
		int downCharCounter = size - 1;
		int upperTemp = 0;
		int downTemp = 0;

		// form the upper half of the wheel
		// Big O Notation Simplified: O(n^2) total.
		while (row < size / 2) {

			// print first set of spaces for the row
			while (spaceCounter < spaces) {
				System.out.print(" ");
				++spaceCounter;
			}
			spaceCounter = 0;

			// print first part of the upper triangle
			while (upperTemp < upperCharCounter) {
				System.out.print(upwardChar);
				upperTemp++;
			}

			// print the downward triangle characters from corresponding row
			while (downTemp < downCharCounter) {
				System.out.print(downwardChar);
				downTemp++;
			}
			upperTemp = 0;
			downTemp = 0;

			// print second part of the upper triangle
			while (upperTemp < upperCharCounter) {
				System.out.print(upwardChar);
				upperTemp++;
			}
			upperTemp = 0;

			// print second set of spaces for the row
			while (spaceCounter < spaces) {
				System.out.print(" ");
				++spaceCounter;
			}
			spaceCounter = 0;

			upperCharCounter += 2;
			downCharCounter -= 2;
			spaces -= 1;
			System.out.println();
			row++;
		}

		// print second half of the wheel
		// re instantiate
		int tempSpace = 0;
		upperTemp = 0;
		downTemp = 0;
		row = 0;
		upperCharCounter = 1;
		downCharCounter = size - 1;
		spaces = 0;
		spaceCounter = 0;

		// Simplified Big O Runtime: O(n^2)
		while (row < size / 2) {

			// print first set of spaces for the row
			while (spaceCounter < spaces) {
				System.out.print(" ");
				++spaceCounter;
			}
			spaceCounter = 0;

			// print first part of downward triangle
			while (downTemp < downCharCounter) {
				System.out.print(downwardChar);
				downTemp++;
			}

			// print upper triangle row by row
			while (upperTemp < upperCharCounter) {
				System.out.print(upwardChar);
				upperTemp++;
			}
			upperTemp = 0;
			downTemp = 0;

			// print second part of the downward triangle
			while (downTemp < downCharCounter) {
				System.out.print(downwardChar);
				downTemp++;
			}
			downTemp = 0;

			// print second set of spaces for the row
			while (spaceCounter < spaces) {
				System.out.print(" ");
				++spaceCounter;
			}
			spaceCounter = 0;

			upperCharCounter += 2;
			downCharCounter -= 2;
			spaces++;
			System.out.println();
			row++;
		}
	}

}

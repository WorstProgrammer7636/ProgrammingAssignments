import java.util.Scanner;
import java.util.Arrays;
class StringSorter {
	
	/**
	 * prints all the sorted Strings in alphabetical order
	 * @param arr
	 */
	public static void printPalindromes (String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * checks if user input entered any input
	 * @param input
	 */
	public static void checkInputValidity(String input) {
		try {
			String test = input;
			char testTwo = input.charAt(0);
		} catch (NumberFormatException a) {
			System.out.println(PA3Constants.INT_ERR_SS);
			System.exit(3);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(PA3Constants.ARG_ERR_SS);
			System.exit(3);
		}
		
		
	}
	
	/**
	 * checks if inputted parameter is a palindrome
	 * @param text
	 * @return
	 */
	 private static boolean isPalindrome(String text) {

		// Base Case 1: Empty string is automatically a palindrome
		if (text.length() == 0) {
			return true;

		}

		// Base Case 2: A one letter word is automatically a palindrome
		if (text.length() == 1) {
			return true;
		}

		// First and last chars match -> cut first and last chars
		if (text.charAt(0) == text.charAt(text.length() - 1)) {
			return isPalindrome(text.substring(1, text.length() - 1));
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int palindromes = 0;
		int nonPalindromes = 0;

		
		int x = 0;
		int num = 0;
		int count = 0;
		int tempLength = 0;
		
		//checks if command argument value is valid
		try {
			tempLength = Integer.parseInt(args[0]);
			num = Integer.parseInt(args[0]);
			x = 1 / num;
		} catch (ArithmeticException e) {
			System.out.println(PA3Constants.ARG_ERR_SS);
			return;
		} catch (NumberFormatException e) {
			System.out.println(PA3Constants.INT_ERR_SS);
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(PA3Constants.ARG_ERR_SS);
			return;
		}
		
		if (num < 0) {
			System.out.println(PA3Constants.NEG_MAX_SIZE_SS);
			return;
		} 
		
		if (args.length > 1) {
			System.out.println(PA3Constants.ARG_ERR_SS);
			return;
		}
		
		
		String[] listOfInputs = new String[num];
		String[] tempListOfPalindromes = new String[tempLength];
		String[] tempListOfNonPalindromes = new String[tempLength];
		

		//takes user inputs and checks if each user input is palindrome or not
		while (reader.hasNextLine()) {
			String tempInput = reader.nextLine();
			listOfInputs[count] = tempInput;
			
			checkInputValidity(tempInput);
			tempInput = tempInput.toLowerCase();
			if (isPalindrome(tempInput) == true) {
				tempListOfPalindromes[palindromes] = tempInput;
				palindromes++;
			} else {
				tempListOfNonPalindromes[nonPalindromes] = tempInput;
				nonPalindromes++;
			}
			
			count++;
			if (count >= num) {
				break;
			}
		}
		
		String[] listOfPalindromes = new String[palindromes];
		String[] listOfNonPalindromes = new String[nonPalindromes];
		
		//separates palindromes and non-palindromes into two different arrays
		for (int i = 0; i < palindromes; i++) {
			listOfPalindromes[i] = tempListOfPalindromes[i];
		}
		
		for (int i = 0; i < nonPalindromes; i++) {
			listOfNonPalindromes[i] = tempListOfNonPalindromes[i];
		}
		
		//sort strings in alphabetical order
		Arrays.sort(listOfPalindromes);
		Arrays.sort(listOfNonPalindromes);
		
		//print everything
		System.out.println(PA3Constants.SORT_PALINDROMES);
		printPalindromes(listOfPalindromes);
		System.out.println(PA3Constants.SORT_NON_PALINDROMES);
		printPalindromes(listOfNonPalindromes);
		
		//changer aaaa
	}

}

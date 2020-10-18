import java.util.Scanner;

public class DetailedWordCount {
	public static int countWords (String text) {
		int count = 0;
		
		if (text.charAt(0) != ' ') {
			count++;
		}
		
		for (int i = 1; i < text.length(); i++) {
			if (text.charAt(i) != ' ' && text.charAt(i - 1) == ' ') {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println("Enter your words below");

		Scanner reader = new Scanner(System.in);

		int count = 0;
		boolean isOneWordLong = true;
		boolean isOneWordShort = true;
		
		//Long Word variables
		int initialWordLength = 0;
		int countOfLongestWords = 0;
		String longestWord = "";
		
		//
		int temp = 0;
		int countOfShortestWords = 0;
		int initialShortWordLength = 0;
		boolean isTheFirstWordTheShortest = true;
		boolean isTheFirstWordTheLongest = true;
		String shortestWord = "";
		
		while (reader.hasNext()) {
			//Figuring out if there's a word with the same length as the longest word
			String str = reader.next();
			temp++;
			if (temp == 1) {
				initialShortWordLength = str.length();
			}
			
			if (str.length() == initialShortWordLength) {
				countOfShortestWords++;
				shortestWord += " " + str;
			}
			
			if (str.length() < initialShortWordLength) {
				initialShortWordLength = str.length();
				countOfShortestWords = 1;
				shortestWord = str;
				isTheFirstWordTheShortest = false;
			}
			
			
			if (str.length() == initialWordLength){
			    countOfLongestWords++;
			    longestWord += " " + str;
			}
			//Checks if word has the longest length
			if (str.length() > initialWordLength) {
				initialWordLength = str.length();
				countOfLongestWords = 1;
				longestWord = str;
				isTheFirstWordTheLongest = false;
			}
			count++;
			
			
		}
		
		
		
		if (count == 0) {
			System.out.println("No words entered");
			return;
		}
		
		System.out.println(PA1Strings.SHORT_WORD_LENGTH + initialShortWordLength);
		System.out.println(PA1Strings.NUM_SHORT_WORDS + countOfShortestWords);
		
		if (countOfShortestWords == 1) {
			System.out.println(PA1Strings.SHORT_WORD + shortestWord);
		} else if (countOfShortestWords == 2){
			System.out.println(PA1Strings.FIRST_LAST_SHORT_WORDS + shortestWord);
		} else if (countOfShortestWords > 2) {
			String firstShortWord = "";
			String lastShortWordtemp = "";
			String lastShortWord = "";
			int i = 0;
			int j = shortestWord.length() - 1;
			if (isTheFirstWordTheShortest) {
				i++;
			}
			while (shortestWord.charAt(i) != ' ') {
				firstShortWord += shortestWord.charAt(i);
				i++;
			}
			
			
			while (shortestWord.charAt(j) != ' ') {
				lastShortWordtemp += shortestWord.charAt(j);
				j--;
			}
			
			for (int k = lastShortWordtemp.length() - 1; k >= 0; k--) {
				lastShortWord += lastShortWordtemp.charAt(k);
			}
			
			System.out.println(PA1Strings.FIRST_LAST_SHORT_WORDS + firstShortWord + " ... " + lastShortWord);
		}
		System.out.println();
		///////////////////////////////////////////////////////////////////////////
		System.out.println(PA1Strings.LONG_WORD_LENGTH + initialWordLength);
		System.out.println(PA1Strings.NUM_LONG_WORDS + countOfLongestWords);
		
		//checks if longestWord(s) is only one word
		
		if (countOfLongestWords == 1) {
			System.out.println(PA1Strings.LONG_WORD + longestWord);
		} else if (countOfLongestWords == 2){
			System.out.println(PA1Strings.FIRST_LAST_LONG_WORDS + longestWord);
		} else if (countOfLongestWords > 2) {
			String firstLongWord = "";
			String lastLongWordtemp = "";
			String lastLongWord = "";
			int i = 0;
			int j = longestWord.length() - 1;
			if (isTheFirstWordTheLongest) {
				i++;
			}
			while (longestWord.charAt(i) != ' ') {
				firstLongWord += longestWord.charAt(i);
				i++;
			}
			
			
			while (longestWord.charAt(j) != ' ') {
				lastLongWordtemp += longestWord.charAt(j);
				j--;
			}
			
			for (int k = lastLongWordtemp.length() - 1; k >= 0; k--) {
				lastLongWord += lastLongWordtemp.charAt(k);
			}
			
			System.out.println(PA1Strings.FIRST_LAST_LONG_WORDS + firstLongWord + " ... " + lastLongWord);
		}
		System.out.println("");
		
		
		
		//////////////////////////////////
		
		//changer a
	}

}

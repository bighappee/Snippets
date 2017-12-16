/**
CKTarango

--- Part Two ---
You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:

Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.

For example:

1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
1221 produces 0, because every comparison is between a 1 and a 2.
123425 produces 4, because both 2s match each other, but no other digit has a match.
123123 produces 12.
12131415 produces 4.
What is the solution to your new captcha?

*/
import java.io.*;

class Day1B{
	public static void main(String [] args){
		try{
			FileReader theFileReader = new FileReader("input.txt");
			BufferedReader buffReader = new BufferedReader(theFileReader);
			String inputString = buffReader.readLine();
			int halfway = inputString.length()/2;
			int captcha =0;
			for(int index =0; index<inputString.length(); index++){
				if (inputString.charAt(index)==inputString.charAt((index+halfway)%inputString.length())) {
					captcha += inputString.charAt(index)-'0';
				}
			}
			System.out.println("The value of the captcha is : "+captcha);
		}
		catch (IOException e) {
    		System.err.println("Caught IOException: " + e.getMessage());
		}
	}
}
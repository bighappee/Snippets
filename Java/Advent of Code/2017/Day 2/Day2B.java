/**
CKTarango

--- Part Two ---
"Great work; looks like we're on the right track after all. Here's a star for your effort." However, the program seems a little worried. Can programs be worried?

"Based on what we're seeing, it looks like all the User wanted is some information about the evenly divisible values in the spreadsheet. Unfortunately, none of us are equipped for that kind of calculation - most of us specialize in bitwise operations."

It sounds like the goal is to find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.

For example, given the following spreadsheet:

5 9 2 8
9 4 7 3
3 8 6 5
In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
In the second row, the two numbers are 9 and 3; the result is 3.
In the third row, the result is 2.
In this example, the sum of the results would be 4 + 3 + 2 = 9.

What is the sum of each row's result in your puzzle input?

Although it hasn't changed, you can still get your puzzle input.

SOLUTION: 261
*/

import java.io.*;
import java.lang.Integer;

class Day2B{
	public static void main(String [] args){
		try{
			FileReader theFileReader = new FileReader("input.txt");
			BufferedReader buffReader = new BufferedReader(theFileReader);
			String inputString = buffReader.readLine();
			int checksum =0;
			while (inputString != null){
				String[] stringArray = inputString.split("\\t");
				int [] intArray = new int[stringArray.length];
				for(int index = 0; index<stringArray.length; index++){
					intArray[index]=Integer.parseInt(stringArray[index]);
				}
				boolean found = false;				
				for (int outer =0; outer<intArray.length; outer++){
					for (int inner = outer+1; inner<intArray.length; inner++){
						if(intArray[inner]%intArray[outer] == 0){
							checksum += (intArray[inner]/intArray[outer]);
							found = true;
							break;
						}
						else if (intArray[outer]%intArray[inner] ==0){
							checksum += (intArray[outer]/intArray[inner]);
							found= true;
							break;
						}
					}
					if(found==true){
						break;
					}
				}
				inputString= buffReader.readLine();
			}
			System.out.println("The checksum is : " +checksum);
		}
		catch (IOException e) {
    		System.err.println("Caught IOException: " + e.getMessage());
		}
		catch (NumberFormatException e){
			System.err.println("Caught NumberFormatException: "+ e.getMessage());
		}
	}
}
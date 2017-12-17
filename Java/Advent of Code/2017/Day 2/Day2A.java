/**
CKTarango

--- Day 2: Corruption Checksum ---
As you walk through the door, a glowing humanoid shape yells in your direction. "You there! Your state appears to be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to display an hourglass cursor!"

The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.

For example, given the following spreadsheet:

5 1 9 5
7 5 3
2 4 6 8
The first row's largest and smallest values are 9 and 1, and their difference is 8.
The second row's largest and smallest values are 7 and 3, and their difference is 4.
The third row's difference is 6.
In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.

What is the checksum for the spreadsheet in your puzzle input?

SOLUTION : 36766
*/

import java.io.*;
import java.lang.Integer;

class Day2A{
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
				int max = intArray[0];
				int min = intArray[0];
				for (int index =1; index<intArray.length; index++){
					if(intArray[index]<min){
						min = intArray[index];
					}
					else if (intArray[index]>max){
						max = intArray[index];
					}
				}
				checksum += (max-min);
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

public class Crypto {
	
	private int input;
	
	public Crypto (int input) {
		this.input = input;
	}
	
	private int[] extract() {
		
		// Extract individual numbers from 4 digit input
		int firstNumber = input / 1000;
		int secondNumber = (input % 1000) / 100;
		int thirdNumber = (input % 100) / 10;
		int fourthNumber = input % 10;
		
		// return list of int because there is not way to directly return multiple variables.
		return new int[] {firstNumber, secondNumber, thirdNumber, fourthNumber};
	}
	
	public int encrypt() {
		
		int[] list = extract();
		
		// Set variables to extracted numbers
		int firstNumber = list[0];
		int secondNumber = list[1];
		int thirdNumber = list[2];
		int fourthNumber = list[3];
		
		// Encryption Method (Replace each digit by adding 7 and mod it by 10)
		firstNumber = (firstNumber + 7) % 10;
		secondNumber = (secondNumber + 7) % 10;
		thirdNumber = (thirdNumber + 7) % 10;
		fourthNumber = (fourthNumber + 7) % 10;
		
		// Combine all numbers
		// (Swap the first with the third digit and the second with the fourth digit.)
		int encryptNumber = (thirdNumber * 1000) + (fourthNumber * 100) +
				(firstNumber * 10) + secondNumber;
		
		return encryptNumber;	
	}
	
	
	public int decrypt() {
		
		int[] list = extract();
		
		// Set variables to extracted numbers
		int firstNumber = list[0];
		int secondNumber = list[1];
		int thirdNumber = list[2];
		int fourthNumber = list[3];
		
		// Decryption Method (If digit minus 7 is negative, then number must increment by 3
		// else number decrement by 7)
		firstNumber = (firstNumber - 7 < 0)?firstNumber + 3:firstNumber - 7;
		secondNumber = (secondNumber - 7 < 0)?secondNumber + 3:secondNumber - 7;
		thirdNumber = (thirdNumber - 7 < 0)?thirdNumber + 3:thirdNumber- 7;
		fourthNumber = (fourthNumber - 7 < 0)?fourthNumber + 3:fourthNumber - 7;
		
		// Combine all numbers
		// (Swap the first with the third digit and the second with the fourth digit.)
		int decryptNumber = (thirdNumber * 1000) + (fourthNumber * 100) +
				(firstNumber * 10) + secondNumber;
				
		return decryptNumber;	
	}
}

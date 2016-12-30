import java.util.Scanner;

public class CryptoTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please key in a 4-digit number:");
		int number = input.nextInt();
		Crypto crypto = new Crypto(number);
		System.out.println("Do you want to encrypt or decrypt?");
		input.nextLine();
		String choice = input.nextLine();
		
		if (choice.toLowerCase().equals("encrypt")) {
			System.out.printf("Encrypted: %d\n", crypto.encrypt());
		} else {
			System.out.printf("Decrypted: %d\n", crypto.decrypt());
		}
		
		System.out.println("Thank you for using my service!");
		input.close();
	}
}

import java.util.Scanner;

// Calculation based on http://www.pafairtax.org/resrcs/calculator.pdf

public class FairTaxCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the FairTax Calculator.\nThis program will help you " + 
		"calculate the annual tax rate under FairTax. \nYou will be required to key in your spendings.");
		

		// Ask for Gross spending amount (all the money available to spend)
		System.out.println("Please key in your Gross Spending Amount.\n(This is calculated by " +
		"all taxable income plus all non-taxable income).");
		double gross = input.nextDouble();
		
		System.out.println("Please key the full amount of your mortgage payments.");
		double mortgage = input.nextDouble();
		
		System.out.println("Please key the total amount of payments on any CURRENT loans.");
		double loanPayments = input.nextDouble();
		
		System.out.println("Please key in the amount of payments made towards education tuition.");
		double tuitionPayments = input.nextDouble();
		
		System.out.println("Please key in the amount of savings you have saved through any means.");
		double savings = input.nextDouble();
		
		System.out.println("Please key in the amount of money you have invested in stocks or bonds.");
		double investment = input.nextDouble();
		
		System.out.println("Please key in the amount of cash you have gave to non-profit charities.");
		double donation = input.nextDouble();
		
		System.out.println("Please key in the amount of cash you gave away to anyone.");
		double freeMoney = input.nextDouble();
		
		System.out.println("Please key in the total amount of income taxes(state and local) and "
				+ "property taxes paid either form payroll witholding or on your own.");
		double taxes = input.nextDouble();
		
		System.out.println("Please key in the total amount you have spent on any large \"used\" items " +
		"for example: land, secondary market real estate, used cars, used furnitures ... etc");
		double usedPayment = input.nextDouble();
		
		System.out.println("Please key in the Annual Health & Human Services (HHS) poverty level of "
				+ "spending for your household.");
		double povertyLevel = input.nextDouble();
		
		input.close();
		
		// Calculations
		double netTaxableSpendingAmount = gross-mortgage-loanPayments-tuitionPayments-savings-
				investment-donation-freeMoney-taxes-usedPayment-povertyLevel;
		System.out.printf("Your Net Taxable Spending Amount is %.2f\n", netTaxableSpendingAmount);
		
		double maxFairTax = 0.23 * netTaxableSpendingAmount;
		System.out.printf("Your Maximum FairTax amount paid is %.2f\n", maxFairTax);
		
		double fairtaxRate = (maxFairTax / gross) * 100;
		System.out.printf("Your FairTax Annual Tax Rate is %.2f%%\n", fairtaxRate);
		
		System.out.println("Thanks for using the FairTax Calculator!");
		
		
	}
}

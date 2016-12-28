import java.util.Calendar;
import java.util.Date;

public class HeartRate {
	// Instance variables
	private String firstName, lastName;
	private int year, month, day;
	private Date date = new Date();
	private Calendar cal = Calendar.getInstance();
	
	// Constructor with 3 parameters
	public HeartRate(String firstName, String lastName, int year,
			         int month, int day) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int newYear) {
		year = newYear;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int newMonth) {
		month = newMonth;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int newDay) {
		day = newDay;
	}
	
	
	// Calculations
	// Calculate Age based on user input
	public int calculateAge() {
		// set Calendar to current date and get current year/month/day
		cal.setTime(date);
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);
		int age = currentYear - 1 - year;
		
		if (currentMonth > month) {
			age++;
		} else if (currentMonth == month) {
			if (currentDay > day) {
				age++;
			}
		}
		
		return age;
	}
	
	// Calculate Maximum heart rate
	public int calculateMaxHeartRate() {
		int maxHeartRate = 220 - this.calculateAge();
		return maxHeartRate;
	}
	
	// Calculate lower bound of target heart rate
	public int calculateMinTarget() {
		return (int) (this.calculateMaxHeartRate() * 0.5); 
	}
	
	// Calculate higher bound of target heart rate
	public int calculateMaxTarget() {
		return (int) (this.calculateMaxHeartRate() * 0.85);
	}
}

package reminderExam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ReminderSystem manager = new ReminderSystem();
		int choice;
		while (true) {
			manager.reminderMenu();
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					manager.addReminder(newReminder());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				manager.sortReminders();
				System.out.println(manager.getReminders().toString());
				break;
			default:
				System.out.println("Goodbye");
				return;
			}

		}

	}

	public static Reminder newReminder() throws ParseException {
		System.out.println("Whats the action?");
		String text = scanner.next();
		System.out.println("Please enter the time of the reminder. Year:");
		int year = scanner.nextInt();
		System.out.println("Month:");
		int month = scanner.nextInt();
		System.out.println("Day:");
		int day = scanner.nextInt();
		System.out.println("Hour:");
		int hour = scanner.nextInt();
		System.out.println("Minute:");
		int minute = scanner.nextInt();
		String sDate = day + "-" + month + "-" + year + " " + hour + ":" + minute + ":" + "00";  
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		Date time=formatter.parse(sDate); 
		System.out.println("Is this important reminder? 0/1");
		int imp = scanner.nextInt();
		boolean important = false;
		if (imp == 1) {
			important = true;
			return new ImportentReminderTask(time, text, important);
		}
		return new ReminderTask(time, text, important);
	}

}

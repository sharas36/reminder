package reminderExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ReminderSystem{
	
	private List<Reminder> reminders;
	Object lock = new Object();
	
	public ReminderSystem() {
		this.reminders = new ArrayList<Reminder>();
	}
	
	public boolean addReminder(Reminder other) {
		synchronized (lock) {
			if(other.getExpiration().getTime() < System.currentTimeMillis()) {
				System.out.println("This date is over!!!");
				return false;
			}
			for (Reminder reminder : reminders) {
				if(reminder.equals(other)) {
					System.out.println("You have this reminder");
					return false;
				}
			}
			this.reminders.add(other);
			Thread t = new Thread(other);
			t.start();
			return true;
		}
		
	}

	
	public void reminderMenu() {
		System.out.println("Whats your next action?\n"
				+ "1. Add reminder\n"
				+ "2. View all reminders\n"
				+ "3. Quit");
	}
	
	public void sortReminders() {
		synchronized (lock) {
			Collections.sort(this.reminders);
		}
		
	}

	protected final List<Reminder> getReminders() {
		return reminders;
	}

	protected final void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	

}

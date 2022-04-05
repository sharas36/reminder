package reminderExam;

import java.util.Calendar;
import java.util.Date;

public class ReminderTask extends Reminder{

	public ReminderTask(Date expiration, String text, boolean important) {
		super(expiration, text, important);
	}

	@Override
	public void run() {
		while(!isPopped()) {
			Date current = new Date(System.currentTimeMillis());
			if (this.getExpiration().getTime() <= current.getTime()) {
				System.out.println(this.getText() + "!!!!!!");
				this.setPopped();
			} else
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public int compareTo(Reminder reminder) {
		if(this.getExpiration().getTime() < reminder.getExpiration().getTime())
			return -1;
		else if(this.getExpiration().getTime() > reminder.getExpiration().getTime())
			return 1;
		
		return 0;
		
	}


}

package reminderExam;

import java.util.Calendar;
import java.util.Date;

public class ImportentReminderTask extends Reminder {

	public ImportentReminderTask(Date expiration, String text, boolean important) {
		super(expiration, text, important);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (!isPopped()) {
			Date current = new Date(System.currentTimeMillis());
			if (this.getExpiration().getTime() <= current.getTime() + 180000) {
				for (int i = 3; i >= 0; i--) {
					System.out.println(this.getText() + " within " + i + " minutes!!");
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
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

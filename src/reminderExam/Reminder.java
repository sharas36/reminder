package reminderExam;

import java.util.Date;
import java.util.Objects;

public abstract class Reminder implements Comparable<Reminder>, Runnable {

	private Date expiration;
	private String text;
	private boolean important;
	private boolean popped = false;

	public Reminder(Date expiration, String text, boolean important) {
		super();
		this.expiration = expiration;
		this.text = text;
		this.important = important;
	}

	public abstract void run();
	
	protected final Date getExpiration() {
		return expiration;
	}

	protected final void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	protected final String getText() {
		return text;
	}

	protected final void setText(String text) {
		this.text = text;
	}

	protected final boolean isImportant() {
		return important;
	}

	protected final void setImportant(boolean important) {
		this.important = important;
	}

	protected final boolean isPopped() {
		return popped;
	}

	protected final void setPopped() {
		this.popped = !popped;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiration, text);
	}

	public boolean equals(Reminder reminder) {
		return Objects.equals(this.expiration, reminder.expiration) && Objects.equals(this.text, reminder.text);
	}

	public boolean compareTo(Date date) {
		return this.expiration.before(date);

	}

	@Override
	public String toString() {
		return "Reminder [expiration=" + expiration + ", text=" + text + ", important=" + important + "there was be reminder?" + isPopped() + "]";
	}

	public int compareTo(Reminder reminder) {
		if(this.getExpiration().getTime() < reminder.getExpiration().getTime())
			return -1;
		else if(this.getExpiration().getTime() > reminder.getExpiration().getTime())
			return 1;
		
		return 0;
		
	}
	
}

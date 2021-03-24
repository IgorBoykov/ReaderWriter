package ua.lviv.ib;

public class LinePart {

	private String time;
	private String logName;
	private String message;

	
	public LinePart(String time, String logName, String message) {
		super();
		this.time = time;
		this.logName = logName;
		this.message = message;
	}

	public LinePart() {
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return time + logName + message;
	}

	
}

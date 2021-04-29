package ua.lviv.ib;

public class LinePart {

	private String time;
	private String logName;
	private String message;
	private String fileName;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return time + " " + message;
	}

	public boolean transformToObject(LinePart lp, String line, String chosenfile) {
		if (chosenfile != null)
			if (!line.contains(chosenfile))
				return false;
		if (line.contains("2021") && line.length() > 40) {
			lp.setTime(line.substring(0, 23));
			lp.setLogName(line.substring(line.indexOf("["), line.indexOf("]") + 1));
			lp.setMessage(line.substring(line.indexOf("]") + 2));
			lp.setFileName(line.substring(line.indexOf("["), line.indexOf("]") + 1));

		}
		return true;

	}

	public static String escSymbols(String str) {
		return str.replace(":", "_").replace("/", "_").replace(".", "_").replace(",", "_").replace("|", "_");

	}

}

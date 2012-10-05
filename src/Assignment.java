import java.util.Date;


public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String getElement(String[] values, int index) {
		if(index > values.length || index < 0)
			return null;
		
		return values[index];
	}
}


public class Task {
	public String Title;
	public String Description;
	private Date CreateDate;
	public Date DueDate;
	public Date CompletionDate;
	
	// accessors for private methods
	public Date getCreateDate() {
		return CreateDate;
	}
	
	Task() {
		Title = "Untitled Task";
		CreateDate = new Date();
	}
	
	Task(String title, Date dueDate) {
		Title = title != null ? title : "Untitled task";
		if(dueDate != null) DueDate = dueDate;
		CreateDate = new Date();
	}
}
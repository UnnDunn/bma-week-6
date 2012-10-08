import java.util.Calendar;
import java.util.Date;


public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Task taskNoParams = new Task();
		Task taskWithParams = new Task("Finish Java Assignment", new Date(112, 9, 8));
		
		System.out.println("Created the following Task objects:");
		System.out.println(taskNoParams);
		System.out.println(taskWithParams);
	}

	public static String getElement(String[] values, int index) {
		if(index >= values.length || index < 0)
			return null;
		
		return values[index];
	}
}


class Task {
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
	
	public String toString() {
		String result = "Task: ";
		result += "\"" + Title + "\", ";
		result += "Created :" + CreateDate;
		if(DueDate != null) result += ", Due: " + DueDate;
		if(CompletionDate != null) result += ", Completed: " + CompletionDate;
		
		return result;
	}
}
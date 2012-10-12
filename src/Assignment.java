import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Assignment {
	public static List<Task> AllTasks;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AllTasks = new ArrayList<Task>();
		AllTasks.add(new Task());
		
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 10, 8);
		AllTasks.add(new Task("Finish Java Assignment", cal.getTime()));
		
		ListTasks();
	}
	
	public void ListTasks() {
		if(AllTasks.isEmpty()) {
			System.out.println("There are no tasks in the list");
			return;
		}
		
		System.out.println("All Tasks:\n==========");
		
		int i = 1;
		for (Task task : AllTasks) {
			System.out.println(i + ": " + task + "\n---");
			i++;
		}
	}
	
	public void DeleteTask(int index, boolean confirmed) {
		
	}
	
	public void CreateTask() {
		
	}

	public static String getElement(String[] values, int index) {
		if(index >= values.length || index < 0)
			return null;
		
		return values[index];
	}
	
	public static void ShowHeading(String prompt) {
		String hrule = "";
		for(int i = 0; i < prompt.length; i++) hrule += "=";
		
		
	}
}


abstract class Task {
	private String Title;
	private String Description;
	private Date CreateDate;
	private Date DueDate;
	private Date CompletionDate;
	
	// Accessors
	public String getTitle() {
		return this.Title;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public Date getDueDate() {
		return DueDate;
	}
	
	public Date getCompletionDate() {
		return CompletionDate;
	}
	
	public Boolean isComplete() {
		return CompletionDate != null;
	}
	
	public Date getCreateDate() {
		return CreateDate;
	}
	// End Accessors
	
	Task() {
		Title = "Untitled Task";
		CreateDate = new Date();
	}
	
	Task(String title, Date dueDate) {
		Title = title != null ? title : "Untitled task";
		if(dueDate != null) DueDate = dueDate;
		CreateDate = new Date();
	}
	
	public void CompleteTask() {
		// set completion date for task
		CompletionDate = new Date();
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

class RepeatingTask extends Task
{
	protected List<Date> DueDates;
	
	public Date getDueDate() {
		if (DueDates.isEmpty()) return null;
		
		Date result = null;
		
		Collections.sort(DueDates);
		
		Date currentDate = new Date();
		
		for(Date testDate : DueDates){
			if(testDate.compareTo(currentDate) > 1) {
				result = testDate;
				break;
			}
		}
		
		if (result == null) result = DueDates.get(DueDates.size() - 1);
		return result;
	}
	
	
}

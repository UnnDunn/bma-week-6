import java.util.Date;
import java.util.List;


public class Assignment {

	public static List<Task> AllTasks;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AllTasks = new List<Task>();
		
		AllTasks.add(new Task());
		AllTasks.add(new Task("Finish Java Assignment", new Date(112, 9, 8)));
		
		ListTasks();
	}
	
	public static void ListTasks() {
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
		if(index > values.length || index < 0)
			return null;
		
		return values[index];
	}
}


class Task {
	public String Title;
	public String Description;
	private Date CreateDate;
	public Date DueDate;
	private Date CompletionDate;
	
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
package Assignment;
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
		AllTasks.add(new OneTimeTask());
		
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 10, 8);
		AllTasks.add(new OneTimeTask("Finish Java Assignment", cal.getTime()));
		
		ListTasks();
	}
	
	public static void ListTasks() {
		if(AllTasks.isEmpty()) {
			System.out.println("There are no tasks in the list");
			return;
		}
		
		System.out.println(ShowHeading("All Tasks"));
		
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
	
	public static String ShowHeading(String prompt) {
		String hrule = "";
		for(int i = 0; i < prompt.length(); i++) hrule += "=";
		return prompt + "\n" + hrule;
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
	
	public void setTitle(String title) {
		Title = title;
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
	
	Task(String title)
	{
		setTitle(title);
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
		String result = "Task: "
				+ TitleString() 
				+ ", " + CreatedDateString()
				+ ", " + DueDateString()
				+ ", " + CompletionDateString();
		
		return result;
	}
	
	protected String CreatedDateString() {
		return "Created: " + CreateDate;
	}
	
	protected String TitleString() {
		return "\"" + Title + "\"";
	}
	
	protected String DueDateString() {
		return DueDate == null ? "No Due Date" : "Due: " + DueDate;
	}
	
	protected String CompletionDateString() {
		return CompletionDate == null ? "No Completion Date" : "Completed: " + CompletionDate;
	}
}

class OneTimeTask extends Task
{
	public OneTimeTask() {
		super();
	}
	
	public OneTimeTask(String title) {
		super(title);
	}

	public OneTimeTask(String title, Date dueDate) {
		super(title, dueDate);
	}
}

abstract class RepeatingTask extends Task
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
	
	public List<Date> listDueDates() {
		return DueDates;
	}
	
	public void SetDueDate(Date dueDate) {
		if(!DueDates.contains(dueDate)) DueDates.add(dueDate);
	}
	
	public void ResetDueDates() {
		DueDates.clear();
	}
	
	public String toString() {
		String result = "Repeating ";
		result += super.toString();
		result += DueDatesString(false);
		
		return result;
	}
	
	protected List<Date> getDueDatesAfter(Date minDate)
	{
		List<Date> resultDates = new ArrayList<Date>();
		for(Date date : DueDates) {
			if(date.compareTo(minDate) > 0) {
				resultDates.add(date);
			}
		}
		
		return resultDates;
	}
	
	protected String DueDatesString(Boolean showUpcomingOnly) {
		showUpcomingOnly = showUpcomingOnly != null ? showUpcomingOnly : false;
		
		List<Date> resultDates = new ArrayList<Date>();
		if(showUpcomingOnly) {
			resultDates = getDueDatesAfter(new Date());
		}
		
		String result = null;
		// add due dates to string if necessary
		if(resultDates.isEmpty()) {
			result += showUpcomingOnly ? "\nNo upcoming due dates for this task.\n" : "\nNo due dates for this task.\n";
		} else {
			result += showUpcomingOnly ? "\nUpcoming Due Dates:\n" : "\nDue dates:\n";
			for(Date date : resultDates) {
				result += "\t" + date + "\n";
			}
			
			result += showUpcomingOnly
					? String.format("%s upcoming dates (out of %s total dates.)\n", resultDates.size(), DueDates.size())
					: String.format("%s total dates.", resultDates.size());
		}
		
		return result;

	}
}

class DailyTask extends RepeatingTask
{
	private Date TimeOfDay;
	
	
}
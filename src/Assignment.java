
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

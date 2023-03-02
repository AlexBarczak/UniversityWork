
public class RunnableClass implements Runnable {

	public String message;
	public int value;
	public Test tester;
	
	public RunnableClass(String message, int value, Test testObject) {
		this.message = message;
		this.value = value;
		this.tester = testObject;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tester.result += value;			
		}
	}
	
	

}

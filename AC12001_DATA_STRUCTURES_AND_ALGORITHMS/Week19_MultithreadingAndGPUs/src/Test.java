
public class Test {
	
	long result = 0; 
	
	public static void main(String[] args) {
	Test myTest = new Test();
	myTest.runnableTest("Thread: 1", 9, myTest);
	myTest.runnableTest("Thread: 2", -10, myTest);
		
	new MyThread(myTest);
	}
	
	public void runnableTest(String message, int value, Test testObject) {
		RunnableClass myRunnableClass = new RunnableClass(message, value, testObject);
		Thread myThread = new Thread(myRunnableClass);
		myThread.start();
	}
}

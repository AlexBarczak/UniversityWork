
public class MyThread extends Thread {

	public Test tester;
	
	public MyThread(Test testObject) {
		super();
		this.tester = testObject;
		this.run();
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		while(true) {
			System.out.println(tester.result);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

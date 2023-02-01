
public class Tester {
	
	List testList;

	public static void main(String[] args) {
		Tester myTester = new Tester();
		myTester.initialise();
		myTester.process();

	}
	
	private void initialise() {
		testList = new List();		
		testList.setHead(null);
		
		for (int i = 1; i <= 100; i++) {
			testList.addToList(Integer.toString(i), i);
		}
	}

	private void process() {
		testList.printList();
		
		System.out.println("\n\n\n\n\n");
		
		testList.find("0");
		testList.find("100");
		testList.find("1");
		testList.find("44");
	}

}

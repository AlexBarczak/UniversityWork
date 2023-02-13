import java.util.HashSet;
import java.util.Set;

public class MySetWrapper {
	public HashSet<Integer> mySet;
	
	public MySetWrapper() {
		this.mySet = new HashSet<Integer>();
	}
	
	public MySetWrapper(HashSet<Integer> readySet) {
		this.mySet = readySet;
	}
	
//	i) printSet() // Display the contents of the set data to the user
	public void printSet() {
		//it works with integers, displays them in an array like structure. good enough
		System.out.println(mySet);
	}
//	ii) addToSet() // Add a number to the set
	//
	public void addToSet(Integer number) {
		//this is just a loss of information, the original function returns a boolean detailing whether the value was in the set already or not
		this.mySet.add(number);
	}
//	iii) isSetEmpty() // returns true id the set is empty, false otherwise
	public boolean isSetEmpty() {
		return this.mySet.isEmpty();
	}
//	iv) getCardinality() // returns the cardinality of the set
	public Integer getCardinality() {
		return this.mySet.size();
	}
//	v) isInSet(int number) // returns true if the given number is in the set already
	public boolean isInSet(Integer number) {
		return this.mySet.contains(number);
	}
//	vi) intersection(MySet setb) // performs a set intersection operation by creating a
	public MySetWrapper intersection(MySetWrapper setb) {
		@SuppressWarnings("unchecked")
		HashSet<Integer> copy = (HashSet<Integer>) this.mySet.clone();
		copy.retainAll(setb.mySet);
		
		return new MySetWrapper(copy);
	}
//	copy of the current set, doing a retainAll with setB
//	and returning the result as a new MySet object.
	
}

public class Stack<T>{
	
	private ListNode<T> top;
	
	/**
	 * initialising method for the stack
	 * 
	 * sets the top reference to null
	 */
	public Stack() {
		top = null;
	}
	
	/**
	 * pushes a value to the top of the stack
	 * 
	 * @param stackItem value going to the top of the stack
	 */
	public void push(T stackItem) {
		//create a new list node storing the new top value
		ListNode<T> newTop = new ListNode<T>(stackItem);
		
		//reference the current top node in the new top node and then replace it
		newTop.setNext(top);
		top = newTop;
	}
	
	
	/**
	 * method removes the list node at the top of the stack and returns it
	 * 
	 * @return value at the top of the stack
	 */
	public T pop() throws EmptyStackException {
		
		if(top == null)throw new EmptyStackException();
		
		T valueToReturn = top.getValue();
		
		top = top.getNext();
		
		return valueToReturn;
	}

	public boolean isEmpty() {
		return top == null;
	}

}

/**
 * AC12001/AC22007 Lab 1 Starting files
 * 
 * @author Computing, School of Science and Engineering, University of Dundee.
 *		   Note. Change this to comment to describe this class and add your name!
 * @version v1.0
 */
public class ListNode<T>    
{
    // fields to store the data being held in this list node (a number)
    private T value;
    
    // DONE: Add a field to store a reference to the next node in the list after this one
    private ListNode<T> nextNode;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        // set id and mark to default / empty values 
        value = null;

        // Done: set next node to null - no valid next node yet
        nextNode = null;
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param value The Double value stored at this list node
     */
    public ListNode(T value)
    {
        // set id and mark to values provided
        this.value = value;

        // Done: set next node to null - no valid next node yet
        nextNode = null;
    }

    /**
     * Get the student ID contained in this list node
     * 
     * @return The student's ID as a String
     */
    public T getValue()
    {
        return value;
    }

    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public ListNode<T> getNext()
    {
       // DONE: return your list node reference
    	return nextNode;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param next A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(/* DONE: Add a parameter here */ ListNode<T> next)
    {
    	// DONE: store your list node reference
    	nextNode = next;
    }
}

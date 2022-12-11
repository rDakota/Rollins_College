/**
 * Node Class
 * @author Rowan Richter and Gus Temple
 * @date 11/17/2022
 */
public class NodePointer {
	
	// Private data members: char data and recursive declaration for NodePointer next
	private char data;
	private NodePointer next; // recursive
	
	// ---------------------------------
	// Empty constructor method
	public NodePointer() {
		
	}
	
	// ---------------------------------
	// Non Empty constructor method
	public NodePointer(char l) {
		this.data = l;
		this.next = null; // new Nodes always have Null as their "next" data member
	}
	
	// ---------------------------------
	// GETTER METHODS ====> access data members of NodePointer object

	public int getData() {
		return this.data;
	}
	
	
	public NodePointer getNext() {
		return this.next;
	}
	
	// ---------------------------------
	// SETTER METHODS ====> mutate data members of NodePointer object

	public void setData(char l) {
		this.data = l;
	}

	public void setNext(NodePointer next) {
		this.next = next;
	}
	
	// ---------------------------------
	// PRINT METHOD ====> prints the data of a node
	public void printNode() {
		System.out.print(this.data);
	}
}

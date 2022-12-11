/**
 * Linked List class
 * @author Rowan Richter and Gus Temple
 * @date 11/17/2022
 */

import java.util.ArrayList;

public class Llist {
	// Private data members: NodePointer head and 
	// ArrayList of node objects needed for background implementations
	private NodePointer head;
	private ArrayList<NodePointer> nodes = new ArrayList<NodePointer>();
	
	
	// Empty Constructor
	public Llist() {
		
	}
	
	// ---------------------------------
	// GETTER METHODS ====> access data members of Felon object

	public NodePointer getHead() {
		return this.head;
	}
	
	public ArrayList<NodePointer> getNodes() {
		return this.nodes;
	}
	
	
	// ---------------------------------
	// SETTER METHODS ====> mutate data members of Felon object

	public void setHead(NodePointer head) {
		this.head = head;
	}
	
	public void setNodes(ArrayList<NodePointer> nodes) {
		this.nodes = nodes;
		
	}
	
	// ----------------------------------------
	// ADD methods ==========>
	
	/*
	 * 	Adds a NodePointer to the start position of the linked List
	 * 	the start position the last instance of a space(star) or a newline
	 *  or if neither exists then it is the head
	 *  
	 *  this occurs because spaces(stars) and newlines indicate 
	 *  the restarting of the decrypting algorithm on a new word
	 *  in the text file
	 *  
	 */
	public void addAtStart(NodePointer newNode) {
		// idx save the insert position for each new words as we encounter them
		int idx = 0;
		// counter counts each node it is iterated through
		int counter = 0;
		
		// create start position Node pointer
		NodePointer start = this.head;
		
		// if LL is empty
		if (this.head == null) {
			this.head = newNode;
			// add to the ArrayList
			this.nodes.add(0, newNode);
			
		// list is not empty
		} else {
			// create temporary node for iteration
			NodePointer temp = head;
			while(temp != null) {
				if (temp.getData() == ' ' || temp.getData() == '\n') {
					// starting position is placed at last ' ' or '\n' in the list
					start = temp;
					idx = counter + 1;
				}
				// iterate through
				temp = temp.getNext();
				counter++;
			}
			// if start has been changed to something else then that is where the
			// new nodePointer is placed
			if (this.head != start) {
				newNode.setNext(start.getNext());
				start.setNext(newNode);
				
				
				// add to the correct spot in the arrayList too
				this.nodes.add(idx, newNode);
				
			} else {
			// if it stays the same then that means that start is just where head is
			// new nodePointer is placed
				newNode.setNext(head);
				head = newNode;
				
				// still in the first word, so add to the beginning
				this.nodes.add(0, newNode);
			}
		} 
	}
	
	/*
	 *  Adds a NodePointer to the tail of the linked List
	 *  iterates through the whole thing and puts it at the end
	 */
	public void addAtTail(NodePointer newNode) {
		
		// add to the end of the ArrayList
		this.nodes.add(newNode);
		
		// if LL is empty
		if (this.head == null) {
			this.head = newNode;
			
		} else {
		// if LL is not empty
			// temporary node for iteration
			NodePointer temp = head;
			// iterate until reach second to last Node
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		} 
	}
	
}
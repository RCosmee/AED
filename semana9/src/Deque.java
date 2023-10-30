import java.util.NoSuchElementException;
import java.util.Scanner;


public class Deque<Item> { // Deque with linked list

	Node first; // Início da deque
	Node last; // Fim da deque

	private class Node {
		Item item;
		Node next;
		Node prev;

	}

	// Initialise an empty deque
	public Deque() {
		first = null;
		last = null;
	}

	// Is the deque empty?
	public boolean isEmpty() {
		return first == null;
	}

	// Number of items in the deque
	public int size() {
		return size(first);
	}

	// Recursive auxiliary of size
	private int size(Node d) {
		if (d == null) { // no e' null
			return 0;
		} else {
			return 1 + size(d.next);
		}
	}

	// Add an item to the left end
	public void pushLeft(Item item) {
		Node newfirst = new Node();
		newfirst.item = item;
		newfirst.next = first;
		newfirst.prev = null;

		if (first != null) {
			first.prev = newfirst;
		} else {
			last = newfirst;
		}

		first = newfirst;
	}

	// Add an item to the right end
	public void pushRight(Item item) {
		last = pushRight(last, item);
        if (first == null) {
            first = last;
        }
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
       
	}

	// Recursive auxiliary of pushRight
	private Node pushRight(Node d, Item item) {
		if (d == null) {
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = null;
            newNode.prev = null;
            return newNode;
        } else {
            Node nextNode = pushRight(d.next, item);
            d.next = nextNode;
            nextNode.prev = d;
            return d;
        }
	}

	// Remove item from the left end
	public void popLeft() {
		if (first == null)
			throw new IllegalStateException("Error: Empty queue!");
		first = first.next;
		
		if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }

	}

	// Remove item from the right end
	public void popRight() { 	
        if (first == null)
			throw new IllegalStateException("Error: Empty queue!");
        if (last.next != null)
        	last = popRight(last);

        if (last == null) {
            first = null;
        }
	}

	// Recursive auxiliary of popRight
	private Node popRight(Node d) {
		if (d.prev == null) {
            return null;
        } else {
            d.prev.next = null;
            return popRight(d.prev);
        }
	}

	// Get the item on the left end
	public Item left() {
		if (first == null)
			throw new NoSuchElementException("Error: Empty queue!");
		else 
		return first.item;
	}

	// Get the item on the right end
	public Item right() {
		if (first == null)
			throw new NoSuchElementException("Error: Empty queue!");
		else 
		return last.item;
	}

	// Recursive auxiliary of right
	private Item right(Node d) {
		if (first == null)
			throw new NoSuchElementException("Error: Empty queue!"); 
		if (d.prev == null) {
	            return d.item;
	        } else {
	            return right(d.prev);
	        }
	}
	

}
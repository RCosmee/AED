import java.util.NoSuchElementException;
import java.util.Scanner;

public class queue<Item>{ // queue with linked list

	private Node first = null;

	private class Node {
		Item item;
		Node next;
	
		Node (Item item, Node next){
			this.item = item;
			this.next=next;
		}
	}

//recursivo
public void enqueue(Item item) {
			
		first = enqueue(first, item);
	

}

private Node enqueue(Node f, Item item) {
	if (f == null) {
		return new Node(item, null);
	} else {
		f.next = enqueue(f.next, item);
		return f;
	}
}

// Initialise an empty deque
	public void dequeue() {
		if (first == null)
			throw new IllegalStateException("Error: Empty queue!");
		first = first.next;
}

	public Item first() {
		if (first == null)
			throw new NoSuchElementException("Error: Empty queue!");
		else 
		return first.item;
	}

	// Is the deque empty?
	public boolean isEmpty() {
		return first == null;
	}

	//recursiva Number of items in the deque
	public int size(Node f) {
		if(f == null) { //no e' null
		return 0;
		} else {
		return 1 + size(f.next);	
		}
	}
	//recursivao
	public String toString(){
		return toString(first ) + "\n";
	}
	
	private String toString(Node f) {
	if(f == null)
		return "";
	else
		return f.item + " " + toString(f.next);
	}

	public static void main(String[] args) {
		queue<String> queue = new queue<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String word = sc.next();
			if (word.equals("end"))
				break;
			if (word.equals("-")) {
				System.out.println(queue.first());
				queue.dequeue();
			}
			
			else
				queue.enqueue(word);
		}
		sc.close();
		
	System.out.println(queue.toString());
	
	}

}

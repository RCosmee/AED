import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {
	
	private Node first, last;
	private int size;

	private class Node {
		private Item item;
		private Node next;
	}

	// create an empty queue
	public Queue() {
		first = null;
		last = null;
		size = 0;
	}

	// add an item
	public void enqueue(Item item) {
		
		Node oldLast = last;
		
		
		
		last = new Node();
		last.item = item;
		last.next = null;

		// caso vazio
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}

	// remove the least recently added item e mostra
	public Item dequeue() {
		// caso vazio
		if (isEmpty())
			throw new IllegalStateException("Queue is Empty!");

		Item item = first.item;

		//caso 1 item
		if (size == 1) {
			first = null;
			last = null;
			size = 0;
			return item;
		}

		// caso geral
		first = first.next;
		size--;
		
		if (isEmpty())
			last = null;
			
		return item;

	}

	// is the queue empty?
	public boolean isEmpty() {
		return (first == null);
	}

	// number of items in the queue
	public int size() {
		return size;
	}

	// support iteration
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
		Node cur = first;

		@Override
		public boolean hasNext() {
			return cur!=null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException("There is no next!");
			Item i = cur.item;
			cur = cur.next;
			return i;
		}

	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String word = sc.next();
			if (word.equals("end"))
				break;
			if (word.equals("-"))
				System.out.println(queue.dequeue());
			else
				queue.enqueue(word);
		}
		sc.close();
		for (String str : queue) {
			System.out.print(str + " ");
		}

	}

	/* 
	   a eficiência espacial da solução proposta é de ordem de grandeza 1 (constante) para os métodos, e para a classe toda é linear pois depende do tamanhdo da fila
	  
	   a eficiência temporal da solução proposta é de ordem 1 (constante) para os métodos enqueue(), dequeue(), isEmpty() e size() (pois não dependem do tamanho da fila)
	*/

}
import java.util.Arrays;
import java.util.Scanner;

public class ResizingArrayQueueOfStrings {

	private String[] q;
	private int first, last;
	private static final int INIT_CAPACITY = 10;

	public ResizingArrayQueueOfStrings() {
		q = new String[INIT_CAPACITY];
		first = -1;
		last = -1;
	}

	private int next(int i) {
		return (i + 1) % q.length;
	}

	public void resize(int cap) {
		String[] q1 = new String[cap];
		if (cap>q.length)
		for (int i = 0; i !=q.length ; i++) {
			q1[i] = q[first];
			first = next(first);
		}
		if (cap<q.length)
			for (int i = 0; i !=q1.length ; i++) {
				q1[i] = q[first];
				first = next(first);
			}
		first = 0;
		last = q.length - 1;
		q = q1;
	}
	
	public void enqueue(String item) {
		// Caso cheio
		if (first == next(last)) {
		resize(2*q.length);
		}

		// Caso geral
		last = next(last);
		q[last] = item;
		// Caso vazia
		if (first == -1)
			first = 0;
	}

	public String dequeue() {

		if (isEmpty())
			throw new IllegalStateException("Queue is empty!");

		String a = q[first];
		q[first] = null;

		if (first == last) {
			first = -1;
			last = -1;
		} else
			first = next(first);

		if (size() == q.length / 4 && size()>0) {
			resize(q.length/2);
			last = q.length /2 - 1;
		}
		return a;
	
	}

	public boolean isEmpty() {
		return (first == -1 && last == -1);
	}

	public int size() {
		if (isEmpty())
			return 0;
		if (first <= last)
			return last - first +1;
		else
			return q.length - first + last + 1;

	}

	public String toString() {
		return Arrays.toString(q);
	}

	public static void main(String[] args) {
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
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
		System.out.println(queue.toString());
	}

}
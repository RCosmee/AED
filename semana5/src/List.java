import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class List<Item> implements Iterable<Item> {

	private Node first, last;
	private int size;

	private class Node {
		private Item item;
		private Node next;
		private Node prev;
	}

	public List() { // create an empty list
		first = null;
		last = null;
		size = 0;
	}

	public void add(Item item) { // add an item to the end of the list
		Node oldLast = last;

		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldLast;

		if (isEmpty())
			first = last;
		else
			oldLast.next = last;

		size++;
	}

	public boolean removeFirst(Item item) { // remove the first occurrence of item (returns false if item is not found)
		for (Node aux = first; aux != null; aux = aux.next)
			if (aux.item.equals(item)) {
				// primeira posição
				if (aux.prev == null)
					first = aux.next;
				else
					aux.prev.next = aux.next;
				// ultima posição
				if (aux.next == null)
					last = aux.prev;
				else
					aux.next.prev = aux.prev;
				size--;
				break;
			}
		return false;
	}

	public boolean removeLast(Item item) { // remove the last occurrence of item (returns false if item is not found)
		for (Node aux = last; aux != null; aux = aux.prev)
			if (aux.item.equals(item)) {
				// primeira posição
				if (aux.prev == null)
					first = aux.next;
				else
					aux.prev.next = aux.next;
				// ultima posição
				if (aux.next == null)
					last = aux.prev;
				else
					aux.next.prev = aux.prev;
				size--;
				break;
			}
		return false;
	}

	public boolean removeAll(Item item) { // remove all the occurrences of item (returns false if item is not found)
		for (Node aux = first; aux != null; aux = aux.next)
			if (aux.item.equals(item)) {
				// primeira posição
				if (aux.prev == null)
					first = aux.next;
				else
					aux.prev.next = aux.next;
				// ultima posição
				if (aux.next == null)
					last = aux.prev;
				else
					aux.next.prev = aux.prev;
				size--;
			}
		return false;
	}

	public boolean isEmpty() { // is the queue empty?
		return (first == null);
	}

	public boolean contains(Item item) { // is item in the list?

		if (isEmpty())
			return false;
		else {

			boolean exists = false;
			for (Node aux = first; aux != null; aux = aux.next)
				if (aux.item.equals(item))
					exists = true;
			return exists;
		}

	}

	public int size() { // number of items in the list
		return size;
	}

	public Iterator<Item> iterator() { // supports iteration in the order of insertion
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		Node cur = first;

		@Override
		public boolean hasNext() {
			return cur != null;
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
		List<String> list = new List<String>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String word = sc.next();
			if (word.equals("end"))
				break;
			if (word.equals("size"))
				System.out.println(list.size());
			else
				list.add(word);
		}

		// lista antes
		System.out.print("Lista antes: ");
		for (String str : list)
			System.out.print(str + " ");
		System.out.println();

		// removeFirst
		System.out.println("Qual item quer testear com removeFirst?");
		String itemF = sc.next();
		list.removeFirst(itemF);
		System.out.print("Lista depois de removeFirst: ");
		for (String str : list)
			System.out.print(str + " ");
		System.out.println();

		// removeLast
		System.out.println("Qual item quer testear com removeLast?");
		String itemL = sc.next();
		list.removeLast(itemL);
		System.out.print("Lista depois de removeFirst: ");
		for (String str : list)
			System.out.print(str + " ");
		System.out.println();

		// removeAll
		System.out.println("Qual item quer testear com removeAll?");
		String item = sc.next();
		list.removeAll(item);
		System.out.print("Lista depois de removeAll: ");
		for (String str : list)
			System.out.print(str + " ");
		System.out.println();

		sc.close();

		// verificar o que sobrou
		System.out.print("Lista depois: ");
		for (String str : list) {
			System.out.print(str + " ");
		}

	}

	/*
	 * a eficiência espacial da solução proposta é de ordem de grandeza N (pois no
	 * pior caso percorre a lista toda)
	 * 
	 * a eficiência temporal da solução proposta é de ordem 1 (constante) para os
	 * métodos add(), isEmpty(), contains() e size() (pois não dependem do tamanho
	 * da lista), enquanto o resto dos métodos (removeFirst(), removeLast() e
	 * removeAll()) são de ordem de grandeza N (pois dependem do tamanho da lista
	 * porque percorrem a lista toda (no pior caso))
	 */

}
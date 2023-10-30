public class HeapZeroIdx {

	public static void sort(Comparable[] a) {

		int N = a.length - 1;
		// Heapify
		for (int i = N / 2; i >= 0; i--) {
			sink(a, i, N);
		}

		// Sortdown: N x delMax
		while (N > 0) {
			// trocar pos 0 com N
			// Decrementar N
			// sink da pos 0
			exchange(a, 0, N);
			N--;
			sink(a, 0, N);

		}
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	private static void exchange(Comparable[] a, int i, int j) {
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	private static void sink(Comparable[] a, int i, int N) { //TODO mudar o sink 
		// Filhos de i: 2*i +1 e 2*i +2
		// Critétios de paragem: Cheguei numa folha OU no 'i' e maior ou igual ao maior
		// dos seus filhos
		while (2 * i +1<= N) {
			int idxLarger = 2 * i +1;
			if ((idxLarger + 1 <= N) && (less(a, idxLarger, idxLarger + 1)))
				idxLarger++;

			if (less(a, i, idxLarger))
				exchange(a, i, idxLarger);
			else
				break;

			i = idxLarger;

		}
	}
	
	public static void print(Comparable[] a) {

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println();

	}
	
	public static void main(String[] args) {
		//random array
		int N = 10;
		Comparable [] a = new Comparable [N];
		
		for(int i = 0; i<a.length;i++) {
			int r = (int)(Math.random()*N);
			a[i] = r + "";
		}
		
		//fprint array
		System.out.println("Array antes: ");
		print(a);
		
		//sort array
		sort(a);
		//fprint array ordenado
		System.out.println("Array depois: ");
		print(a);
		
	}
}
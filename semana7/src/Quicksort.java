public class Quicksort {

	public static void sort(Comparable[] a) {
		// baralhar
		shuffle(a);

		sort(a, 0, a.length - 1);
	}

	private static void shuffle(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int pos = (int) (Math.random() * (i + 1));
			exchange(a, i, pos);
		}
	}

	private static void exchange(Comparable[] a, int i, int j) {
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	// versao recursiva
	private static void sort(Comparable[] a, int lo, int hi) {

		if (hi <= lo) //criterio de paragem
			return;

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		//item de particao => a [lo]
		int i = lo;
		int j = hi + 1;
		while(true) {
			do {
				i++;
			} while ((i != hi) && less(a[i], a[lo])); // a[i] < a[lo]
			
			do {
				j--;
			} while (less(a[lo], a[j])); // a[j] > a[lo]
			if(i>=j) 
				break;
			exchange (a, i, j);		
		}
		exchange (a, lo, j);
		return i;
			
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

}
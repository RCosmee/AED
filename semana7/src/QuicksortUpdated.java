public class QuicksortUpdated {

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
		// Parar a recursão para subarray de tamanho 10, ordenar o subarray com insertion sort(mudar o insertion sort para receber nos parametros o high e low
		if ((hi - lo) <= 10) { //criterio de paragem
			sortdez(a, lo, hi);
			return;
		}

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public static void sortdez(Comparable[] array,int lo, int hi) {
		for (int i = lo; i < hi; i++)
			for (int j = i; j > 0; j--) {
				if (array[j].compareTo(array[j-1]) < 0 ){ //comparacao
					//troca - exchange (...)
					Comparable aux = array[j];
					array[j] = array[j-1];
					array[j - 1] = aux;
				} else {
					break;
				}
			}
	}
   
	
	private static int mediana(Comparable[] a, int lo, int hi) {
	
		int i = lo + 1;
		int j = lo + 3;
		int k = hi - 2; 
		if (i > j && i < k || i < j && i > k )
			return i;
		else
			if (j > i && j < k || j < i && j > k )
				return j;
		
		return k;
		
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		//garantir que a mediana estimada fica em a[lo]
		int m = mediana(a, lo, hi);
		a[m] = lo;
		a[lo] = m;
		
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
public class Insertion {


	public static void sort(Comparable[] array) {
		for (int i = 0; i < array.length; i++)
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
	public static void print(Integer [] array) {
		
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+ " ");
		System.out.println();
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// definir o tamanho do array
		int n = 10;
		// criar um array
		Integer[] array = new Integer[n];

		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * n);

		// imprimir o array antes
		System.out.println("Array antes: ");
		print(array);
		

		// ordenar o array
		sort(array);

		// imprimir o array depois
		System.out.println("Array depois: ");
		print(array);

		//print da tabela
		System.out.println("N\t\tT(N)\t\tratio\t\tlg(ratio)");

		double ratio = 1;
		double timee = 0;

		// definir o tamanho do array
		for (int N = 1000; N <= 128000; N *= 2) {

			// criar um array
			Integer[] array1 = new Integer[N];

			for (int i = 0; i < array1.length; i++)
				array1[i] = (int) (Math.random() * N);


			long start = System.currentTimeMillis();

			// ordenar o array
			sort(array1);

			long end = System.currentTimeMillis();

			
			double time = (end - start) / 1000.0;

			ratio = time / timee;

			double lg = (Math.log10(ratio)) / (Math.log10(2));

			System.out.print(N + "\t\t");
			System.out.print(time + "\t\t");
			System.out.print(ratio + "\t\t");
			System.out.print(lg + "\n");

			timee = time;
		}

	}
}
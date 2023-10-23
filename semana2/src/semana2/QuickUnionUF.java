package semana2;

public class QuickUnionUF {

	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	private int root(int i){
		while (i != id[i])
			i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);
		id[rp] = rq;
	}

	public static void main (String [] args) {
		
		System.out.println("N\t\tT(N)\t\tratio\t\tlg(ratio)");
		
		double ratio = 1;
		double timee = 0;
		
		for(int N = 1000;N<=128000;N*=2) {
			
			QuickUnionUF v = new QuickUnionUF(N);
		
			long start = System.currentTimeMillis();
			for(int i=0;i!=N;i++) {
				v.union((int)Math.random()*N,(int)Math.random()*N);
			}
		
			long end = System.currentTimeMillis();
	
			double time = (end - start)/1000.0;
			
			ratio = time / timee;
			
			double lg = (Math.log10(ratio))/(Math.log10(2));
			
			
			System.out.print(N + "\t\t");
			System.out.print(time + "\t\t");
			System.out.print(ratio + "\t\t");
			System.out.print(lg + "\n");	
		
			timee = time;
		}
		System.out.print("10^9" + "\t\t");
		System.out.print(timee*ratio*7812.5);
	}	
	
	
}

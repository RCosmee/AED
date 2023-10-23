package semana1;

import java.util.Scanner;

public class Hello {
	public static void main (String [] args) {
		/*System.out.print("Hello,");
		for(int i=0;i<args.length;i++)
			System.out.print(" " + args[i]);
		System.out.println("!");*/
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduza o seu nome:");
		String line = sc.nextLine();
		System.out.println("Hello, " + line + "!");
		sc.close();
		
		
		
		
	}
}


package semana1;

import java.util.Scanner;

public class Date {

	private int day;
	private int month;
	private int year;
	
	Date(int month, int day, int year) {
		if(!validDate(month,day,year))
			throw new IllegalArgumentException("Invalid date!");
		this.month=month;
		this.day = day;
		this.year=year;
	}
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return year;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	private boolean validDate(int month, int day, int year) {
		if(year <0)
			return false;
		if (month<1 || month >12)
			return false;
		if (day<1||day>daysInMonth(month, year))
			return false;
		return true;
	}
	
	private int daysInMonth(int month, int year) {
		int days=0;
		if (month==1 ||month==3 || month==5 || month==7 ||month==8 ||month==10 ||month==12)
			days = 31;
		if (month==4 ||month==6 || month==9 || month==11 )
			days = 30;
		if ( month ==2 && year%4==0 && year%100 != 0 || year%400 == 0)
			days = 29;
		if (month ==2 && year%4!=0 )
			days = 28;
	return days;
	}
	
	
	
	
	public static void main(String[] args) {
		
		/*if(args.length != 3) {
		System.err.println("Missing data... aborting now");
		System.exit(1);
		}
		System.out.print("A sua data de nascimento é: ");
		
		int month = Integer.parseInt(args[0]);
		int day = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		
		Date date = new Date (month,day,year);
		System.out.println(date);*/

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduza o mês: ");
		int month = sc.nextInt();
		System.out.print("Introduza o dia: ");
		int day = sc.nextInt();
		System.out.print("Introduza o ano: ");
		int year = sc.nextInt();
		sc.close();
		
		Date date = new Date(month, day, year);
		Date date1 = new Date (2,17,2023); 
		
		int a = date.daystoEndYear();
		boolean b = date.before(date1);
		int c = date.dayssinceBeginYear();
		int d = date.daysBetween(date1);
		
		System.out.println("A sua data de nascimento é: " + date);
		System.out.println();
		if (c==1)
			System.out.println("Essa data encontra-se " + c + " dia após o início do ano.");
		else
			System.out.println("Essa data encontra-se " + c + " dias após o início do ano.");
		System.out.println();
		if(a ==1)
			System.out.println("Falta " + a + " dia para o ano acabar após essa data.");
		else
			System.out.println("Faltam " + a + " dias para o ano acabar após essa data.");
		System.out.println();
		if (b)
			System.out.println(date + " encontra-se antes de " + date1 + ".");
		else 
			System.out.println(date + " não se encontra antes de " + date1 + ".");
		System.out.println();
		if (d==0)
			System.out.println(  date + " e " + date1 + " são o mesmo dia!" + ".");
		if(d==1)
			System.out.println("Existe " + d + " dia entre " + date + " e " + date1);
		if (d>1)
			System.out.println("Existem " + d + " dias entre " + date + " e " + date1);
	}

	//exercício 2
	
	boolean before(Date d) {
		if (d.year<year)
			return false;
		if (d.year == year && d.month<month)
			return false;
		if (d.year==year && d.month == month && d.day <= day)
			return false;
		return true;
	}
	
	int daystoEndYear() {
		int days = daysInMonth(month,year) - day ;
		for(int i = month+1; i<=12;i++)
			 days += daysInMonth(i, year);
		return days;
	}
	
	int dayssinceBeginYear() {
		return  dayYear(year) - daystoEndYear();
	}
	
	int dayYear(int year) {
	if (year%4==0 && year%100 != 0 || year%400 == 0)	
		return 366;
	else
		return 365;
	}
	
	int daysBetween(Date d){
		int dias =0;
		
		if (before(d)) {
			dias = daystoEndYear() - d.daystoEndYear();
			for(int i = year;i!=d.year;i++)
				dias += dayYear(i);
			}
		if(!before(d)) {
			dias = d.daystoEndYear() - daystoEndYear();
			for(int i = d.year;i!=year;i++)
				dias += dayYear(i);
			}
	return dias;
		
		
	}

}




public class TestCalculator {
	
	public static void main (String args[]) {
		
		Calculator  cal = new Calculator();
		int a=3,b=4;
		
		
		System.out.println("First Input value is " + a);
		System.out.println("Second Input value is " + b);
		System.out.println("Callig add");
		System.out.println("Result is "+cal.add(a, b));
			
	}
	
}
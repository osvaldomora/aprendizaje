package osvaldo.morales.company.demo.java8.metodoreferenciado.test;

class StaticMethodReference {
	public static void main(String[] args) {
		/*
		  Runnable r = () -> { for (int i = 0; i <= 10; i++) {
		  System.out.println("Child Thread"); } };
		  
		   Thread t = new Thread(r); t.start();
		  for (int i = 0; i <= 10; i++) { System.out.println("Main Thread"); }
		 */

		Runnable r = StaticMethodReference::m1;
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i <= 10; i++) {
			System.out.println("Main Thread");

		}
	}
	
	public static void m1() { 
		 for(int i=0; i<=10; i++) { 
		 System.out.println("Child Thread"); 
		 } 
	}
}
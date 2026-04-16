package osvaldo.morales.company.demo.java8.metodoreferenciado.test;

interface Interf {
	public void m1(int i);
}

class ReferenceMethod {
	public void m2(int i) {
		System.out.println("From Method Reference:" + i);
	}

	public static void main(String[] args) {
		Interf f = i ->  System.out.println("From Lambda Expression:" + i);
		f.m1(10);
		ReferenceMethod t = new ReferenceMethod();
		Interf i1 = t::m2;
		i1.m1(20);
	}
}
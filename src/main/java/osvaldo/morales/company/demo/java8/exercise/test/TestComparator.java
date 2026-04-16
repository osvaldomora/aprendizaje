package osvaldo.morales.company.demo.java8.exercise.test;


public class TestComparator {

	public static void main(String[] args) {
		User us1= new User(1,"valdo","123");
		User us2= new User(3,"zsva","5231");
		User us3= new User(2,"aagel","987");
		CompareById comp = new CompareById();
//		System.out.println(comp.compare(us1, us2));
		
		System.out.println(us1.compare(us1, us2));
		
	}

}

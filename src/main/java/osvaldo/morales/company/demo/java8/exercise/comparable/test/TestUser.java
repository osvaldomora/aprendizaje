package osvaldo.morales.company.demo.java8.exercise.comparable.test;

import java.util.Arrays;
import java.util.List;

public class TestUser {

	public static void main(String[] args) {
		User us1 = new User(1, "valdo", "123");
		User us2 = new User(3, "osva", "5231");
		User us3 = new User(2, "kagel", "987");


		
		List<User> users= Arrays.asList(us1,us2,us3);
		
		users.stream().sorted().forEach(us->System.out.println(us));

		System.out.println(us1.compareTo(us3));

		System.out.println("ordering by id");
	/*	users.stream().sorted(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stubs
				return o1.getUserId()-o2.getUserId();
			}
			
		}).forEach(us->System.out.println(us));
*/
		users.stream().sorted((o1,o2)->o1.getUserId()-o2.getUserId()).forEach(x->System.out.println(x));
		
	}

}

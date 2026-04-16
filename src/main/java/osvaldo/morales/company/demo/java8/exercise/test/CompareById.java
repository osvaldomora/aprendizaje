package osvaldo.morales.company.demo.java8.exercise.test;

import java.util.Comparator;

public class CompareById  implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return o1.getUserId()-o2.getUserId();
	}

}

package osvaldo.morales.company.demo.java8.finterfaces.bifunction.apply;

public class TestBifunction {

	public static void main(String[] args) {
		Calculadora cal = new Calculadora();
//		BiFunction<Integer, Integer, String> biF;
		String sum = cal.calc((i, j) -> ":" + (i + j), 1, 2);
		System.out.println(sum);

	}

}

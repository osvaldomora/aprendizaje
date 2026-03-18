package osvaldo.morales.company.demo.animals;

import java.util.List;

public class Problem {
    public static void main(String args[]){
      List<Double> listNumber= List.of(120.5,-50.0,300.0,0.0,450.75);
        double validSum=0.0;
        for (Object alias:listNumber) {
            if((double)alias<=0.0){
                try {
                    throw new InvalidOrderAmountException();
                }catch (InvalidOrderAmountException e){
                    System.out.println("dato Invalido");
                }
            }else {
            System.out.println("valid amount"+alias);
            validSum=validSum+(double) alias;}
        }
        System.out.println(validSum);

    }
}

package osvaldo.morales.company.demo.animals;

public class InvalidOrderAmountException extends RuntimeException {

    public void invalidOrderAmountException(){
        throw new RuntimeException("Invalid order");
    }
}

package osvaldo.morales.company.demo.chainresponsibility;

public class CEO extends Approver {

    @Override
    public void approve(PurchaseRequest request) {

        if(request.getAmount() <= 10000){
            System.out.println("CEO approved: " + request.getAmount());
        }
        else{
            System.out.println("Request requires board approval");
        }

    }

}

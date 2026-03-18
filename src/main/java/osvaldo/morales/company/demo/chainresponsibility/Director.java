package osvaldo.morales.company.demo.chainresponsibility;

public class Director extends Approver {

    @Override
    public void approve(PurchaseRequest request) {

        if(request.getAmount() <= 5000){
            System.out.println("Director approved: " + request.getAmount());
        }
        else if(nextApprover != null){
            nextApprover.approve(request);
        }

    }

}

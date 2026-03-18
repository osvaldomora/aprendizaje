package osvaldo.morales.company.demo.chainresponsibility;

public class Manager extends Approver {

    @Override
    public void approve(PurchaseRequest request) {

        if(request.getAmount() <= 1000){
            System.out.println("Manager approved: " + request.getAmount());
        }
        else if(nextApprover != null){
            nextApprover.approve(request);
        }

    }

}
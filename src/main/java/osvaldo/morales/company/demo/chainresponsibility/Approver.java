package osvaldo.morales.company.demo.chainresponsibility;

public abstract class Approver {

    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(PurchaseRequest request);
}

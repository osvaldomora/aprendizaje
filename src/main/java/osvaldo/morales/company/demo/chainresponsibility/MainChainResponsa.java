package osvaldo.morales.company.demo.chainresponsibility;

public class MainChainResponsa {
    public static void main(String[] args) {

        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        PurchaseRequest request1 = new PurchaseRequest(800);
        PurchaseRequest request2 = new PurchaseRequest(3000);
        PurchaseRequest request3 = new PurchaseRequest(9000);

        manager.approve(request1);
        manager.approve(request2);
        manager.approve(request3);

    }
}

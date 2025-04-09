package practical11;

public class UPIPayment extends OnlinePayment implements Payment {

    @Override
    public void makePayment() {
        System.out.println("UPI payment");
    }
    
}

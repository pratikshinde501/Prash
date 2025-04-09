package practical11;

public class OnlinePayment implements Payment{
    
    public static void main(String[] args) {
        System.out.println("Welcome to the payment system");
        OnlinePayment o=new OnlinePayment();
        o.makePayment();
        OnlinePayment o1=new UPIPayment();
        o1.makePayment();
        OnlinePayment o2=new NetBanking();
        o2.makePayment();
    }

    @Override
    public void makePayment() {
        System.out.println("Base class...");
    }
    
}

package practical11;

public class NetBanking extends OnlinePayment implements Payment {

    @Override
    public void makePayment() {
        System.out.print("Netbanking");
    }
    
}
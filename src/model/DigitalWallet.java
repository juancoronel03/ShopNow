package model;

public class DigitalWallet extends PaymentMethod {
    private String walletId;

    public DigitalWallet(String ownerName, double amount, String walletId) {
        super(ownerName, amount);
        this.walletId = walletId;
    }

    @Override
    public void PaymentProcess() {
        System.out.println("Pago realizado con billetera digital con ID: " + walletId);
    }
  

    
}

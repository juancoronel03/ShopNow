package model;

public class Card extends PaymentMethod {
     private String cardNumber;
    private String expirationDate;
    private String cvv;
    
    public Card (String ownerName, double amount, String cardNumber, String expirationDate, String cvv) {
        super(ownerName, amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public void PaymentProcess() {
        System.out.println("Pago realizado con tarjeta terminada en ultimos 4 dígitos: " + cardNumber.substring(cardNumber.length() - 4));
    }
}

    

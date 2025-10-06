package model;

public class BankTransfer extends PaymentMethod {
    private String bankName;
    private String accountNumber;

    public BankTransfer(String ownerName, double amount, String bankName, String accountNumber) {
        super(ownerName, amount);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void PaymentProcess() {
        System.out.println("Pago realizado con transferencia bancaria: " + bankName + " con número de cuenta: " + accountNumber);
    }
    
}

package model;

public abstract class PaymentMethod {
      private String ownerName;
      private double amount;


      public PaymentMethod(String ownerName, double amount) {
          this.ownerName = ownerName;
          this.amount = amount;
      }

      public abstract void PaymentProcess();
    
    
}

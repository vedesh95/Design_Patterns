package behavioral;

interface Strategy{
    void pay(int amount);
}

class CreditCardStrategy implements Strategy{
    @Override
    public void pay(int amount) {System.out.println("Paid " + amount + " using Credit Card.");}
}

class PayPalStrategy implements Strategy{
    @Override
    public void pay(int amount) {System.out.println("Paid " + amount + " using PayPal.");}
}

class PaymentService{
    private Strategy strategy;
    public PaymentService(Strategy strategy) {this.strategy = strategy;}
    public void setStrategy(Strategy strategy) {this.strategy = strategy;}
    public void pay(int amount) {strategy.pay(amount);}
}
public class StrategyPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CreditCardStrategy());
        paymentService.pay(100);
    }
}

public class BankAccount implements MoneyStorage{

    private double balance;
    private String accountNumber;

    public BankAccount(double startingBalance, String accountNumber){
        this.balance = startingBalance;
        this.accountNumber = accountNumber;

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return String.format("Account #%s", accountNumber);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance = Math.max(0.0, balance + amount);
        return true;
    }

    @Override
    public double withdraw(double amount) {
        if (amount < -25.0) {
            return -25.0;
        }else if(amount > balance){
            return balance;
        }

        double result = Math.min(amount, balance);
        balance -= result;
        return result;
    }
}

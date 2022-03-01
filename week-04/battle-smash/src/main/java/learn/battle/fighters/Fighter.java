package learn.battle.fighters;

public class Fighter {

    private final String name;
    private int balance = 100;
    private String specialAttack = "Ki Blast";

    public Fighter(String name) {
        this.name = name;
    }

    public Fighter(String name, String specialAttack) {
        this.name = name;
        this.specialAttack = specialAttack;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOut() {
        return balance <= 0;
    }

    public void reduceBalance(int amount) {
        balance -= amount;
    }

    public String getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }
}

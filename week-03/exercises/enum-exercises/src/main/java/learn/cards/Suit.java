package learn.cards;

public enum Suit {
    SPADES ("Spades"),
    HEARTS ("Hearts"),
    DIAMONDS ("Diamonds"),
    CLUBS ("Clubs");

    private String name;

    Suit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

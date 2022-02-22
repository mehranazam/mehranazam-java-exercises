package learn.cards;

public class Card {

    private Rank cardRank = Rank.ACE;
    private Suit cardSuit = Suit.SPADES;

    // 1. Add a Suit and Rank field the Card class.
    // 2. Add a constructor that accepts a Suit and Rank and sets the appropriate fields.
    // 3. Add getters for both suit and rank.


    public Card(Rank cardRank, Suit cardSuit){
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public Rank getCardRank() {
        return cardRank;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public String getName() {

        // 4. Complete the getName method.
        // Given a card's suit and rank, getName returns a String in the format:
        // "[rank] of [suit]"

        // Examples:
        // Ace of Clubs
        // 5 of Diamonds
        // King of Hearts
        // 9 of Spades

        // Note: it's unlikely you'll be able to use the enum name directly since enum naming conventions
        // don't match the required output.

//        String cardName = "";
//        switch(cardRank){
//            case ACE:
//                cardName = "Ace";
//                break;
//            case TWO:
//                cardName = "Two";
//                break;
//        }


        return cardRank.getName() + " of " + cardSuit.getName();
    }
}

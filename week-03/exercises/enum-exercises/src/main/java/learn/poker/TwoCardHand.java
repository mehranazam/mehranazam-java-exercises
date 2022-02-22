package learn.poker;

import learn.cards.Card;
import learn.cards.Rank;

public class TwoCardHand implements Comparable<TwoCardHand> {

    private final Card one;
    private final Card two;

    public TwoCardHand(Card one, Card two) {
        this.one = one;
        this.two = two;
    }

    public Card getOne() {
        return one;
    }

    public Card getTwo() {
        return two;
    }

    @Override
    public int compareTo(TwoCardHand that) {

        //compareTo semantics

        /*
        if "this" should come "before" the other object (that), output a negative
        if "that" should before "this", output a positive,
        otherwise it's a tie and we'll output zero
         */


        // 1. Complete the compareTo method.
        // If the current TwoCardHand(`this`) has a lower score than the TwoCardHand parameter, compareTo returns
        // an int less than 0.
        // If `this` has a higher score than the TwoCardHand parameter, compareTo returns an int greater than 0.
        // If `this` and the TwoCardHand parameter have the same score, compareTo returns 0.
        // See Exercise04.md for scoring rules.

        /*
        pairs win over non-pairs                            KK vs AK    KK wins
        pairs of higher rank win over pairs of lower rank   AA vs KK    AA wins
        for non-pairs
        Compare the highest card in each hand               AK vs KQ    AK wins
        if THOSE are the same, then compare the 2nd card    AK vs AQ    AK wins
         */


        boolean thisPair = this.one.getCardRank() == this.two.getCardRank();

        boolean thatPair = that.one.getCardRank() == that.two.getCardRank();

        if(thisPair && !thatPair){
            return 1;
        }

        if(thatPair && !thisPair){
            return -1;
        }

        //either both hands are pairs, or neither is a pair
        //that means either both thisPair and thatPair are true, or they're both false




        //need to see which case we're in because the logic is different



        if(thisPair){
            // both hands are pairs
            int thisRankValue = this.one.getCardRank().getRankValue();
            int thatRankValue = that.one.getCardRank().getRankValue();


            /*
            if this "wins" we want to output a positive value
            if that "wins" we want to output a negative value
            if they're the same we want to output 0
             */

            return thisRankValue - thatRankValue;
        }
            //at this point we know that neither hand is a pair
        int thisHighVal = this.one.getCardRank().getRankValue();
        int thisLowVal = this.two.getCardRank().getRankValue();
        if(thisHighVal < thisLowVal){
            //time for swap
            int swap = thisHighVal;
            thisHighVal = thisLowVal;
            thisLowVal = swap;
        }

        int thatHighVal = that.one.getCardRank().getRankValue();
        int thatLowVal = that.two.getCardRank().getRankValue();





        if(thatHighVal < thatLowVal){
            //time for swap
            int swap = thisHighVal;
            thisHighVal = thisLowVal;
            thisLowVal = swap;
        }
//        if(thisHighVal > thatHighVal){
//              return thisHighVal - thatHighVal;
//        }
//        if(thisHighVal < thatHighVal){
//            return thatHighVal - thisHighVal;
//        }
        if(thisHighVal != thatHighVal){
            return thisHighVal - thatHighVal;
        }

        /*
        at this point we know the high card of each hand is the same
        so we'll output the result of comparing the low cards
         */


        return 0;
    }
}

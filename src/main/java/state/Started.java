package state;

import domain.CardHand;

public abstract class Started implements State {
    protected final CardHand cardHand;

    public Started(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    public static Started start(CardHand cardHand) {
        if (cardHand.isBlackJack()) {
            return new BlackJack(cardHand);
        }
        return new Hit(cardHand);
    }

    public CardHand cardHand() {
        return this.cardHand;
    }
}

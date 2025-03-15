package state;

import domain.CardHand;
import domain.deck.Card;

public final class Hit extends Running {
    public Hit(CardHand cardHand) {
        super(cardHand);
    }

    @Override
    public State draw(Card card) {
        this.cardHand.add(card);
        if (cardHand().isBust()) {
            return new Bust(cardHand);
        }
        return this;
    }

    @Override
    public State stay() {
        return new Stay(cardHand);
    }
}

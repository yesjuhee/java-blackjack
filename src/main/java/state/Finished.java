package state;

import domain.CardHand;
import domain.deck.Card;

public abstract class Finished extends Started {
    public Finished(CardHand cardHand) {
        super(cardHand);
    }

    public abstract double earningRate();

    public int profit(final int bettingAmount) {
        return (int) (bettingAmount * earningRate());
    }

    @Override
    public State draw(Card card) {
        throw new IllegalArgumentException();
    }

    @Override
    public State stay() {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

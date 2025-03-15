package state;

import domain.CardHand;

public abstract class Running extends Started {
    public Running(CardHand cardHand) {
        super(cardHand);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public int profit(final int battingAmount) {
        throw new IllegalArgumentException();
    }
}

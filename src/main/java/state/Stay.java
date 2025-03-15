package state;

import domain.CardHand;

public final class Stay extends Finished {
    public Stay(CardHand cardHand) {
        super(cardHand);
    }

    @Override
    public double earningRate() {
        return 1;
    }
}

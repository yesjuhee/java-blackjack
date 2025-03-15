package state;

import domain.CardHand;

public final class Bust extends Finished {
    public Bust(CardHand cardHand) {
        super(cardHand);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}

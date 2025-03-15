package state;

import domain.CardHand;

public final class BlackJack extends Finished {
    public BlackJack(CardHand cardHand) {
        super(cardHand);
    }

    @Override
    public double earningRate() {
        return 1.5;
    }
}

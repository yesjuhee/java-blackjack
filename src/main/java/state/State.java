package state;

import domain.CardHand;
import domain.deck.Card;

public interface State {
    State draw(final Card card);

    State stay();

    boolean isFinished();

    CardHand cardHand();

    int profit(final int bettingAmount);
}

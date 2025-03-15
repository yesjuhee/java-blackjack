package domain;

import domain.deck.Card;
import java.util.Set;

public abstract class State {
    protected CardHand cardHand = new CardHand(null);

    public static State start(
            final Card card1,
            final Card card2
    ) {
        Start state = new Start(card1, card2);
        if (state.isBlackJack()) {
            return state.toBlackjack();
        }
        return new Hit(new CardHand(Set.of(card1, card2)));
    }

    protected State toBlackjack() {
        return new Blackjack(cardHand);
    }

    public State(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    public abstract State addCard(Card card);

    public abstract State stay();

    public abstract double calculateProfit();

    public abstract boolean isFinished();

    static class Start extends State {
        public Start(Card card1, Card card2) {
            super(new CardHand(Set.of(card1, card2)));
        }

        public State addCard(Card card) {
            throw new IllegalArgumentException();
        }

        public State stay() {
            throw new IllegalArgumentException();
        }

        public double calculateProfit() {
            throw new IllegalArgumentException();
        }

        private boolean isBlackJack() {
            return isMaximumScore() && cardHand.size() == 2;
        }

        protected boolean isMaximumScore() {
            return cardHand.calculateScore().equals(GameScore.BLACKJACK_SCORE);
        }

        @Override
        public boolean isFinished() {
            return false;
        }
    }

    static class Blackjack extends State {
        public Blackjack(CardHand cardHand) {
            super(cardHand);
        }

        public State addCard(Card card) {
            throw new IllegalArgumentException();
        }

        public State stay() {
            throw new IllegalArgumentException();
        }

        public double calculateProfit() {
            return 1.5;
        }

        @Override
        public boolean isFinished() {
            return true;
        }
    }

    static class Hit extends State {
        public Hit(CardHand cardHand) {
            super(cardHand);
        }

        public State addCard(Card card) {
            this.cardHand.add(card);
            if (isBust()) {
                return new Bust(this.cardHand);
            }
            return this;
        }

        public State stay() {
            return new Stay(cardHand);
        }

        private boolean isBust() {
            return cardHand.calculateScore().isGreaterThan(GameScore.BLACKJACK_SCORE);
        }

        public double calculateProfit() {
            throw new IllegalArgumentException();
        }

        @Override
        public boolean isFinished() {
            return false;
        }
    }

    static class Bust extends State {
        public Bust(CardHand cardHand) {
            super(cardHand);
        }

        public State addCard(Card card) {
            throw new IllegalArgumentException();
        }

        public State stay() {
            throw new IllegalArgumentException();
        }

        public double calculateProfit() {
            return 0;
        }

        @Override
        public boolean isFinished() {
            return true;
        }
    }

    static class Stay extends State {
        public Stay(CardHand cardHand) {
            super(cardHand);
        }

        public State addCard(Card card) {
            throw new IllegalArgumentException();
        }

        public State stay() {
            throw new IllegalArgumentException();
        }

        public double calculateProfit() {
            return 1;
        }

        @Override
        public boolean isFinished() {
            return true;
        }
    }
}

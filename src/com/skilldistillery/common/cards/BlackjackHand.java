package com.skilldistillery.common.cards;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		cards = super.cards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackHand [cards=");
		builder.append(cards);
		builder.append(", getHandValue()=");
		builder.append(getHandValue());
		builder.append(", isBlackjack()=");
		builder.append(isBlackjack());
		builder.append(", isBust()=");
		builder.append(isBust());
		builder.append("]");
		return builder.toString();
	}

	public int getHandValue() {
		int result = 0;

		for (Card card : cards) {
			result += card.getValue();
		}
		return result;
	}

	public boolean isBlackjack() {
		int result = 0;
		for (Card card : cards) {
			result += card.getValue();
		}
		if (result == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		int result = 0;
		for (Card card : cards) {
			result += card.getValue();
		}
		if (result > 21) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}

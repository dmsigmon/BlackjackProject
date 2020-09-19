package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
		
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue();
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}
	
	

	
}

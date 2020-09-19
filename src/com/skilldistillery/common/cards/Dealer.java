package com.skilldistillery.common.cards;

public class Dealer extends Player {
	private Deck gameDeck = new Deck();
	
	
	public Card deal() {
		Card card = gameDeck.dealCard();
		return card;
	}
	
	public boolean hit() {
		if (hand.getHandValue() < 17 ) {
			return true;
		}
		return false;
	}
	
	public void shuffle() {
		gameDeck.shuffle();
	}
	
	

	
}

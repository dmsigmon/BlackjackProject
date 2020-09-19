package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Player {
	protected Hand hand = new BlackjackHand();
	
	public boolean hit(Scanner kb) {
		System.out.println("Would you like to Hit? [Y/N]");
		if(kb.nextLine().equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}
	
	public Hand getHand() {
		return hand;
	}


	public void addCard(Card c) {
		hand.addCard(c);
	}

}

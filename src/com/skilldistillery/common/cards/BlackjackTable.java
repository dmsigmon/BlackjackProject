package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackTable {

	public static void main(String[] args) {
		BlackjackTable bjt = new BlackjackTable();

		bjt.playGame();
//		deals card to dealer face down 
//		deals card to player face up 
//		deals card to dealer face up (add value to hand)
//		ask if player to hit or stand
//		if hit dealer deals card to player face up (add value to hand)
//		if player stands with out busting then add dealers hidden card value 
//		if dealer hand value is less than 17 must deal another card to dealer hand and add value
//		if dealer value between 17 and 21 and higher than player then dealer wins
//		move this stuff into methods from main 
	}

	public void playGame() {
		// do other methods to clean code
		Scanner kb = new Scanner(System.in);

		Dealer dealer = new Dealer();
		Player player = new Player();
		dealer.shuffle();

		player.addCard(dealer.deal());
		System.out.println("Player has: " + player.getHand());

		dealer.addCard(dealer.deal());

		player.addCard(dealer.deal());
		System.out.println("Player has: " + player.getHand());

		Card card = dealer.deal();
		dealer.addCard(card);
		System.out.println("Dealer has:" + card);

		if (player.getHand().getHandValue() == 21) {
			System.out.println();
			System.out.println("BLACKJACK!!!! YOU WIN!!!");
		} else {

			while (player.hit(kb)) {
				player.addCard(dealer.deal());
				System.out.println("Player has: " + player.getHand());
				if (player.getHand().getHandValue() > 21) {
					System.out.println();
					System.out.println("Sorry you lost");
					break;
				}
			}
//			dealer.getHand().getHandValue() < 17
//			&& (dealer.getHand().getHandValue() < player.getHand().getHandValue())
			while (dealer.hit()) {
				if (player.getHand().getHandValue() == 21) {
					break;
				}
				dealer.addCard(dealer.deal());
			}
			System.out.println("Dealer has: " + dealer.getHand());

			if (dealer.getHand().getHandValue() > player.getHand().getHandValue()
					&& (dealer.getHand().getHandValue() <= 21)) {
				System.out.println("YOU LOST BUDDY ");
			} else if (dealer.getHand().getHandValue() > 21) {
				System.out.println("DEALER BUSTED YOU WIN!!!");
			} else if ((dealer.getHand().getHandValue() < player.getHand().getHandValue())
					&& player.getHand().getHandValue() <= 21) {
				System.out.println("YOU WON!!!");
			} else if (dealer.getHand().getHandValue() == player.getHand().getHandValue()
					&& player.getHand().getHandValue() <= 21 && dealer.getHand().getHandValue() <= 21) {
				System.out.println("DRAW");
			}
		}
	}

}

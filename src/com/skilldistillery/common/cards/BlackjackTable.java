package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackTable {
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BlackjackTable bjt = new BlackjackTable();

		bjt.playGame();
	}

	public void playGame() {
		Scanner kb = new Scanner(System.in);

		dealFirstFourCards();

		if (player.getHand().getHandValue() == 21) {
			System.out.println();
			System.out.println("BLACKJACK!!!! YOU WIN!!!");
		} else {
			playerTurnToHit(kb);
			dealerTurnToHit(kb);
		}
		determineWinner();

	}

	private void determineWinner() {
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

	private void dealerTurnToHit(Scanner kb) {
		while (dealer.hit()) {
			if (player.getHand().getHandValue() == 21) {
				break;
			}
			dealer.addCard(dealer.deal());
		}
		System.out.println("Dealer has: " + dealer.getHand());
	}

	public void dealFirstFourCards() {
		dealer.shuffle();

		player.addCard(dealer.deal());
		System.out.println("Player has: " + player.getHand());

		dealer.addCard(dealer.deal());

		player.addCard(dealer.deal());
		System.out.println("Player has: " + player.getHand());

		Card card = dealer.deal();
		dealer.addCard(card);
		System.out.println("Dealer has:" + card);

	}

	public void playerTurnToHit(Scanner kb) {
		while (player.hit(kb)) {
			player.addCard(dealer.deal());
			System.out.println("Player has: " + player.getHand());
			if (player.getHand().getHandValue() > 21) {
				System.out.println();
				System.out.println("Sorry you lost");
				break;
			}
		}
	}
}

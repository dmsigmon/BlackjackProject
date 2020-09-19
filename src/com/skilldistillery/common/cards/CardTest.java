package com.skilldistillery.common.cards;

import java.util.Scanner;

public class CardTest {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();

		Scanner kb = new Scanner(System.in);
		System.out.println("How many cards?");

		try {
			int num = kb.nextInt();
			if (num > deck.checkDeckSize()) {
				System.err.println("too Many cards");
			} else {
				int value = 0;
				for (int i = 0; i < num; i++) {
					Card c = deck.dealCard();
					value += c.getValue();
					System.out.println(c);
				}
				System.out.println("Your value is " + value);
			}
		} catch (Exception e) {
			System.err.println("Please enter a number");
		}
	}

}

package com.pluralsight;

import java.util.Scanner;

public class CardApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt users for names
        System.out.println("First player name: ");
        String name1 = scanner.nextLine();
        System.out.println("Second player name: ");
        String name2 = scanner.nextLine();

        // Create the deck
        Deck deck = new Deck();

        // Create players
        Player player1 = new Player(name1,new Hand());
        Player player2 = new Player(name2,new Hand());

        // Get hands
        Hand player1Hand = player1.getHand();
        Hand player2Hand = player1.getHand();

        // Deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            // Get card
            Card card1 = deck.deal();

            // Shuffle the deck
            deck.shuffle();

            // Get card
            Card card2 = deck.deal();

            player1Hand.deal(card1);
            player2Hand.deal(card2);
        }

        // Flip the cards and calculate winner
        System.out.println("[" + player1.getName() + "]\n" + "Hand worth: " + player1Hand.getValue());
        System.out.println("[" + player2.getName() + "]\n" + "Hand worth: " + player2Hand.getValue());

        //print out the value of all the cards in the hand
        //System.out.println("This hand is worth " + hand1.getValue());
    }

}
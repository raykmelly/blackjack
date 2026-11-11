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
        Hand player2Hand = player2.getHand();

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

        // Flip the cards and display amount
        System.out.println();
        System.out.println("[" + player1.getName() + "]\n" + "Hand worth: " + player1Hand.getValue());
        System.out.println("[" + player2.getName() + "]\n" + "Hand worth: " + player2Hand.getValue());
        System.out.println();


        // Display the winner
        int score1 = player1Hand.getValue();
        int score2 = player2Hand.getValue();
        boolean bust1 = score1 > 21;
        boolean bust2 = score2 > 21;

        if (bust1 && bust2) {
            // Both players have cards above 21 in value
            // Neither win
            System.out.println("-> Neither player won! Both over 21 points!");
        } else if (bust1) {
            // Player 1 is above 21 in value
            // Winner is player 2
            System.out.printf(
                    "-> Winner is [%s] with: %d points!%n",
                    player2.getName(), score2
            );
        } else if (bust2) {
            // Player 2 is above 21 in value
            // Winner is player 1
            System.out.printf(
                    "-> Winner is [%s] with: %d points!%n",
                    player1.getName(), score1
            );
        } else if (score1 > score2) {
            // Both players have cards at or under 21 in value
            // Winner is player 1
            System.out.printf(
                    "-> Winner is [%s] with: %d points!%n",
                    player1.getName(), score1
            );
        } else if (score2 > score1) {
            // Both players have cards at or under 21 in value
            // Winner is player 2
            System.out.printf(
                    "-> Winner is [%s] with: %d points!%n",
                    player2.getName(), score2
            );
        } else {
            // Both players have the same value
            // Tie
            System.out.println("-> It's a tie! Both players have " + score1 + " points!");
        }
    }

}
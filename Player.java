/**
* Player.java
*
* @author  Juliana Glodek
* @author Student ID: 2315321
* @author glodek@chapman.edu
* CPSC 231-01 - Prof. Stevens
* Assignment MP3
* @version 1.0
* @since   2020-11-19
*/

import java.util.LinkedList;
import java.util.Random;

/** The Player class is used to create a player in a game, containing methods
* that flip cards from the player's deck, collect and lose cards from their deck,
* and check to see if the player has the full deck in their hand.
*/

public class Player {

  /**A LinkedList of a deck of cards for the player.**/
  public LinkedList<Card> player = new LinkedList<Card>();

  /**A Deck object.**/
  public Deck deck = new Deck();

  /**A Random object.**/
  private Random random = new Random();

  /**The default constructor - populates the player's hand with half
  * the deck of cards.
  */
  public Player() {
    for (int i = 0; i < 26; ++i) {
      Card card = deck.deal();
      player.add(card);
    }
  }

  /** Returns a random card from the player's hand.
  * @return A Card representing a card in the player's hand
  */
  public Card flip(int index) {
    return player.get(index);
  }

  /** Returns the player's LinkedList of cards.
  * @return A LinkedList representing the player's cards
  */
  public LinkedList<Card> getPlayerCards() {
    return player;
  }

  /** Returns the amount of cards the player has.
  * @return An int representing the amount of cards
  */
  public int getDeckSize() {
    return player.size();
  }

  /** Adds a card to the player's hand.
  * @param cardWon Card representing the acquired card
  */
  public void collect(Card cardWon) {
      player.add(random.nextInt(player.size()), cardWon);

  }

  /** Removes a card from the player's hand.
  * @param cardLost Card representing the lost card
  */
  public void lose(Card cardLost) {
      player.remove(cardLost);
  }

  /** Returns a boolean determining if the player possessed the full deck of cards.
  * @return A boolean representing if the player has 52 cards
  */
  public boolean hasWon() {
    return (player.size() == 52);
  }

}

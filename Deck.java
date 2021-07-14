/**
* Deck.java
*
* @author  Juliana Glodek
* @author Student ID: 2315321
* @author glodek@chapman.edu
* CPSC 231-01 - Prof. Stevens
* Assignment MP3
* @version 1.0
* @since   2020-11-19
*/

import java.util.Random;
import java.util.LinkedList;

/** The Deck class is used to create a deck of cards, containing methods
* that deal out the deck and check the size of it.
*/

public class Deck {

  /**A LinkedList of a deck of cards.**/
  public LinkedList<Card> deck = new LinkedList<Card>();

  /**A Random object.**/
  private Random random = new Random();

  /**The default constructor - populates the deck of cards.
  */
  public Deck() {
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 13; ++j) {
        deck.add(new Card(j,i));
      }
    }
  }

  /** Returns a random card from the deck.
  * @return A Card representing a card in the deck
  */
  public Card deal() {
    Card randomCard = deck.get(random.nextInt(deck.size()));
    deck.remove(randomCard);
    return randomCard;
  }

  /** Returns the size of the deck.
  * @return An int representing the deck size
  */
  public int checkSize() {
    return deck.size();
  }

}

/**
* Card.java
*
* @author  Juliana Glodek
* @author Student ID: 2315321
* @author glodek@chapman.edu
* CPSC 231-01 - Prof. Stevens
* Assignment MP3
* @version 1.0
* @since   2020-11-19
*/

/** The Card class is used to populate the Deck class with cards
* that have an assigned value and suit.
*/

public class Card {

  /**A string array of card values.**/
  String[] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

  /**A string array of card suits.**/
  String[] suit = {"Hearts", "Spades", "Clubs", "Diamonds"};

  /**The card value.**/
  private int m_value;

  /**The suit value.**/
  private int m_suit;

  /**The default constructor - sets the value and suit to 0.
  */
  public Card() {
    m_value = 0;
    m_suit = 0;
  }

  /**The overloaded constructor - creates a card of a given value and suit.
  * @param value int representing card value
  * @param suit int representing card suit
  */
  public Card(int value, int suit) {
    m_value = value;
    m_suit = suit;
  }

  /**Sets the card value.
  * @param value The int for card value
  */
  public void setValue(int value) {
    m_value = value;
  }

  /** Returns the card value.
  * @return An int representing the card value
  */
  public int getValue() {
    return m_value;
  }

  /**Sets the card suit.
  * @param suit The int for card suit
  */
  public void setSuit(int suit) {
    m_suit = suit;
  }

  /** Returns the card suit.
  * @return An int representing the card suit
  */
  public int getSuit() {
    return m_suit;
  }

  /**Returns a boolean determining whether two cards are the same.
  * @return A boolean determining whether two cards are equal
  */
  public boolean equals(Card card1, Card card2) {
    return (card1 == card2);
  }

  /** Returns the card.
  * @return A String representing the card suit and value
  */
  public String toString() {
    return value[m_value] + " of " + suit[m_suit];
  }

}

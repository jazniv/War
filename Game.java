/**
* Game.java
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
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/** The Game class is used to run a single game of War with two players, containing a
* play method that runs through the game of War, and a war method that handles a war.
* It also keeps track of the number of battles, wars, and double wars.
*/

public class Game {

  /**The first Player object p1.**/
  public Player p1;

  /**The second Player object p2.**/
  public Player p2;

  /**A LinkedList of p1's current cards in their turn.**/
  public LinkedList<Card> p1Turn = new LinkedList<Card>();

  /**A LinkedList of p2's current cards in their turn.**/
  public LinkedList<Card> p2Turn = new LinkedList<Card>();

  /**An int tracking the number of battles in the game.**/
  public int battle = 0;

  /**An int tracking the number of wars in the game.**/
  public int war = 0;

  /**An int tracking the number of double wars in the game.**/
  public int doubleWar = 0;

  /**The default constructor - assigns p1 and p2 as player objects
  */
  public Game() {
    p1 = new Player();
    p2 = new Player();
  }

  /** The method that runs through the course of the game, running through a
  * loop that follows the rules of War until there is a winner.
  */
  public void play() {

    while (p1.getDeckSize() >= 3 && p2.getDeckSize() >= 3) {
        battle++;

        for (int i = 0; i < 3; ++i) {
          p1Turn.add(p1.flip(i));
        }
        for (int j = 0; j < 3; ++j) {
          p2Turn.add(p2.flip(j));
        }

        WarLogger.getInstance().logBattle(battle,WarLogger.P1,p1Turn.toArray(new Card[3]));
        WarLogger.getInstance().logBattle(battle,WarLogger.P2,p2Turn.toArray(new Card[3]));

        // checking middle card value in player turn ArrayList
        if (p1Turn.get(1).getValue() > p2Turn.get(1).getValue()) {
          WarLogger.getInstance().logBattleOutcome(battle,WarLogger.P1);

          // collecting cards from ArrayList
          p1.getPlayerCards().addAll(p2Turn);

          for (int i = 0; i < 3; ++i) {
            p2.lose(p2Turn.get(i));
          }

          p1Turn.clear();
          p2Turn.clear();

        } else if (p2Turn.get(1).getValue() > p1Turn.get(1).getValue()) {
          WarLogger.getInstance().logBattleOutcome(battle,WarLogger.P2);

          p2.getPlayerCards().addAll(p1Turn);

          for (int i = 0; i < 3; ++i) {
            p1.lose(p1Turn.get(i));
          }
          p1Turn.clear();
          p2Turn.clear();

        } else {
          if (p1.getDeckSize() > 3 && p2.getDeckSize() > 3) {
            war(3);
          } else {
            if (p1.getDeckSize() <= 3) {
              p2.getPlayerCards().addAll(p1.getPlayerCards());
            } else if (p2.getDeckSize() <= 1) {
              p1.getPlayerCards().addAll(p2.getPlayerCards());
            }
          }
          p1Turn.clear();
          p2Turn.clear();
        }

        Collections.shuffle(p1.getPlayerCards());
        Collections.shuffle(p2.getPlayerCards());

      }

    if (p1.getDeckSize() < 3) {
      p2.getPlayerCards().addAll(p1.getPlayerCards());
    } else if (p2.getDeckSize() < 3) {
      p1.getPlayerCards().addAll(p2.getPlayerCards());
    }

  }

  /** The method that handles wars, running through a
  * loop until the war is won.
  * @param cardNum An int representing the index number that the war card is
  */
  public void war(int cardNum) {
    // comparing values of top cards
    int warCard = cardNum;
    war++;

    if (p1.getDeckSize() > cardNum && p2.getDeckSize() > cardNum) {

      p2Turn.add(p2.flip(warCard));
      p1Turn.add(p1.flip(warCard));

      if (p1.flip(warCard).getValue() > p2.flip(warCard).getValue()) {
        WarLogger.getInstance().logWarOutcome(war,WarLogger.P1);
        // collecting all cards from turn
        p1.getPlayerCards().addAll(p2Turn);
        for (int l = 0; l < p2Turn.size(); ++l) {
          p2.lose(p2Turn.get(l));
        }

      } else if (p2.flip(warCard).getValue() > p1.flip(warCard).getValue()) {
        WarLogger.getInstance().logWarOutcome(war,WarLogger.P2);
        // collecting all cards from turn
        p2.getPlayerCards().addAll(p1Turn);
        for (int m = 0; m < p1Turn.size(); ++m) {
          p1.lose(p1Turn.get(m));
        }

      } else {
        doubleWar++;
        war(cardNum+1);
      }
    } else {
      if (p1.getDeckSize() <= 3) {
        p2.getPlayerCards().addAll(p1.getPlayerCards());
      } else if (p2.getDeckSize() <= 3) {
        p1.getPlayerCards().addAll(p2.getPlayerCards());
      }
    }

  }

  /** Returns the total number of battles from the game.
  * @return An int representing the number of battles
  */
  public int getBattle() {
    return battle;
  }

  /** Returns the total number of wars from the game.
  * @return An int representing the number of wars
  */
  public int getWar() {
    return war;
  }

  /** Returns the total number of double wars from the game.
  * @return An int representing the number of double wars
  */
  public int getDoubleWar() {
    return doubleWar;
  }

  /** Returns the p1 Player object.
  * @return A Player object p1
  */
  public Player getp1() {
    return p1;
  }

  /** Returns the p2 Player object.
  * @return A Player object p2
  */
  public Player getp2() {
    return p2;
  }

}

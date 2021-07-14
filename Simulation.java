/**
* Simulation.java
*
* @author  Juliana Glodek
* @author Student ID: 2315321
* @author glodek@chapman.edu
* CPSC 231-01 - Prof. Stevens
* Assignment MP3
* @version 1.0
* @since   2020-11-19
*/

import java.util.ArrayList;

/** The Simulation class is used to run multiple simulated games of War, returning
* information based on the individual games, i.e. average number of battles, wars, etc.
* Takes in amount of War games to simulate through the command line.
*/

public class Simulation {

  /**The number of games to simulate.**/
  public int m_numGames;

  /**A LinkedList of type Game holding each simulated game.**/
  public ArrayList<Game> gameList;

  /**The default constructor - sets number of games to 0 and declares gameList
  * as a new ArrayList.
  */
  public Simulation() {
    m_numGames = 0;
    gameList = new ArrayList<Game>();
  }

  /**The overloaded constructor - sets number of games to 0 and declares gameList
  * as a new ArrayList.
  * @param numGames int representing number of games to simulate
  */
  public Simulation(int numGames) {
    m_numGames = numGames;
    gameList = new ArrayList<Game>();
  }

  /** Populates gameList LinkedList with games, determining winner
  * of each game.
  */
  public void simulate () {
    for (int i = 0; i <= m_numGames; ++i) {
      Game game = new Game();
      game.play();
      if (game.getp1().hasWon() == true) {
        WarLogger.getInstance().logGameOutcome(m_numGames,WarLogger.P1);
      } else if (game.getp2().hasWon() == true){
        WarLogger.getInstance().logGameOutcome(m_numGames,WarLogger.P2);
      }
      gameList.add(game);
    }
  }

  /** Prints a formatted version of all data collected based on the total
  * War games simulated.
  */
  public void report() {
    System.out.println("/////// REPORT ///////");
    System.out.println("Average Number of Battles: " + calculateAvgBattles());
    System.out.println("Average Number of Wars: " + calculateAvgWars());
    System.out.println("Average Number of Double Wars: " + calculateAvgDoubleWars());
    System.out.println("Max Number of Battles: " + calculateMaxBattles());
    System.out.println("Min Number of Battles: " + calculateMinBattles());
    System.out.println("Max Number of Wars: " + calculateMaxWars());
    System.out.println("Min Number of Wars: " + calculateMinWars());
  }

  /** Prints the values of all data collected based on the total War games
  * simulated.
  */
  public void calculate() {
    System.out.println(calculateAvgBattles());
    System.out.println(calculateAvgWars());
    System.out.println(calculateAvgDoubleWars());
    System.out.println(calculateMaxBattles());
    System.out.println(calculateMinBattles());
    System.out.println(calculateMaxWars());
    System.out.println(calculateMinWars());
  }

  /** Returns the average number of battles from the total games.
  * @return An int representing the average number of battles
  */
  public int calculateAvgBattles() {
    int avgBattles = 0;
    for (int j = 0; j < m_numGames; ++j) {
      avgBattles += gameList.get(j).getBattle();
    }
    return avgBattles/m_numGames;
  }

  /** Returns the average number of wars from the total games.
  * @return An int representing the average number of wars
  */
  public int calculateAvgWars() {
    int avgWars = 0;
    for (int k = 0; k < m_numGames; ++k) {
      avgWars += gameList.get(k).getWar();
    }
    return avgWars/m_numGames;
  }

  /** Returns the average number of double wars from the total games.
  * @return An int representing the average number of double wars
  */
  public int calculateAvgDoubleWars() {
    int avgDoubleWars = 0;
    for (int l = 0; l < m_numGames; ++l) {
      avgDoubleWars += gameList.get(l).getDoubleWar();
    }
    return avgDoubleWars/m_numGames;
  }

  /** Returns the maximum number of battles from the total games.
  * @return An int representing the maximum number of battles
  */
  public int calculateMaxBattles() {
    int maxBattles = 0;
    for (int m = 0; m < m_numGames; ++m) {
      if (gameList.get(m).getBattle() > maxBattles) {
        maxBattles = gameList.get(m).getBattle();
      }
    }
    return maxBattles;
  }

  /** Returns the maximum number of wars from the total games.
  * @return An int representing the maximum number of wars
  */
  public int calculateMaxWars() {
    int maxWars = 0;
    for (int n = 0; n < m_numGames; ++n) {
      if (gameList.get(n).getWar() > maxWars) {
        maxWars = gameList.get(n).getWar();
      }
    }
    return maxWars;
  }

  /** Returns the minimum number of battles from the total games.
  * @return An int representing the minimum number of battles
  */
  public int calculateMinBattles() {
    int minBattles = gameList.get(0).getBattle();
    for (int o = 0; o < m_numGames; ++o) {
      if (gameList.get(o).getBattle() < minBattles) {
        minBattles = gameList.get(o).getBattle();
      }
    }
    return minBattles;
  }

  /** Returns the minimum number of wars from the total games.
  * @return An int representing the minimum number of wars
  */
  public int calculateMinWars() {
    int minWars = gameList.get(0).getWar();
    for (int p = 0; p < m_numGames; ++p) {
      if (gameList.get(p).getWar() < minWars) {
        minWars = gameList.get(p).getWar();
      }
    }
    return minWars;
  }

  /** Runs through number of simulated games and returns data based off it.
  * @param args String representing the number of battles to simulate
  */
  public static void main(String[] args) {
    String input = args[0];
    int numGames = Integer.parseInt(input);
    Simulation test = new Simulation(numGames);
    test.simulate();
    test.report();
    WarLogger.getInstance().release();
  }

}

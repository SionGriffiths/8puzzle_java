package mainCode;

import java.util.Comparator;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 09:13
 */
public class H1Comparator implements Comparator<String> {

  /**
   * The board instance holding the goal state of the puzzle
   */
  Board b;

  /**
   * Constructs a H1Comparator, takes a Board instance as parameter so a goal state can be retrieved.
   * @param b the Board instance
   */
  public H1Comparator(Board b){
    this.b = b;
  }

  /**
   * Compares 2 puzzle states based on the number of tiles out of place when compared to the goal state.
   * @param state1 First state to be compared
   * @param state2 Second state to be compared
   * @return an int representing the relative ordering of the 2 parameter states
   */
  @Override
  public int compare(String state1, String state2) {

    if(ham(state1) > ham(state2)){
      return 1;
    }

    if(ham(state1) < ham(state2)){
      return -1;
    }

    return 0;
  }


  /**
   * Method returns number of tiles out of position in current state when compared to the goal state
   * @param state the current state
   * @return the number of tiles out of place
   */
  public int ham(String state){
    String goal = b.getGoalState();
    int count = 0;

    for(int i = 0; i < state.length(); i++){

      if(!(state.charAt(i) == goal.charAt(i))){
        if(!(state.charAt(i) == '0')){
          count++;
        }
      }

    }

    return count;

  }



}

package mainCode;

import java.util.Comparator;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class H1Comparator implements Comparator<State> {

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
  public int compare(State state1, State state2) {

    if(eval(state1) > eval(state2)){
      return 1;
    }

    if(eval(state1) < eval(state2)){
      return -1;
    }

    return 0;
  }


  /**
   * Method returns number of tiles out of position in current state when compared to the goal state
   * @param state the current state
   * @return the number of tiles out of place
   */

  public int ham(State state){
    State goal = b.getGoalState();
    int count = 0;

    for(int i = 0; i < state.getStateString().length(); i++){

      if(!(state.getStateString().charAt(i) == goal.getStateString().charAt(i))){
        if(!(state.getStateString().charAt(i) == '0')){
          count++;
        }
      }

    }

    return count;

  }

  /**
   * The evaluation of a State for this heuristic comparator
   * @param state the State
   * @return the evaluation value, corresponds to h(n)+g(n)
   */
  public int eval(State state){
    return (ham(state)+state.getDepth());
  }

}

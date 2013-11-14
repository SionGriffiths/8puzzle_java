package mainCode;

import java.util.Comparator;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *
 */
public class H2Comparator implements Comparator<State> {

  /**
   * The goal state
   */
  private State goal;

  /**
   * manLookUp - a lookup table for manhattan distance values
   *
   */
  int [][] manLookUp = {
    {0,1,2,1,2,3,2,3,4},
    {1,0,1,2,1,2,3,2,3},
    {2,1,0,3,2,1,4,3,2},
    {1,2,3,0,1,2,1,2,3},
    {2,1,2,1,0,1,2,1,2},
    {3,2,1,2,1,0,3,2,1},
    {2,3,4,1,2,3,0,1,2},
    {3,2,3,2,1,2,1,0,1},
    {4,3,2,3,2,1,2,1,0},
  };

  /**
   * Constructs a H2Comparator. Takes a Board instance as argument so that goal state can be set
   * @param b the Board instance
   */
  public H2Comparator(Board b){

    goal = b.getGoalState();
  }


  /**
   * Compares 2 puzzle states based on the number of moves each value in the state is away from it's goal position
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
   * Method returns a value corresponding to the amount of moves required to reach the goal state
   * from the current State
   * @param state the current State
   * @return value corresponding to the amount of moves required to reach the goal state
   */
  public int calcMan(State state){

    int manDist = 0;

    for (int i = 1; i<state.getStateString().length(); i++){
      manDist += manLookUp[state.getStateString().indexOf(String.valueOf(i))][goal.getStateString().indexOf(String.valueOf(i))];
    }

    return manDist;
  }

  /**
   * The evaluation of a State for this heuristic comparator
   * @param state the State
   * @return the evaluation value, corresponds to h(n)+g(n)
   */
  public int eval(State state){

    return (calcMan(state)+state.getDepth());
  }
}

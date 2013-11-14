package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class Board {


  /**
   * A char array to hold the start state of the puzzle
   */
  private State startState;


  /**
   * A char array to hold the goal state of the puzzle
   */
  private State goalState;


  /**
   * Integer used to limit amount of states printed upon successful completion of a puzzle
   */
  private int printCount = 0;

  /**
   * Constructs a Board instance with a start and goal state
   * @param startString the start state of the puzzle
   * @param goalString the goal state of the puzzle
   */
  public Board(String startString, String goalString){
    startState = new State(null,0, startString);
    goalState = new State(null, 0, goalString);

  }



  /**
   * Method to move the space 'up' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public State moveUp(State parent){
    State child = null;
    if(parent.getZeroIndex() >= 3){
      child = new State(parent ,(parent.getDepth()+1) , (swapChars(parent.getStateString(), ((parent.getZeroIndex())-3))));

    }

    return child;
  }


  /**
   * Method to move the space 'down' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public State moveDown(State parent){
    State child = null;
    if(parent.getZeroIndex() <= 5){
      child = new State(parent ,(parent.getDepth()+1) , (swapChars(parent.getStateString(), ((parent.getZeroIndex())+3))));

    }

    return child;
  }


  /**
   * Method to move the space 'left' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */

  public State moveLeft(State parent){
    State child = null;
    int zeroIndex = parent.getZeroIndex();
    if((zeroIndex != 0) && (zeroIndex != 3) && (zeroIndex != 6)){
      child = new State (parent ,(parent.getDepth()+1) , (swapChars(parent.getStateString(), zeroIndex-1)));

    }

    return child;
  }


  /**
   * Method to move the space 'right' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */

  public State moveRight(State parent){
    State child = null;
    int zeroIndex = parent.getZeroIndex();
    if((zeroIndex != 2) && (zeroIndex != 5) && (zeroIndex != 8)){
      child = new State (parent ,(parent.getDepth()+1) , (swapChars(parent.getStateString(), zeroIndex+1)));

    }

    return child;
  }

  /**
   * Method swaps the 'space' and target character in a puzzle State
   * @param state the puzzle State
   * @param index the index of target character
   * @return the new puzzle state
   */
  private String swapChars(String state, int index){

    char temp = state.charAt(index);
    state = state.replace('0', 'x');
    state = state.replace(temp , '0');
    state = state.replace('x',temp);

    return state;
  }



  /**
   * Method returns the start state
   * @return the start state
   */
  public State getStartState(){
    return startState;
  }


  /**
   * Method returns the goal state
   * @return the goal state
   */
  public State getGoalState(){
    return goalState;
  }

  /**
   * Preorder printout of solution path, from start to goal. Constraint of 200 max states.
   * @param state The state from which to begin printing
   */
  public void outputSolutionPath(State state){

    if(state.getParent() == null){
      System.out.println(state.getStateString()+ " <- Start State");
    }
    else{
      printCount++;
      if(printCount == 200){return;} //prevent stack overflow on printout of large solution path
      outputSolutionPath(state.getParent());
      System.out.println(state.getStateString());
    }

  }
}

package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class Board {




  /**
   * A char array to hold the start state of the puzzle
   */
  private String startState = "";


  /**
   * A char array to hold the goal state of the puzzle
   */
  private String goalState = "";


  /**
   * a char array to hold the current state of the puzzle
   */
  private String currentState = "";


  /**
   * An int used to track the position of the 0 representing the space
   * in each game state
   */
  private int zeroIndex;





  /**
   * Constructs a Board instance with a start and goal state
   * @param startState the start state of the puzzle
   * @param goalState the goal state of the puzzle
   */
  public Board(String startState, String goalState){
    this.startState = startState;
    this.goalState = goalState;
    findZero(startState);
    currentState = startState;
  }


  /**
   * Method used to find the initial index position of the 0 representing the space
   * in the start state of the puzzle
   * @param state the start state of the puzzle
   */
  private void findZero(String state){
    zeroIndex = state.indexOf('0');
  }


  /**
   * Method to move the space 'up' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public String moveUp(String state){
    findZero(state);
    if(zeroIndex >= 3){
      state = swapChars(state, (zeroIndex-3));

    }

    return state;
  }


  /**
   * Method to move the space 'down' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public String moveDown(String state){
    findZero(state);
    if(zeroIndex <= 5){
      state = swapChars(state, (zeroIndex+3));

    }

    return state;
  }


  /**
   * Method to move the space 'left' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */

  public String moveLeft(String state){
    findZero(state);
    if((zeroIndex != 0) && (zeroIndex != 3) && (zeroIndex != 6)){
      state = swapChars(state, (zeroIndex-1));

    }

    return state;
  }


  /**
   * Method to move the space 'right' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */

  public String moveRight(String state){
    findZero(state);
    if((zeroIndex != 2) && (zeroIndex != 5) && (zeroIndex != 8)){
      state = swapChars(state, (zeroIndex+1));

    }

    return state;
  }

  private String swapChars(String state, int index){

    char temp = state.charAt(index);
    state = state.replace('0', 'x');
    state = state.replace(temp , '0');
    state = state.replace('x',temp);

    return state;
  }

  /**
   * Method returns the current state
   * @return  the current state
   */
  public String getCurrentState(){
    return currentState;
  }

  /**
   * Method returns the start state
   * @return the start state
   */
  public String getStartState(){
    return startState;
  }


  /**
   * Method returns the goal state
   * @return the goal state
   */
  public String getGoalState(){
    return goalState;
  }


  /**
   * Method returns position of the 'space' in the current puzzle state
   * @return the position of the 'space' in current state
   */
  public int getZeroIndex(){
    return zeroIndex;
  }


}

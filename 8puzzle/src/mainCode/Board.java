package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class Board {

  private static final char ZERO = '0';
  /**
   * A constant use to control the length of the state arrays
   */
  private static final int STATE_SIZE = 9;

  /**
   * A char array to hold the start state of the puzzle
   */
  private char[] startState = new char[STATE_SIZE];

  /**
   * A char array to hold the goal state of the puzzle
   */
  private char[] goalState = new char[STATE_SIZE];

  /**
   * a char array to hold the current state of the puzzle
   */
  private char[] currentState = new char[STATE_SIZE];

  /**
   * An int used to track the position of the 0 representing the space
   * in each game state
   */
  private int zeroIndex;

  /**
   * A boolean used to control allowed movements of the space
   * in a puzzle state
   */
  private boolean legal = false;

  /**
   * Constructs a Board instance with a start and goal state
   * @param startState the start state of the puzzle
   * @param goalState the goal state of the puzzle
   */
  public Board(char[] startState, char[] goalState){
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
  private void findZero(char[] state){
    for(int i = 0; i < state.length; i++){
      if(state[i] == ZERO){zeroIndex = i;}
    }
  }


  /**
   * Method to move the space 'up' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public boolean moveUp(){
    legal = false;

    if(zeroIndex >= 3){
      currentState[zeroIndex] = currentState[(zeroIndex-3)];
      zeroIndex-=3;
      currentState[zeroIndex] = ZERO;
      legal = true;
    }

    return legal;
  }

  /**
   * Method to move the space 'down' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public boolean moveDown(){
    legal = false;

    if(zeroIndex <= 5){
      currentState[zeroIndex] = currentState[(zeroIndex+3)];
      zeroIndex+=3;
      currentState[zeroIndex] = ZERO;
      legal = true;
    }

    return legal;
  }

  /**
   * Method to move the space 'left' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public boolean moveLeft(){
    legal = false;

    if((zeroIndex != 0)&&(zeroIndex != 3) && (zeroIndex != 6)){
      currentState[zeroIndex] = currentState[(zeroIndex-1)];
      zeroIndex-=1;
      currentState[zeroIndex] = ZERO;
      legal = true;
    }

    return legal;
  }

  /**
   * Method to move the space 'right' in the puzzle
   * With suitable constraint to prevent out-of-bounds
   * @return boolean whether the move meets constraints
   */
  public boolean moveRight(){
    legal = false;

    if((zeroIndex != 2)&&(zeroIndex != 5) && (zeroIndex != 8)){
      currentState[zeroIndex] = currentState[(zeroIndex+1)];
      zeroIndex+=1;
      currentState[zeroIndex] = ZERO;
      legal = true;
    }

    return legal;
  }

  /**
   * Method returns the current state
   * @return  the current state
   */
  public char[] getCurrentState(){
    return currentState;
  }

  /**
   * Method returns position of the 'space' in the current puzzle state
   * @return the position of the 'space' in current state
   */
  public int getZeroIndex(){
    return zeroIndex;
  }


}

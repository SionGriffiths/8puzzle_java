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

  public char[] getCurrentState(){
    return currentState;
  }

  public int getZeroIndex(){
    return zeroIndex;
  }
  //hold an index to 0 position in array - no need to search for it.
  //moving 0 will be a case of board[0index] = board[0index+3], 0index = 0index+3
  //this will swap the value of 0index with 0index+3  (this is an example of moveDown)


  //maybe have a changePlaces method to swap values in 2 array indexes.

}

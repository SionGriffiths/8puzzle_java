package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class State {

  /**
   * Holds the depth of this State in the solution space
   */
  private int depth;

  /**
   * String representing this State
   */
  private String stateString = "";

  /**
   * The parent State of this State
   */
  private State parent;

  /**
   * Constructs a State instance. A parent , depth and String representation are assigned.
   * @param parent the parent State
   * @param depth the depth
   * @param stateString the String representation
   */
  public State(State parent, int depth, String stateString){
    this.parent = parent;
    this.depth = depth;
    this.stateString = stateString;
  }


  /**
   * Returns the depth
   * @return the depth
   */
  public int getDepth(){
    return depth;
  }

  /**
   * Returns the String representation of this State
   * @return the String representation
   */
  public String getStateString(){
    return stateString;
  }

  /**
   * Returns the index of the 'space' in this State
   * @return the index of '0'
   */
  public int getZeroIndex(){
    return stateString.indexOf('0');
  }

  /**
   * Returns the parent of this State
   * @return the parent
   */
  public State getParent(){
    return parent;
  }

  /**
   * Compares states for equality using only their String representation
   * @param o paramater Object
   * @return boolean representing equality
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if(o instanceof State){
      State other = (State) o;
      if (other.stateString.equals(stateString)){
        return true;
      }
    }

    return false;
  }

  /**
   * Generate a hashcode based only on String representation
   * @return the hashcode
   */
  @Override
  public int hashCode() {
    return stateString.hashCode();
  }
}

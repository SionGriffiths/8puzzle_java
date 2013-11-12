package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 10:40
 */
public class State {


  private State parent;
  private int depth;
  private String pState = "";

  public State(State parent, int depth, String pState){
    this.parent = parent;
    this.depth = depth;
    this.pState = pState;
  }

  public State getParent(){
    return parent;
  }

  public int getDepth(){
    return depth;
  }

  public String getpState(){
    return pState;
  }

  public int getZeroIndex(){
    return pState.indexOf('0');
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if(o instanceof State){
      State other = (State) o;
      if (other.pState.equals(pState)){
        return true;
      }
    }

    return false;
  }

  @Override
  public int hashCode() {
    return pState.hashCode();
  }
}

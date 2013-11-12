package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 10:40
 */
public class State {



  private int depth;
  private String pState = "";

  public State( int depth, String pState){

    this.depth = depth;
    this.pState = pState;
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

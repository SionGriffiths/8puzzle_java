package mainCode;

import java.util.Comparator;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 09:25
 */
public class H2Comparator implements Comparator<State> {

  private Board b;
  private State goal;

  /**
   * manLookUp - a lookup table for manhattan distance
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

  public H2Comparator(Board b){
    this.b = b;
    goal = b.getGoalState();
  }


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



  public int calcMan(State state){

    int manDist = 0;
    int h = 0;

    for (int i=1; i<9;i++){
      manDist += manLookUp[state.getpState().indexOf(String.valueOf(i))][goal.getpState().indexOf(String.valueOf(i))];
    }

    return manDist*2;
  }

  public int eval(State state){

    return (calcMan(state)+state.getDepth());
  }
}

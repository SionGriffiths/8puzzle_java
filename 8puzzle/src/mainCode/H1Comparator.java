package mainCode;

import java.util.Comparator;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 09:13
 */
public class H1Comparator implements Comparator<String> {

  Board b;

  public H1Comparator(Board b){
    this.b = b;
  }

  @Override
  public int compare(String state1, String state2) {

    if(ham(state1) > ham(state2)){
      return 1;
    }

    if(ham(state1) < ham(state2)){
      return -1;
    }

    return 0;
  }


  public int ham(String state){
    String goal = b.getGoalState();
    int count = 0;

    for(int i = 0; i < state.length(); i++){

      if(!(state.charAt(i) == goal.charAt(i))){
        if(!(state.charAt(i)=='0')){
          count++;
        }
      }

    }

    return count;

  }


  public int difference(int a, int b){
    return Math.abs(a-b);
  }
}

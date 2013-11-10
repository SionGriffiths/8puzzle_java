package mainCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
*/
public class BFS {

  /**
   * The board instance containing puzzle states
   */
  private Board b;

  /**
   * Queue implementation using LinkedList
   */
  private Queue<String> queue = new LinkedList<String>();

  /**
   * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
   */
  private HashSet<String> open = new HashSet<String>();

  /**
   * Constructs a BFS instance takes the Board as argument so current and goal states can be retrieved
   * @param b the Board instance
   */
  public BFS(Board b){
    this.b = b;
  }

  /**
   * Method to add states to the queue, checks if the state is already explored using the
   * fact a Hashset will not allow duplicate entires
   * @param state the state to be added
   */
  public void add(String state){
    if(!open.contains(state)){
      open.add(state);
      queue.add(state);
    }
  }

  public void runBFS(){
    while(!queue.isEmpty()){
      if(b.moveDown()){
        add(b.getCurrentState());
      }
    }
  }

}

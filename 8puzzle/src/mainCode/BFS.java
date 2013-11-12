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
  private Queue<State> queue = new LinkedList<State>();

  /**
   * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
   */
  private HashSet<State> open = new HashSet<State>();

  int nodeCount = 0;

  /**
   * Constructs a BFS instance takes the Board as argument so current and goal states can be retrieved
   * @param b the Board instance
   */
  public BFS(Board b){
    this.b = b;
    add(b.getStartState());
  }

  /**
   * Method to add states to the queue, checks if the state is already explored using the
   * fact a Hashset will not allow duplicate entires
   * @param state the state to be added
   */
  public void add(State state){
    if(!(state == null)){
      if(!open.contains(state)){
        open.add(state);
        queue.add(state);
        nodeCount++;
      }
    }
  }

  public void runBFS(){

    while(!queue.isEmpty()){

      if(queue.peek().equals(b.getGoalState())){
        System.out.println("Solution found");
        System.out.println("Nodes expanded : " + nodeCount);
        break;
      }

      getChilderen(queue.poll());


    }
  }

  public void getChilderen(State state){
    add(b.moveUp(state));
    add(b.moveDown(state));
    add(b.moveLeft(state));
    add(b.moveRight(state));
  }

}

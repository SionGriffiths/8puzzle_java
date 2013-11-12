package mainCode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *
 */
public class AStar {

  Board b;
  Comparator<State> comparator;
  PriorityQueue<State> queue;
  HashSet<State> open = new HashSet<State>();
  int nodeCount = 0;


  public AStar(Board b){
    this.b = b;
    comparator = new H1Comparator(b);
    queue = new PriorityQueue<State>(10, comparator);
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

  public void runAStar(){

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

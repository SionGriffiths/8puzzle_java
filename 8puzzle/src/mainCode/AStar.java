package mainCode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *
 */
public class AStar {

  /**
   * The board instance
   */
  private Board b;
  /**
   * Comparator used to apply evaluation function to ordering of the priority queue
   */
  private Comparator<State> comparator;
  /**
   * A PriorityQueue, used to hold puzzle states
   */
  private PriorityQueue<State> queue;
  /**
   * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
   */
  private HashSet<State> explored = new HashSet<State>();
  /**
   * nodeCount holds number of expanded nodes
   */
  private int nodeCount = 0;


  /**
   * Constructs and AStar instance. A start state is assigned and a choice of heuristic is passed through.
   * @param b the Board instance containing Start/Goal states
   * @param heuristic a boolean controlling which heuristic to use
   */
  public AStar(Board b, boolean heuristic){
    this.b = b;
    if(heuristic){
      comparator = new H1Comparator(b);
    }
    else{
      comparator = new H2Comparator(b);
    }
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
      if(!explored.contains(state)){
        explored.add(state);
        queue.add(state);
        nodeCount++;
      }
    }
  }

  /**
   * Runs A-Star search from the current start state. Ends if queue is empty or solution is found.
   * Prints out suitable information on completion.
   */
  public void runAStar(){
    long startTime = System.currentTimeMillis();
    while(!queue.isEmpty()){


      if(queue.peek().equals(b.getGoalState())){
        long endTime = System.currentTimeMillis();
        successPrint();
        System.out.println("Runtime : " +(endTime-startTime) + " milliseconds.");
        break;
      }

      getChilderen(queue.poll());


    }
    if(queue.isEmpty()){
      System.out.println("Solution not found");
    }
  }

  /**
   * Method takes a parent State and generates all legal child states, adds them to the lists
   * @param state the parent State
   */
  public void getChilderen(State state){
    add(b.moveUp(state));
    add(b.moveDown(state));
    add(b.moveLeft(state));
    add(b.moveRight(state));
  }

  /**
   * Method prints out relevant information about solution on finding goal state
   */
  public void successPrint(){
    b.outputSolutionPath(queue.peek());
    System.out.println("Solution found : " + queue.peek().getStateString());
    System.out.println("Solution depth : " + queue.peek().getDepth());
    System.out.println("Nodes expanded : " + nodeCount);
  }


}

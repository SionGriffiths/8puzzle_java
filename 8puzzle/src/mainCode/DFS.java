package mainCode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 */
public class DFS {



  /**
   * The board instance containing puzzle states
   */
  private Board b;

  /**
   * A stack used to hold puzzle States
   */
  private Stack<State> stack = new Stack<State>();

  /**
   * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
   */
  private HashSet<State> explored = new HashSet<State>();

  /**
   * nodeCount holds number of expanded nodes
   */
  private int nodeCount = 0;

  /**
   * Constructs a DFS instance takes the Board as argument so current and goal states can be retrieved
   * @param b the Board instance
   */
  public DFS(Board b){
    this.b = b;
    add(b.getStartState());
  }

  /**
   * Method to add states to the stack, checks if the state is already explored using the
   * fact a Hashset will not allow duplicate entires
   * @param state the state to be added
   */
  public void add(State state){
    if(!(state == null)){
      if(!explored.contains(state)){
        explored.add(state);
        stack.push(state);
        nodeCount++;
      }
    }
  }

  /**
   * Runs depth first search from the current start state. Ends if stack is empty or solution is found.
   * Prints out suitable information on completion.
   */
  public void runDFS(){
    long startTime = System.currentTimeMillis();
    while(!stack.isEmpty()){


      if(stack.peek().equals(b.getGoalState())){
        long endTime = System.currentTimeMillis();
        successPrint();
        System.out.println("Runtime : " +(endTime-startTime) + " milliseconds.");
        break;
      }

      getChilderen(stack.pop());


    }
    if(stack.isEmpty()){
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
    b.outputSolutionPath(stack.peek());
    System.out.println("Solution found : " + stack.peek().getStateString());
    System.out.println("Solution depth : " + stack.peek().getDepth());
    System.out.println("Nodes expanded : " + nodeCount);
  }



}

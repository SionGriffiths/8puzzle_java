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
   *
   */
  private Stack<State> stack = new Stack<State>();

  /**
   * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
   */
  private HashSet<State> open = new HashSet<State>();

  int nodeCount = 0;

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
      if(!open.contains(state)){
        open.add(state);
        stack.push(state);
        nodeCount++;
      }
    }
  }

  public void runDFS(){

    while(!stack.isEmpty()){


      if(stack.peek().equals(b.getGoalState())){
        System.out.println("Solution found");
        System.out.println("Nodes expanded : " + nodeCount);
        break;
      }

      getChilderen(stack.pop());


    }
  }

  public void getChilderen(State state){
    add(b.moveUp(state));
    add(b.moveDown(state));
    add(b.moveLeft(state));
    add(b.moveRight(state));
  }



}

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
    private Stack<String> stack = new Stack<String>();

    /**
     * HashSet implementation for the explored list. HashSet chosen to avoid duplicate states being parsed.
     */
    private HashSet<String> open = new HashSet<String>();

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
    public void add(String state){
      if(!open.contains(state)){
        open.add(state);
        stack.push(state);
        nodeCount++;
      }
    }

    public void runDFS(){

      while(!stack.isEmpty()){

        if(stack.peek().equals(b.getGoalState())){
          System.out.println("Solution found");
          System.out.println("Nodes expanded : " + nodeCount);
          break;
        }

        add(b.moveUp(stack.peek()));
        add(b.moveDown(stack.peek()));
        add(b.moveLeft(stack.peek()));
        add(b.moveRight(stack.pop()));

      }
    }




}

package mainCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *
 */
public class AStar {

  Board b;
  Comparator<String> comparator;
  PriorityQueue<String> queue;
  int pathCost = 0;
  int nodeCount = 0;


  public AStar(Board b){
    this.b = b;
    comparator = new H1Comparator(b);
    queue = new PriorityQueue<String>(10, comparator);
  }



}

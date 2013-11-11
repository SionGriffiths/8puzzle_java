package testRuns;

import mainCode.BFS;
import mainCode.Board;
import mainCode.FileParser;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 06/11/13
 *         Time: 16:06
 */
public class BRun {
  public static void main(String[] args) {
    FileParser fp = new FileParser();
    Board b = new Board(fp.parseFile("testStart3.txt"),fp.parseFile("testGoal1.txt"));
    BFS bfs = new BFS(b);
    bfs.runBFS();



    /*
    System.out.println(b.getCurrentState() + " zi = " + b.getZeroIndex() );
    System.out.println(b.moveUp(b.getCurrentState())+ " zi = " + b.getZeroIndex() );

    System.out.println(b.moveDown(b.getCurrentState())+ " zi = " + b.getZeroIndex() );

    System.out.println(b.moveUp(b.getCurrentState())+ " zi = " + b.getZeroIndex() );

    System.out.println(b.moveLeft(b.getCurrentState())+ " zi = " + b.getZeroIndex() );

    System.out.println(b.moveUp(b.getCurrentState()) + " zi = " + b.getZeroIndex() );
  */
  }
}

package testRuns;

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
    Board b = new Board(fp.parseFile("testStart1.txt"),fp.parseFile("testGoal1.txt"));

    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveRight();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveRight();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveLeft();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveRight();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));

  }
}

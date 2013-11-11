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
    Board b = new Board(("123456780"),fp.parseFile("testGoal1.txt"));

    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveUp();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveUp();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveUp();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));
    b.moveUp();
    System.out.println(b.getZeroIndex());
    System.out.println(new String(b.getCurrentState()));

  }
}

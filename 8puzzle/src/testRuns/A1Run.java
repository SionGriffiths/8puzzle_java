package testRuns;

import mainCode.AStar;
import mainCode.Board;
import mainCode.FileParser;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 09:43
 */
public class A1Run {

  public static void main(String[] args) {
    FileParser fp = new FileParser();
    Board b = new Board(fp.parseFile("testStart4.txt"),fp.parseFile("testGoal1.txt"));
    AStar a = new AStar(b, false);
    a.runAStar();
  }
}

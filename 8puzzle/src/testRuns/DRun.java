package testRuns;

import mainCode.Board;
import mainCode.DFS;
import mainCode.FileParser;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 11/11/13
 *         Time: 15:23
 */
public class DRun {
  public static void main(String[] args) {
    FileParser fp = new FileParser();
    Board b = new Board(fp.parseFile("testStart3.txt"),fp.parseFile("testGoal3.txt"));
    DFS dfs = new DFS(b);
    dfs.runDFS();

  }
}

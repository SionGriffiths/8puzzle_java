package testRuns;

import mainCode.FileParser;

/**
 * @author Sion Griffiths - sig2@aber.ac.uk
 *         Date: 05/11/13
 *         Time: 21:20
 */
public class FPRun {
  public static void main(String[] args) {
    FileParser fp = new FileParser();
    fp.setFile("testStart1.txt");
    fp.parseFile();
  }
}

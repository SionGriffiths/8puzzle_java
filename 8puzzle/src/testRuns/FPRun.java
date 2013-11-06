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
    char[] test = fp.parseFile("testStart1.txt");
     //String out = new String(test);
    System.out.println(new String(test) + "\n" + test.length);

  }
}

package mainCode;
import java.io.*;

/**
 * @author Sion Griffiths - sig2@aber.ac.uk
 * Date: 05/11/13
 * Time: 20:35
 */
public class FileParser {

  /**The File instance to hold a reference to a file */
  private File file;

  /**A Buffered reader to facilitate reading of the file*/
  private BufferedReader bRead;

  /**A String to hold each line of the file, initialised to empty*/
  private String line ="";

  /**A String to hold an entire board state as read from file, initialised to empty*/
  private String state = "";

  /**Constructs a FileParser*/
  public FileParser(){

  }
  /**
   * Reads the passed in file line by line into a string.
   * Commas are stripped out of the string before it is returned
   * @param fileName the name of the file to be read
   * @return the String representing a board state
   */
  public char[] parseFile(String  fileName){


    try{
      file = new File(fileName);
      bRead = new BufferedReader(new FileReader(file));

      while((line = bRead.readLine()) != null){
        state += line;
      }


      bRead.close();

    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
    catch(IOException e){
      e.printStackTrace();
    }

    state = state.replaceAll("," , "");

    return state.toCharArray();
  }

}

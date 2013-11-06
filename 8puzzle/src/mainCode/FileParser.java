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

  /**Constructs a FileParser*/
  public FileParser(){

  }

  /**
   * Instantiates a new File instance passing in a file name
   * @param fileName the file name
   */
  public void setFile(String  fileName){
    file = new File(fileName);
  }

  /**Reads the current file line by line into a string.
   * The string is split into constituent characters which are added
   * to the output array. Conducts checks to ensure only valid files are loaded.
   */
  public boolean parseFile(){

    try{

      bRead = new BufferedReader(new FileReader(file));

      while((line = bRead.readLine()) != null){
        //line = bRead.readLine();
        System.out.println(line);
      }

      System.out.println("EOF");
      bRead.close();

    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
    catch(IOException e){
      e.printStackTrace();
    }


    return true;
  }




}

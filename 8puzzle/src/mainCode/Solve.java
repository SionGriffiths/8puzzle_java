package mainCode;

/**
 * @author Siôn Griffiths - sig2@aber.ac.uk
 *         Date: 12/11/13
 *         Time: 14:22
 */
public class Solve {

  public static void main(String[] args) {
    Board b = null;
    FileParser fp = new FileParser();
    if(args.length >= 3){
      b = new Board(fp.parseFile(args[0]) , fp.parseFile(args[1]));

      if(args[2].equals("bfs")){
        BFS bfs = new BFS(b);
        bfs.runBFS();
      }
      else if(args[2].equals("dfs")){
        DFS dfs = new DFS(b);
        dfs.runDFS();
      }
      else if(args[2].equals("astar1")){
        b.setHeuristic(1);
        AStar a = new AStar(b);
        a.runAStar();
      }
      else if(args[2].equals("astar2")){
        b.setHeuristic(2);
        AStar a = new AStar(b);
        a.runAStar();
      }
    }
    else{
      System.out.println("Parameters not recognised" + "\n" + "Please use the format specified in the assignment PDF");
    }
  }
}

/*
A program for checking the speed of LinkedLists
vs. ArrayLists at different operations
*/

public class ListSpeedTest{
   public static void main(String[] args){
      //Toggle which type of list to use
      AList l = new AList();
      //LList l = new LList();
      
      //create a stopwatch for timing
      StopwatchCPU timer = new StopwatchCPU();
      double start = timer.elapsedTime();
      
      //Load the commands
      while(StdIn.isEmpty() == false){
         //read in each command
         String line = StdIn.readLine();
         //spliit the command into tokens
         String[] tokens = line.split(" ");
         String command = tokens[0];
         //determine which command to do
         if(command.equals("ADD")){
            //Integer i = Integer.parseInt(tokens[1]);
            String s = tokens[1];
            l.add(s);
         }
         else if(command.equals("GET")){
            Integer i = Integer.parseInt(tokens[1]);
            l.get(i);
         }
         else if(command.equals("REM")){
            int i = Integer.parseInt(tokens[1]);
            l.remove(i);
         }
         else if(command.equals("INS")){
            String s = tokens[1];
            int i = Integer.parseInt(tokens[2]);
            l.insert(s, i);
         }
         else if(command.equals("SET")){
            String s = tokens[1];
            int i = Integer.parseInt(tokens[2]);
            l.set(s, i);
         }
         else if(command.equals("SWP")){
            int i = Integer.parseInt(tokens[1]);
            int j = Integer.parseInt(tokens[2]);
            l.swap(i, j);
         }
         else if(command.equals("LAP")){
            start = timer.elapsedTime();
         }
         else{
            StdOut.println("Unknown command: "+command);
         }
      }
      
      //print out the elapsed time
      double end = timer.elapsedTime();
      StdOut.printf("CPU Time: %.3f s\n", (end - start));      
   }
}
         
         
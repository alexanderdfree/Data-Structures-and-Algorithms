/*Test the speed of various dictionary operations*/

public class DictSpeed{

   public static void main(String[] args){
      //Toggle which type of dict to use
      //ADict d = new ADict();
      SADict d = new SADict();
      //BSTDict d = new BSTDict();
      
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
         if(command.equals("PUT")){
            String s = tokens[1];
            Integer i = Integer.parseInt(tokens[2]);
            d.put(s, i);
         }
         else if(command.equals("GET")){
            String s = tokens[1];
            d.get(s);
         }
         else if(command.equals("DEL")){
            String s = tokens[1];
            d.delete(s);
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

   
/*Test the speed of various dictionary operations*/

public class NewDictSpeed{

   public static void main(String[] args){
      //Toggle which type of dict to use
      //ADict d = new ADict();
      //SADict d = new SADict();
      BSTDict d = new BSTDict();
      
      //create a stopwatch for timing
      StopwatchCPU timer = new StopwatchCPU();
      double start = timer.elapsedTime();
      
      //create storage for tracking the results of validity checks
      int pass_pre = 0;
      int tot_pre = 0;
      
      int pass_run = 0;
      int tot_run = 0;
      
      int pass_post = 0;
      int tot_post = 0;
      
      String phase = "setup"; //track which phase we are in
      
      //Load the commands
      while(StdIn.isEmpty() == false){
         //read in each command
         String line = StdIn.readLine();
         //spliit the command into tokens
         String[] tokens = line.split(" ");
         String command = tokens[0];
         //determine which command to do
         if(command.equals("SETUP")){
            StdOut.print("\n\n");//scroll window a bit
            StdOut.println("------------------------SETUP----------------------------");
            StdOut.print("Setting Up Initial Data...");
         }
         else if(command.equals("PRETEST")){
            StdOut.println("OK");
            StdOut.print("Running Pre-Tests...");
            phase = "pretest";
         }
         else if(command.equals("SPEEDTEST")){
            //print the results of pre-tests
            if(pass_pre == tot_pre){
               StdOut.println("OK");
            }
            else{
               StdOut.println("FAIL (failed "+(tot_pre - pass_pre)+" of "+tot_pre+" pre-tests)");
            }
            StdOut.println("------------------------SPEED----------------------------");
            //print out next user message
            StdOut.println("Running Speed Tests...");
            //change phase
            phase = "speedtest";
            //reset stopwatch
            start = timer.elapsedTime();
         }
         else if(command.equals("POSTTEST")){
            //print the results of speed test timing
            double end = timer.elapsedTime();
            StdOut.printf("CPU Time: %.3f s\n", (end - start)); 
            //print out the result of run-time tests
            StdOut.print("Run-Time Tests: ");
            if(tot_run == 0){
               StdOut.println("None");
            }
            else if(pass_run == tot_run){
               StdOut.println("OK");
            }
            else{
               StdOut.println("FAIL (failed "+(tot_run - pass_run)+" of "+tot_run+" run-time tests)");
            }
            //print out next user message
            StdOut.println("------------------------POST-----------------------------");
            StdOut.print("Running Post-Tests...");
            phase = "posttest"; 
         }
         else if(command.equals("COMPLETE")){
            //print the results of post-tests
            if(pass_post == tot_post){
               StdOut.println("OK");
            }
            else{
               StdOut.println("FAIL (failed "+(tot_post - pass_post)+" of "+tot_post+" post-tests)");
            }
            //Finish Testing
            StdOut.println("------------------------DONE-----------------------------");
            StdOut.print("\n\n");
            return; //force end even if there are more tests in file
         }
         else if(command.equals("PUT")){
            String s = tokens[1];
            Integer i = Integer.parseInt(tokens[2]);
            d.put(s, i);
         }
         else if(command.equals("GET")){
            String s = tokens[1];
            d.get(s);
         }
         else if(command.equals("?GET")){
            String key = tokens[1];
            String valToken = tokens[2];
            Object val;
            if(valToken.equals("null")){
               val = null;
            }
            else{
               val = Integer.parseInt(valToken);
            }
            Object check = d.get(key);
            if(phase.equals("pretest")){
               if(val == null){
                  if(check == null){
                     pass_pre++;
                  }
                  else{
                     //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
                  }
               }
               else if(check.equals(val)){
                  pass_pre++;
               }
               else{
                  //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
               }
               tot_pre++;
            }
            else if(phase.equals("speedtest")){
               if(val == null){
                  if(check == null){
                     pass_run++;
                  }
                  else{
                     //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
                  }
               }
               else if(check.equals(val)){
                  pass_run++;
               }
               else{
                  //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
               }
               tot_run++;
            }
            else if(phase.equals("posttest")){
               if(val == null){
                  if(check == null){
                     pass_post++;
                  }
                  else{
                     //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
                  }
               }
               else if(check.equals(val)){
                  pass_post++;
               }
               else{
                  //StdOut.println("Key: "+key+", Expected: "+val+", Got: "+check);
               }
               tot_post++;
            }
            else{
               StdOut.println("?GET outside of testing phase");
            }
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
   }
}

   
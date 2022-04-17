/*
A class for testing the functionality of Dictionary-style containers
*/

public class TestBSTDict{

   public static void testBasic(){
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing put()/get() basic");
      StdOut.println("-------------------------------------------------");
      
      BSTDict d = new BSTDict();
      
      Testing.testEquals("Test 0.0", d.size(), 0);
      
      
      Testing.testEquals("Test 0.1", d.get("a"), null);
      d.put("a", 0);
      Testing.testEquals("Test 0.2", d.get("a"), 0);
      Testing.testEquals("Test 0.3", d.size(), 1);
      
      Testing.testEquals("Test 0.4", d.get("b"), null);
      d.put("b", 1);
      Testing.testEquals("Test 0.5", d.get("a"), 0);
      Testing.testEquals("Test 0.6", d.get("b"), 1);
      Testing.testEquals("Test 0.7", d.size(), 2);
      
      Testing.testEquals("Test 0.8", d.get("c"), null);
      d.put("c", 2);
      Testing.testEquals("Test 0.9", d.get("a"), 0);
      Testing.testEquals("Test 0.10", d.get("b"), 1);
      Testing.testEquals("Test 0.11", d.get("c"), 2);
      Testing.testEquals("Test 0.12", d.size(), 3);
   }
          
   public static void testAdvanced(){
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing put()/get() overwrite, resize");
      StdOut.println("-------------------------------------------------");
      
      BSTDict d = new BSTDict();
      
      d.put("a", 0);
      Testing.testEquals("Test 1.0", d.get("a"), 0);
      Testing.testEquals("Test 1.1", d.size(), 1);
      
      d.put("a", "cat");
      Testing.testEquals("Test 1.2", d.get("a"), "cat");
      Testing.testEquals("Test 1.3", d.size(), 1);
      
      d.put("b", 1);
      Testing.testEquals("Test 1.4", d.get("a"), "cat");
      Testing.testEquals("Test 1.5", d.get("b"), 1);
      Testing.testEquals("Test 1.6", d.size(), 2);
      
      d.put("b", "dog");
      Testing.testEquals("Test 1.7", d.get("a"), "cat");
      Testing.testEquals("Test 1.8", d.get("b"), "dog");
      Testing.testEquals("Test 1.9", d.size(), 2);
      
      d.put("a", 0);
      Testing.testEquals("Test 1.10", d.get("a"), 0);
      Testing.testEquals("Test 1.11", d.get("b"), "dog");
      Testing.testEquals("Test 1.12", d.size(), 2);
      
      d.put("c", "fish");
      Testing.testEquals("Test 1.13", d.get("a"), 0);
      Testing.testEquals("Test 1.14", d.get("b"), "dog");
      Testing.testEquals("Test 1.15", d.get("c"), "fish");
      Testing.testEquals("Test 1.16", d.size(), 3);
      
      d.put("b", 1);
      Testing.testEquals("Test 1.17", d.get("a"), 0);
      Testing.testEquals("Test 1.18", d.get("b"), 1);
      Testing.testEquals("Test 1.19", d.get("c"), "fish");
      Testing.testEquals("Test 1.20", d.size(), 3);
      
      d.put("c", 2);
      Testing.testEquals("Test 1.21", d.get("a"), 0);
      Testing.testEquals("Test 1.22", d.get("b"), 1);
      Testing.testEquals("Test 1.23", d.get("c"), 2);
      Testing.testEquals("Test 1.24", d.size(), 3);
      
      d.put("d", "bird");
      Testing.testEquals("Test 1.25", d.get("a"), 0);
      Testing.testEquals("Test 1.26", d.get("b"), 1);
      Testing.testEquals("Test 1.27", d.get("c"), 2);
      Testing.testEquals("Test 1.28", d.get("d"), "bird");
      Testing.testEquals("Test 1.29", d.size(), 4);
      
      d.put("d", 3);
      Testing.testEquals("Test 1.30", d.get("a"), 0);
      Testing.testEquals("Test 1.31", d.get("b"), 1);
      Testing.testEquals("Test 1.32", d.get("c"), 2);
      Testing.testEquals("Test 1.33", d.get("d"), 3);
      Testing.testEquals("Test 1.34", d.size(), 4);

      //Stress test for resize
      for(int i = 4; i < 10000; i++){
         String key = int2String(i);
         d.put(key, i);
      }
      Testing.testEquals("Test 1.35", d.get(int2String(9999)), 9999);
      Testing.testEquals("Test 1.36", d.size(), 10000);
   }
   
   /*
   public static void testDelete(){
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing delete()");
      StdOut.println("-------------------------------------------------");
   
      BSTDict d = new BSTDict();
      d.delete("a");
      Testing.testEquals("Test 2.0", d.size() , 0);
      
      d.put("a", 0);
      d.delete("a");
      Testing.testEquals("Test 2.1", d.get("a"), null);
      Testing.testEquals("Test 2.2", d.size(), 0);
      
      d.put("a", 0);
      d.put("a", 1);
      d.delete("a");
      Testing.testEquals("Test 2.3", d.get("a"), null);
      Testing.testEquals("Test 2.4", d.size(), 0);
      
      d.put("a", 0);
      d.put("b", 1);
      d.delete("a");
      Testing.testEquals("Test 2.5", d.get("a"), null);
      Testing.testEquals("Test 2.6", d.get("b"), 1);
      Testing.testEquals("Test 2.7", d.size(), 1);
      d.delete("b");
      Testing.testEquals("Test 2.8", d.get("b"), null);
      Testing.testEquals("Test 2.9", d.size(), 0);
      
      d.put("a", 0);
      d.put("b", 1);
      d.delete("b");
      Testing.testEquals("Test 2.10", d.get("a"), 0);
      Testing.testEquals("Test 2.11", d.get("b"), null);
      Testing.testEquals("Test 2.12", d.size(), 1);
      d.delete("a");
      Testing.testEquals("Test 2.13", d.get("a"), null);
      Testing.testEquals("Test 2.14", d.size(), 0);
      
      d.put("a", 0);
      d.put("b", 1);
      d.put("c", 2);
      d.delete("c");
      Testing.testEquals("Test 2.15", d.get("a"), 0);
      Testing.testEquals("Test 2.16", d.get("b"), 1);
      Testing.testEquals("Test 2.17", d.get("c"), null);
      Testing.testEquals("Test 2.18", d.size(), 2);
      d.delete("b");
      Testing.testEquals("Test 2.19", d.get("a"), 0);
      Testing.testEquals("Test 2.20", d.get("b"), null);
      Testing.testEquals("Test 2.21", d.get("c"), null);
      Testing.testEquals("Test 2.22", d.size(), 1);
      d.delete("a");
      Testing.testEquals("Test 2.23", d.get("a"), null);
      Testing.testEquals("Test 2.24", d.get("b"), null);
      Testing.testEquals("Test 2.25", d.get("c"), null);
      Testing.testEquals("Test 2.26", d.size(), 0);
      
      d.put("a", 0);
      d.put("b", 1);
      d.put("c", 2);
      d.delete("a");
      Testing.testEquals("Test 2.27", d.get("a"), null);
      Testing.testEquals("Test 2.28", d.get("b"), 1);
      Testing.testEquals("Test 2.29", d.get("c"), 2);
      Testing.testEquals("Test 2.30", d.size(), 2);
      d.delete("b");
      Testing.testEquals("Test 2.31", d.get("a"), null);
      Testing.testEquals("Test 2.32", d.get("b"), null);
      Testing.testEquals("Test 2.33", d.get("c"), 2);
      Testing.testEquals("Test 2.34", d.size(), 1);
      d.delete("c");
      Testing.testEquals("Test 2.35", d.get("a"), null);
      Testing.testEquals("Test 2.36", d.get("b"), null);
      Testing.testEquals("Test 2.37", d.get("c"), null);
      Testing.testEquals("Test 2.38", d.size(), 0);
      
      //stress test for size
      for(int i = 0; i < 10000; i++){
         String key = int2String(i);
         d.put(key, i);
      }
      
      d.delete(int2String(9999));
      Testing.testEquals("Test 2.39", d.get(int2String(9999)), null);
      Testing.testEquals("Test 2.40", d.size(), 9999);
      
      //remove all remaining entries
      for(int i = 9998; i >= 0; i--){
         String key = int2String(i);
         d.delete(key);
      }
      Testing.testEquals("Test 2.41", d.get("a"), null);
      Testing.testEquals("Test 2.42", d.size(), 0);
   }
   */
   
   private static String int2String(int i){
      /* Helper method for making keys for stress tests
      Convert an int to a String of format:
      0   -> "a"
      1   -> "b"
      25  -> "z"
      26  -> "aa"
      27  -> "ab"
      701 -> "zz"
      702 -> "aaa"
      */
      if((i >= 0) && (i < 26)){
         char c = (char)(97 + i); //ASCII table trickery
         return ""+c;
      }
      else{
         String leastDig = int2String(i % 26);
         String remDig = int2String(i / 26 - 1);
         return remDig+leastDig;
      }
   }
   
   public static void main(String[] args){
      testBasic();
      testAdvanced();
      //testDelete();
   }
   
   
}
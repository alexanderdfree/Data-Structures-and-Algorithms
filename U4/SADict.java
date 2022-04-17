/*
A class for representing a dictionary of key-value pairs.
Sort the KVPairs by key in the underlying storage for
faster look-up times through bisection search.
*/

public class SADict{
   private KVPair[] storage;  //an array to store key-value pairs
   private int size;          //the number of entries currently in the Dict
   
   private static int defaultCapacity = 10; 
   
   public SADict(){
      /*Constructor. Initialize a new empty Dictionary*/
      this.storage = new KVPair[defaultCapacity];
   }
   
   public int size(){
      /*Return the number of entries currently in this Dictionary*/
      return this.size;
   }
   
   private void resize(){
      /*Double the storage capacity of this dictionary.
      Copy over the existing contents.*/
      KVPair[] newStore = new KVPair[2*this.storage.length];
      for(int i = 0; i < this.size; i++){
         newStore[i] = this.storage[i];
      }
      this.storage = newStore;
   }
   
   public String toString(){
      /*Return a String representing the contents of this Dict*/
      String s = "{";
      for(int i = 0; i < this.size; i++){
         if(i != 0){
            s += ", ";
         }
         KVPair check = this.storage[i];
         s += check.toString();
      }
      return s += "}";
   }
   
   /*public void put(String key, Object value){
      /*A placeholder version of put(). Only works for the simplest cases
      in order to let you test other methods. YOU WILL NEED TO FIX THIS*/
      
      
      //KVPair newKV = new KVPair(key, value);//new KVPair to put in dict
      
      //put new key-value in dict and increment size
      //this.storage[this.size] = newKV;
      //this.size++;
   //}*/
   public double search(String key){
      /* Search through this dict for a matching key using binary search.
      If a match is found, return the index within the storage array of
      the match, but as a double (ex. if the index was 3, return 3.0). If
      no match is found, return the placement between indices where the
      new key should be inserted (ex. if it should go between 3 and 4,
      return 3.5). If the key is in the dict, the result will end in 0.0,
      otherwise it will end in 0.5
      Ex.
      SADict d = new SADict()
      d.search("a") -> -0.5 (since not in dict)
      
      d.put("a")
      d.search("a") -> 0.0  (since now in dict)
      
      d.search("c") -> 0.5  (above 0, but not in dict)
      d.put("c")
      d.search("c") -> 1.0  (now in dict)
      
      d.search("b") -> 0.5  (should go between 0 and 1)
      */
      
      
      //double test = 
      //boolean found = false;
      
      if (this.size == 0) return -0.5;
      if (this.size == 1 && this.storage[0].getKey().equals(key)) return 0;
      
      int upper = this.size()-1;
      int lower = 0;
      int middle = (upper + lower)/2;
      
      if (this.size == 1 && key.compareTo(this.storage[(int)middle].getKey()) > 0) return 0.5;
      else if (this.size == 1) return -0.5;
      
      while (upper > middle){
         middle = (upper + lower)/2;
         //test = (upper + lower)/2;
         //int middleInt = middle;
         String midKey = this.storage[(int)middle].getKey();
         String lowKey = this.storage[(int)lower].getKey();
         String highKey = this.storage[(int)upper].getKey();
         //highkey = "";
         int j = 0;
         
         if (lowKey.equals(key)) return lower;
         lower++;
         if (highKey.equals(key)) return upper;
         upper--;
         
         if (key.compareTo(lowKey) < 0 && key.length() <= lowKey.length()) return -0.5;
         if (key.compareTo(highKey) > 0 && key.length() >= highKey.length()) return this.size - 0.5;
         
         if (key.length() > midKey.length()){
            lower = middle;
         }
         else if (key.length() < midKey.length()){
            upper = middle;
         }
         else if (key.compareTo(midKey) > 0){
            lower = middle;
         }
         else if (key.compareTo(midKey) < 0){
            upper = middle;
         }
         else return middle;
         
         //StdOut.println("MIDDLE: " + middle);
      }
      return middle + 0.5;
   }
   public void put(String key, Object value){
      /* If the key already exists in this dict, update the value. If the
      key is not already in this dict, make a new entry.
      Ex.
      SADict d = new SADict()
      s.put("c", 1)
      s.toString() -> {"c":1}
      s.put("c", 2)
      s.toString() -> {"c":2}
      s.put("a", -1)
      s.toString() -> {"a":-1, "c":2}
      s.put("a", 0)
      s.toString() -> {"a":0, "c":2}
      s.put("b", 3)
      s.toString() -> {"a":0, "b":3, "c":2}
      s.put("b", 1)
      s.toString() -> {"a":0, "b":1, "c":2}
      */
      double indexOriginal = this.search(key);
      KVPair pair = new KVPair(key, value);
      if (indexOriginal % 1 == 0.5){
         int index = (int) (indexOriginal + 0.5);
         if(this.size >= this.storage.length){
            this.resize();
         }
      }
      if (this.size == 0){
         this.storage[0] = pair;
         this.size++;
      }
      else if (this.size == 1 && !this.storage[0].getKey().equals(key)){
         this.storage[2] = this.storage[1];
         this.storage[1] = pair;
         this.size++;
      }
      else if (this.size == 2 && !this.storage[0].getKey().equals(key) && !this.storage[1].getKey().equals(key)){
         if(indexOriginal == 0.5){
            this.storage[2] = this.storage[1];
            this.storage[1] = pair;
         }
         else if(indexOriginal == 1.5){
            this.storage[2] = pair;
         }
         else if(indexOriginal == -0.5){
            this.storage[2] = this.storage[1];
            this.storage[1] = this.storage[0];
            this.storage[0] = pair;
         }
         /*else if(indexOriginal == 1.5){
            this.storage[2] = pair;
         }*/
         this.size++;
      }
      else if (indexOriginal % 1 == 0.5){
         int index = (int) (indexOriginal + 0.5);
         
         for (int i = this.size()-1; i >= index; i--){
            //if (i > 0){
               this.storage[(int)(i+1)] = this.storage[(int)(i)];
            //}
         }
         this.storage[(int)(index)] = pair;
         this.size++;
      }
      else{
         this.storage[(int)indexOriginal] = pair;
      }
   }
   public Object get(String key){
      /* Get the value associated with that key. If the key is not in the
      dict, return null.
      Ex.
      SADict d = new SADict()
      d.get("a") -> null  (not in dict)
      
      d.put("a", 1)
      d.get("a") -> 1
      
      d.put("a", 0)
      d.get("a") -> 0
      d.get("c") -> null
      
      d.put("c", 2)
      d.get("c") -> 2
      d.get("b") -> null
      
      d.put("b", 1)
      d.get("a") -> 0
      d.get("b") -> 1
      d.get("c") -> 2
      */
      if (this.search(key) % 1 == 0) return this.storage[(int)this.search(key)].getValue();
      else return null;
   }
   public void delete(String key){
      /* Delete the matching key-value pair from this dict. If the key
      is not in this dict, do nothing.
      Ex.
      SADict d = new SADict()
      d.put("a", 0)
      d.put("b", 1)
      d.put("c", 2)
      d.put("d", 3)
      d.toString() -> {"a":0, "b":1, "c":2, "d":3}
      
      d.delete("c")
      d.toString() -> {"a":0, "b":1, "d":3}
   
      d.delete("b")
      d.toString() -> {"a":0, "d":3}
      
      d.delete("b")
      d.toString() -> {"a":0, "d":3}
   
      d.delete("d")
      d.toString() -> {"a": 0}
   
      d.delete("a")
      d.toString() -> {}
   
      d.delete("a")
      d.toString() -> {}
      */
      double index = this.search(key);
      if (index % 1 == 0){
         for (int i = (int)index; i < this.size-1; i++){
               this.storage[i] = this.storage[i+1];
         }
         this.storage[this.size-1] = null;
         this.size--;
      }
   }
}    
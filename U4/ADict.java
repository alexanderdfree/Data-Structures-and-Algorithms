/*
A class for representing a dictionary of key-value pairs
*/

public class ADict{
   private KVPair[] storage;  //an array to store key-value pairs
   private int size;          //the nuumber of entries currently in the Dictionary
   
   private static int defaultCapacity = 10; 
   
   public ADict(){
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
   
   public void put(String key, Object value){
      /*Search for the given key. If a match is found, update
      the value. If no match is found, add a new key-value pair
      to the storage.
      Ex.
      ADict d = new ADict()
      d.put("cat", 100)
      d.toString() -> {"cat":100}
      d.put("dog", true)
      d.toString() -> {"cat":100, "dog":true}
      d.put("fish", 1.5)
      d.toString() -> {"cat":100, "dog":true, "fish":1.5}
      d.put("cat", 55)
      d.toString() -> {"cat":55, "dog":true, "fish":1.5}
      */
      KVPair newKV = new KVPair(key, value); //new KVPair to add to dict
      int index = -1;
      boolean found = false;
      int i = 0;
      while (i < this.size && !found){
         if (this.storage[i].getKey().equals(key)){
            this.storage[i] = newKV;
            found = true;
         }
         i++;
      }
      if(!found){
         if(this.size >= this.storage.length){
            this.resize();
         }
         this.storage[this.size] = newKV;  //add to end of dict
         this.size++;   //increment size
      }
   }
   public Object get(String key){
      /* Return the value associated with the given key, provided it
      exists in this dictionary. If the key is not found, return null.
      Ex.
      ADict d = new ADict()
      d.get("cat") -> null
      d.put("cat", 100)
      d.get("cat") -> 100
      d.put("dog", true)
      d.get("dog") -> true
      d.get("fish") -> null
      */
      for (int i = 0; i < this.size; i++){
         if (this.storage[i].getKey().equals(key)){
            return this.storage[i].getValue();
         }
      }
      return null;
   }
   public void delete(String key){
      /* Delete the entry associated with the given key. If there is no
      entry matching the provided key, do nothing
      
      Ex.
      ADict d = new ADict()
      d.put("cat", 100)
      d.put("dog", true)
      d.toString() -> {"cat":100, "dog":true}
      d.delete("cat")
      d.toString() -> {"dog":true}
      d.delete("fish")
      d.toString() -> {"dog":true}
      */
      boolean found = false;
      for (int i = 0; i < this.size; i++){
         String currentKey = this.storage[i].getKey();
         if (currentKey.equals(key)){
            found = true;
         }
         if(found && i != this.size-1){
            this.storage[i] = this.storage[i+1];
         }
         else if (found){
            this.storage[i] = null;
         }
      }
      if (found) this.size--;
      
   }
}
         
      
            
            
      
      
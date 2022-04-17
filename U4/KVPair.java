/*
A class for representing key-value pairs in a Dictionary/Symbol Table
*/

public class KVPair{
   private String key;   //the key
   private Object value; //the value
   
   public KVPair(String key, Object value){
      /*Constructor. Initialize a new KVPair*/
      this.key = key;
      this.value = value;
   }
   
   public String getKey(){
      /*Return the key in this KVPair*/
      return this.key;
   }
   
   public Object getValue(){
      /*Return the value in this KVPair*/
      return this.value;
   }
   
   public String toString(){
      /*Return a String representing this KVPair*/
      return "\"" + this.key + "\":"+this.value.toString();
   }
}
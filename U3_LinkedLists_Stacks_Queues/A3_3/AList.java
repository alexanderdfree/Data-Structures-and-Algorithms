/*A minimal implementation of an ArrayList
*/

public class AList{
   private Object[] contents;  //stores the contents of the list
   private int size;  //keeps track of the number of items in the list
   
   //performance parameters
   private static int minCapacity = 10;
   private static int growthFactor = 2;
   
   public AList(){
      /*Constructor, makes an empty list*/
      this.contents = new Object[minCapacity];
      this.size = 0;
   }
   
   public int size(){
      /*Return the number of items in this list*/
      return this.size;
   }
   
   public String toString(){
      /*Return a String representing this list*/
      String s = "[";
      for(int i = 0; i < this.size; i++){
         if(i != 0){
            s += ", ";
         }
         s += this.contents[i];
      }
      s += "]";
      return s;
   }
   
   private void increaseCapacity(){
      /*Helper method, increase the capacity by growthFactor*/
      Object[] larger = new Object[this.contents.length*growthFactor];
      for(int i = 0; i < this.size; i++){
         larger[i] = this.contents[i];
      }
      this.contents = larger;
   }
         
   public void add(Object o){
      /*Adds object to the end of the list*/
      if(this.size == this.contents.length){
         this.increaseCapacity();
      }
      this.contents[this.size] = o;
      this.size++;
   }
   
   public Object get(int i){
      /*Get the item at index i*/
      return this.contents[i];
   }
   
   public Object remove(int i){
      /*Remove the object at index i*/
      Object toReturn = this.contents[i];
      //shift other items down
      for(int j = i; j < this.size; j++){
         this.contents[j] = this.contents[j+1];
      }
      //adjust the size
      this.size--;
      //return the removed object
      return toReturn;
   }
   
   public void insert(Object o, int i){
      /*Insert o into the list at index i*/
      
      //if the list needs to grow, do it
      if(this.size == this.contents.length){
         this.increaseCapacity();
      }
      //shift items up
      for(int j = this.size; j > i; j--){
         this.contents[j] = this.contents[j-1];
      }
      //insert the new item
      this.contents[i] = o;
      //update the size
      this.size++;
   }
   
   public void set(Object o, int i){
      /*Set the element at index i to be o*/
      this.contents[i] = o;
   }
   
   public void swap(int i, int j){
      /*Swap the items at index i and j*/
      Object temp = this.contents[i];
      this.contents[i] = this.contents[j];
      this.contents[j] = temp;
   }
      
}
      
   

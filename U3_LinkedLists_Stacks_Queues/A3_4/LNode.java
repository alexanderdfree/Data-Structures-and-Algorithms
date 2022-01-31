/*
A class for representing nodes of data in a linked collection
*/

public class LNode{
   private Object o;     //the data to store in this node
   private LNode next;   //the next node in the collection
   
   public LNode(Object data){
      /*Constructor, make a new LNode to store the data*/
      this.o = data;
   }
   
   public Object getData(){
      /*Return the data stored at this LNode*/
      return this.o;
   }
   
   public void setNext(LNode n){
      /*Set this LNode's next to be n*/
      this.next = n;
   }
   
   public LNode getNext(){
      /*Return the next LNode after this one*/
      return this.next;
   }
   
   public String toString(){
      /*Return a String representing this LNode*/
      return this.o.toString() + " -> " + this.next;
   }
}
   
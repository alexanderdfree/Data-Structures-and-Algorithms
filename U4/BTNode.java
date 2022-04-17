/*
A class for representing linked nodes in a Binary Tree
*/

public class BTNode{
   private Object data;  //the Object stored at this node
   private BTNode left;  //the node to the left
   private BTNode right; //the node to the right
   
   public BTNode(Object data){
      /*Make a new BTNode storing o*/
      this.data = data;
      this.left = null;
      this.right = null;
   }
   
   public Object getData(){
      /*Return the data stored at this node*/
      return this.data;
   }
   
   public void setData(Object dat){
      /*Set the data stored at this node to be dat*/
      this.data = dat;
   }
   
   public boolean hasLeft(){
      /*Checks if this node has a left node*/
      if(this.left == null){
         return false;
      }
      else{
         return true;
      }
   }
   
   public boolean hasRight(){
      /*Checks if this node has a right node*/
      if(this.right == null){
         return false;
      }
      else{
         return true;
      }
   }
   
   public BTNode getLeft(){
      /*Return the node to the left*/
      return this.left;
   }
   
   public BTNode getRight(){
      /*Return the node to the right*/
      return this.right;
   }
   
   public void setLeft(BTNode left){
      /*Set the left node of this to left*/
      this.left = left;
   }
   
   public void setRight(BTNode right){
      /*Set the right node of this to right*/
      this.right = right;
   }
   
   public String toString(){
      /*Return a String representation of this tree*/
      //this node
      String s = "(D:" + this.data;
      //the left tree
      s += ", L:";
      if(this.left == null){
         s += "null";
      }
      else{
         s += this.left.toString();
      }
      //the right tree
      s += ", R:";
      if(this.right == null){
         s += "null";
      }
      else{
         s += this.right.toString();
      }
      s += ")";
      return s;
   }
   
   public boolean isLeaf(){
      /*Return true if this node is a leaf*/
      if(this.left == null){
         if(this.right == null){
            return true;
         }
      }
      return false;
   }
   
   public String print2D(){
      return BTPrint.visualize(this);
   }
}
   
   
   
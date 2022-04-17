/*
This is a helper library for displaying binary trees.

It turned out to be more complicate than I anticipated, so
I am leaving all of this in a separate file rather than putting
it in the BTNode class. The whole point of this file is basically just
to support the visualize() method.
*/

import java.util.ArrayList;

public class BTPrint{

   private static char[][] makeChar2D(int numRows, int numCols){
      /*Return a 2D char array with the given dimensions. Each
      box will be filled by default with a ' '.
      */
      char[][] boxes2D = new char[numRows][numCols];
      //fill with spaces
      for(int i = 0; i < numRows; i++){
         for(int j = 0; j < numCols; j++){
            boxes2D[i][j] = ' ';
         }
      }
      return boxes2D;
   }
   
   private static String char2DToString(char[][] cBoxes){
      /*Convert the given 2D char array to a single String*/
      String s = "";
      for(int i = 0; i < cBoxes.length; i++){
         for(int j = 0; j < cBoxes[i].length; j++){
            s += cBoxes[i][j];
         }
         if(i < cBoxes.length - 1){
            s += "\n";
         }
      }
      return s;
   }
   
   private static void drawArrow(int row, int parent, int child, char[][] arrowBoxes){
      /*Draw an arrow from parent to child in row*/
      int left = Math.min(parent, child);
      int right = Math.max(parent, child);
      for(int i = left; i <= right; i++){
         arrowBoxes[row][i] = '-';
      }
   }
   
   private static int maxDepth(BTNode n){
      /*Calculate the maximum depth of the given tree*/
      if(n == null){
         return 0;
      }
      else{
         //get the depth of both child trees
         int lDepth = maxDepth(n.getLeft());
         int rDepth = maxDepth(n.getRight());
         //pick the bigger one
         if(lDepth > rDepth){
            return lDepth + 1; //+1 for this node
         }
         else{
            return rDepth + 1; //+1 for this node
         }
      }
   }
   
   private static int maxCharWidth(BTNode n){
      /*Find the character width of the widest node in
        the given tree*/
      if(n == null){
         return 0;
      }
      else{
         //calculate my width
         String myStr = n.getData().toString();
         int myWidth = myStr.length();
         //get the largest width in each child tree
         int lWidth = maxCharWidth(n.getLeft());
         int rWidth = maxCharWidth(n.getRight());
         int maxWidth = Math.max(Math.max(myWidth, lWidth), rWidth);
         return maxWidth;
      }
   }
   
   private static void helper_treeToStringArray(BTNode n, String[][] store, int row, int col){
      /*Recursively fill the storage with String versions of the contents of n*/
      if(n == null){
         return;
      }
      else{
         String myStr = n.getData().toString(); //convert me to a String
         store[row][col] = myStr; //store my contents to storage array
         helper_treeToStringArray(n.getLeft(), store, row+1, 2*col); //store the contents of my left
         helper_treeToStringArray(n.getRight(), store, row+1, 2*col+1); //store the contents of my right
      }
   }
   
   private static String[][] treeToStringArray(BTNode n){
      /*Convert the given BTNode into a String array representation*/
      
      //find the tree depth
      int treeDepth = maxDepth(n);
      
      //set up array storage to store each node
      String[][] sTree = new String[treeDepth][];
      int nBox = 1;
      for(int i = 0; i < treeDepth; i++){
         sTree[i] = new String[nBox];
         nBox *= 2;
      }
      
      //now you have an array with a box for each potential node
      //fill in all the nodes that exist in the tree
      helper_treeToStringArray(n, sTree, 0, 0);
      
      //return final filled array
      return sTree;
   }
   
   public static String visualize(BTNode n){
      /*Return a String representing n in 2D*/
      
      //minimum gap
      int minGap = 1;
      
      //convert tree to array representation
      String[][] sTree = treeToStringArray(n);
      
      //calculate the boxWidth
      int boxWidth = maxCharWidth(n);
      int treeDepth = sTree.length;
      
      //make 2D char[][] for final printout
      int nCharRows = treeDepth + (treeDepth - 1); //row for arrows in-between
      int nodeWidth = (int) Math.pow(2, treeDepth-1);
      int nCharCols = boxWidth*nodeWidth + (nodeWidth - 1)*minGap; //make sure all nodes are spaced out
      char[][] cTree = makeChar2D(nCharRows, nCharCols);
      
      //make a list to store the location of the node centers
      //from the previous row
      ArrayList<Integer> centers = new ArrayList<Integer>();
      
      //go through the tree row-by-row starting from the bottom
      for(int row = treeDepth - 1; row >= 0; row--){
         if(row == treeDepth - 1){ //special case if doing bottom row
            int loc = 0; //keep track of where to put letters
            for(int col = 0; col < sTree[row].length; col++){
               if(sTree[row][col] == null){//if this node does not exist
                  centers.add(loc); //a marker for future placement
               }
               else{
                  //write this node to the array
                  String sNode = sTree[row][col];
                  int numChars = sNode.length();
                  int lSpace = (boxWidth-numChars)/2;
                  int rSpace = boxWidth - lSpace;
                  for(int i = 0; i < numChars; i++){
                     cTree[row+row][loc+lSpace+i] = sNode.charAt(i);
                  }
                  //store the location of the center
                  centers.add(loc+lSpace + numChars/2);
               }
               //update where we write
               loc += boxWidth + minGap;
            }
            
         }
         
         else{
            //draw the arrows from the previous nodes
            for(int i = 0; i < sTree[row+1].length; i += 2){
               int left = centers.get(i);
               int right = centers.get(i+1);
               int mid = (left + right)/2;
               if(sTree[row+1][i] != null){
                  drawArrow(row+row+1, mid, left, cTree);
               }
               if(sTree[row+1][i+1] != null){
                  drawArrow(row+row+1, mid, right, cTree);
               }
            }
            
            ArrayList<Integer> newCenters = new ArrayList<Integer>();
            
            //print out this row
            for(int col = 0; col < sTree[row].length; col++){
               int left = centers.get(2*col);
               int right = centers.get(2*col+1);
               int mid = (left + right)/2;
               if(sTree[row][col] == null){//if this node does not exist
                  newCenters.add(mid); //a marker for future placement
               }
               else{
                  //write this node to the array
                  String sNode = sTree[row][col];
                  int numChars = sNode.length();
                  int lSpace = (boxWidth-numChars)/2;
                  int rSpace = boxWidth - lSpace;
                  int lEdge = mid - numChars/2;
                  for(int i = 0; i < numChars; i++){
                     cTree[row+row][lEdge + i] = sNode.charAt(i);
                  }
                  //store the location of the center
                  newCenters.add(mid);
               }
            }
            
            //replace old centers with new centers
            centers = newCenters;  
         }
      }
      
      //convert char[][] to String and return
      return char2DToString(cTree);
   }
         
   public static void main(String[] args){

         BTNode n1 = new BTNode("A");
         BTNode n2 = new BTNode("B");
         BTNode n3 = new BTNode("C");
         BTNode n4 = new BTNode("Owen Coyle");
         BTNode n5 = new BTNode("E");
         
         n1.setLeft(n2);
         n1.setRight(n3);
         n2.setLeft(n4);
         n2.setRight(n5);
         
         System.out.println(visualize(n1));
         
   }
}
      
         
      
      
      




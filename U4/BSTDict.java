/*
A Dictionary implemented using a Binary Search Tree
*/

public class BSTDict{
   private BTNode root; //the root of the BST
   
   public BSTDict(){
      /*Constructor. Make a new, empty BST*/
      this.root = null; //start with an empty tree
   }         

   public String toString(){
      /*Return a String showing the 1D dict representation*/
      if(this.root == null){//special case for empty tree
         return "{}";
      }
      else{
         String s = toStringHelper(this.root); //toString whole tree
         String sNoComma = s.substring(2, s.length()); //cut off first comma
         return "{" + sNoComma + "}";
      }
   }
   
   public static String toStringHelper(BTNode n){
      /*Return a String representing the contents of the sub-tree
      rooted at n in left-middle-right order*/
      String s = "";   
      //toString() the left tree
      if(n.hasLeft()){
         s += toStringHelper(n.getLeft());
      }
      //now my contents
      s += ", " + n.getData().toString();
      //toString() the right tree
      if(n.hasRight()){
         s += toStringHelper(n.getRight());
      }
      //return final String
      return s;
   }
   
   public String print2D(){
      /*Return a String showing the 2D tree structure of this dict*/
      return this.root.print2D();
   }
   public int size(){
      /* Returns the number of elements in this dict.
      Ex.
      BSTDict d = makeBSTDict1()
      d.print2D()
               "f":0         
           -------------     
         "d":1       "h":2   
        -------     -------  
      "c":3 "e":4 "g":5 "i":6
      
      d.size() -> 7
      
      d = makeBSTDict2()
      d.print2D()
                                                 "T":0                                               
                           -------------------------                                                 
                         "H":1                                                                       
               -------------------------                                                             
             "E":2                   "Q":3                                                           
         -------                  ------------                                                       
       "C":6                    "I":5      "U":4                                                     
                                  -----                                                              
                                    "K":7  
      d.size() -> 8
      */
      //your code goes here
      if (this.root == null) return 0;
      return sizeHelper(this.root);
   }

   public static int sizeHelper(BTNode n){
      /* Returns the number of elements in this subtree
      Ex.
      BTNode n = makeSubTree1()
      n.print2D()
               "f":0         
           -------------     
         "d":1       "h":2   
        -------     -------  
      "c":3 "e":4 "g":5 "i":6
      
      sizeHelper(n) -> 7
      sizeHelper(n.getLeft()) -> 3
      sizeHelper(n.getLeft().getLeft()) -> 1
      
      n = makeSubTree2()
      n.print2D()
                                                 "T":0                                               
                           -------------------------                                                 
                         "H":1                                                                       
               -------------------------                                                             
             "E":2                   "Q":3                                                           
         -------                  ------------                                                       
       "C":6                    "I":5      "U":4                                                     
                                  -----                                                              
                                    "K":7  
      sizeHelper(n) -> 8
      sizeHelper(n.getLeft()) -> 7
      sizeHelper(n.getLeft().getLeft()) -> 2
      sizeHelper(n.getLeft().getRight()) -> 4
      */
      //your code goes here
      if (n.isLeaf()) return 1;
      if (n.hasLeft() && !n.hasRight()) return sizeHelper(n.getLeft()) + 1;
      if (!n.hasLeft() && n.hasRight()) return sizeHelper(n.getRight()) + 1;
      return sizeHelper(n.getRight()) + sizeHelper(n.getLeft()) + 1;
   }
   public Object get(String key){
      /* Return the value associated with the given key in this dict. If
      there is no entry with a matching key, then return null.
      Ex.
      BSTDict d = makeBSTDict1()
      d.print2D()
               "f":0         
           -------------     
         "d":1       "h":2   
        -------     -------  
      "c":3 "e":4 "g":5 "i":6
      
      d.get("d") -> 1
      d.get("h") -> 2
      d.get("c") -> 3
      d.get("e") -> 4
      d.get("g") -> 5
      d.get("i") -> 6
      d.get("f") -> 0
      d.get("a") -> null
   
      d = makeBSTDict2()
      d.print2D()
                                                 "T":0                                               
                           -------------------------                                                 
                         "H":1                                                                       
               -------------------------                                                             
             "E":2                   "Q":3                                                           
         -------                  ------------                                                       
       "C":6                    "I":5      "U":4                                                     
                                  -----                                                              
                                    "K":7  
   
       d.get("T") -> 0
       d.get("H") -> 1
       d.get("E") -> 2
       d.get("Q") -> 3
       d.get("C") -> 6
       d.get("I") -> 5
       d.get("U") -> 4
       d.get("K") -> 7
       d.get("B") -> null   
       */
       
       //BTNode n = this.root;
       //if (getHelp(n, key) != null) return this.getHelp(n, key);

       //if (getHelp(this.root, key))
       if (this.root == null) return null;
       if (getHelp(this.root, key) == null) return null;
       
       return ((KVPair)getHelp(this.root, key).getData()).getValue();
       
   }
   public static BTNode getHelp(BTNode n, String key1){
      //input: BTNode n, String key1
      //return: KVP value if object exists in tree w/ root node n,
      //otherwise return null
      
      String key2 = ((KVPair)n.getData()).getKey();
      
      //equal or leaf
      if (key2.equals(key1)) return n;
      else if (n.isLeaf()) return null;
      
      //left or right and is there
      if (n.hasLeft() && key1.compareTo(key2) < 0) return getHelp(n.getLeft(), key1);
      if (n.hasRight() && key1.compareTo(key2) > 0) return getHelp(n.getRight(), key1);
      
      //left or right but not there
      return null;
   }
   
   
   public static void main(String args[]){
      BSTDict d = makeBSTDict1();
      StdOut.println(d.size());
      BSTDict c = makeBSTDict2();
      StdOut.println(c.size());
   }
   public void put(String key, Object value){
      /* If this key already exists in the dict, update the value.
         Otherwise, add a new key-value pair to the dictionary in the
         proper location.
         Ex.
         BSTDict d = new BSTDict()
         d.put("T", 0)
         d.put("H", 1)
         d.put("A", 2)
         d.put("C", 3)
         d.print2D()
                           "T":0                       
               -------------                         
             "H":1                                   
          ------                                     
        "A":2                                        
          -----                                      
             "C":3            
         
         d.put("H", 4)
         d.put("E", 5)
         d.put("R", 6)
         d.print2D()
                                             "T":0                                               
                        -------------------------                                                 
                      "H":4                                                                       
            -------------------------                                                             
          "A":2                   "R":6                                                           
            --------                                                                              
                 "C":3                                                                            
                   -----                                                                          
                     "E":5        
             
         */
         if (this.root == null){
            this.root = putHelp(this.root, key, value);
         }
         else{
            putHelp(this.root, key, value);
         }
         //a.setData(new KVPair(key, value));

   }
   public static BTNode putHelp(BTNode n, String key1, Object val){
      //input: BTNode n, String key1
      //return: KVP value if object exists in tree w/ root node n,
      //otherwise return null
      if (n == null) return new BTNode(new KVPair(key1, val));
      String key2 = ((KVPair)n.getData()).getKey();
      
      //equal
      if (key2.equals(key1)){
         n.setData(new KVPair(key1, val));
         return n;
      }
      /*else if (n.isLeaf()){
         return null;
      }*/
      
      //left or right and is there
      if (n.hasLeft() && key1.compareTo(key2) < 0) return putHelp(n.getLeft(), key1, val);
      if (n.hasRight() && key1.compareTo(key2) > 0) return putHelp(n.getRight(), key1, val);
      
      //left or right but not there
      BTNode newNode = new BTNode(new KVPair(key1, val));
      if (!n.hasLeft() && key1.compareTo(key2) < 0){
         n.setLeft(newNode);
         return newNode;
      }
      if (!n.hasRight() && key1.compareTo(key2) > 0){
         n.setRight(newNode);
         return newNode;
      }
      
      /*if (!n.hasLeft() && n.hasRight()) return putHelp(n.getRight(), key1);
      
      if (putHelp(n.getLeft(), key1) != null) return putHelp(n.getLeft(), key1);
      if (putHelp(n.getRight(), key1) != null) return putHelp(n.getRight(), key1);*/
      
      return null;
   }
   public void delete(String key){
      /*Placeholder version of delete()*/
      return;
   }

   
   /*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
               WRITE YOUR CODE ABOVE THIS LINE
   --------------------------------------------------------------
   Ignore the stuff below here. It is just code to make your life
   easier, but it is not important for the library to work. You
   should not be using any of these methods in your code (except
   to test your code).
   ------------------------------------------------------------*/
   
   private static BTNode makeKVNode(String key, Object value){
      /*Make a new BTNode containing a KVPair of key and value*/
      KVPair kv = new KVPair(key, value);
      BTNode n = new BTNode(kv);
      return n;
   }
   
   public static BTNode makeSubTree1(){
      /*Return a pre-made sub-tree for quick testing*/
      BTNode n1 = makeKVNode("f", 0);
      
      BTNode n2 = makeKVNode("d", 1);
      BTNode n3 = makeKVNode("h", 2);
      n1.setLeft(n2);
      n1.setRight(n3);
      
      BTNode n4 = makeKVNode("c", 3);
      BTNode n5 = makeKVNode("e", 4);
      n2.setLeft(n4);
      n2.setRight(n5);
      BTNode n6 = makeKVNode("g", 5);
      BTNode n7 = makeKVNode("i", 6);
      n3.setLeft(n6);
      n3.setRight(n7);
      
      return n1;
   }
   
   public static BSTDict makeBSTDict1(){
      /*Return a pre-made BSTDict for quick testing*/
      BSTDict d = new BSTDict();
      d.root = makeSubTree1();
      return d;
   }
   
   public static BTNode makeSubTree2(){
      /*Return a pre-made sub-tree for quick testing*/
      BTNode n1 = makeKVNode("T", 0);
      
      BTNode n2 = makeKVNode("H", 1);
      n1.setLeft(n2);
      
      BTNode n3 = makeKVNode("E", 2);
      BTNode n4 = makeKVNode("Q", 3);
      n2.setLeft(n3);
      n2.setRight(n4);
      
      BTNode n5 = makeKVNode("C", 6);
      BTNode n6 = makeKVNode("I", 5);
      BTNode n7 = makeKVNode("U", 4);
      n3.setLeft(n5);
      n4.setLeft(n6);
      n4.setRight(n7);
      
      BTNode n8 = makeKVNode("K", 7);
      n6.setRight(n8);
      
      return n1;
   }
   
   public static BSTDict makeBSTDict2(){
      /*Return a pre-made BSTDict for quick testing*/
      BSTDict d = new BSTDict();
      d.root = makeSubTree2();
      return d;
   }
      
      
}
public class Dog extends Pet{
   /*Dog inherits all attributes and methods of Pet*/
   //int age;
   boolean good;
   public Dog(String name, int age){
      super(name, age); //call superclass constructor
      this.good = true;
   }
   
   /*Override methods you want to change*/
   
   public String talk(){
      return "Woof";
   }
   
   public void birthday(){
      this.age += 7;
   }
   public void scold(){
      this.good = false;
   }
   public void praise(){
      this.good = true;
   }
   
}
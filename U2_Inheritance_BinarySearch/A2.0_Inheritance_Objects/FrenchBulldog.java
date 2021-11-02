public class FrenchBulldog extends Dog{

   public FrenchBulldog(String name, int age){
      super(name, age); //call superclass constructor
   }
   
   /*Override methods you want to change*/
   public String talk(){
      /*What sound does the Pet make?*/
      return "Le woof";
   }

}
package Lab1;

public class Start {
     public static void main(String[] args) {
         Counter bnd = new Counter();
         bnd.count(10);
         System.out.println("Value, smaller than 10 is " + bnd.getResult());
         bnd.generate(10);
         System.out.println("Random number, smaller than 10 is " + bnd.getResult());
         bnd.count(5);
         System.out.println("Value, smaller than 5 is " + bnd.getResult());
         bnd.count(10);
         System.out.println("Value, smaller than 10 is " + bnd.getResult());
         bnd.generate(5);
         System.out.println("Random number, smaller than 5 is " + bnd.getResult());
         bnd.count(1000);
         System.out.println("Value, smaller than 1000 is " + bnd.getResult());
     }
 }
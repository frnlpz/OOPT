package lab6;
import lab4.Schema;

public class Lab6 {

    public static void main(String[] args) {
        Schema a = new Schema();
        a.addInput(); //1
        a.addInput(); //2
        a.addInput(); //3
        a.addInput(); //4
        a.addNOT();   //5
        a.addAND();   //6
        a.addOR();    //7
        a.addXOR();   //8

        a.connectElements(1, 5);
        a.connectElements(1, 6);
        a.connectElements(2, 6);
        a.connectElements(3, 6);
        a.connectElements(3, 7);
        a.connectElements(4, 7);
        a.connectElements(5, 8);
        a.connectElements(6, 8);
        a.connectElements(7, 8);

        a.setFalse(1);
        a.setTrue(2);
        a.setTrue(3);
        a.setFalse(4);
        a.printElement(8);
    }
}

package ds;
import java.io.Serializable;

public class Input extends Element implements Serializable{

    @Override
    public void addInput(Element in) {
        if (inputs.isEmpty()) {
            inputs.add(in);
        } else {
            System.out.println("I will not add inputs to INPUT");
        }
    }
}

package lab4;
import java.io.Serializable;

public class NOT extends Element implements Serializable{
    @Override
    public boolean getOutput() {

        if (inputs.isEmpty()) {
            output = true;
        } else {
            output = !(inputs.get(0).getOutput());
        }
        return output;
    }
}

package ds;
import java.io.Serializable;

public class AND extends Element implements Serializable {

    @Override
    public boolean getOutput() {
        if (inputs.isEmpty()) {
            return false;
        } else {
            for (Element e : inputs) {
                if (!e.getOutput()) {
                    return false;
                }
            }
        }
        return true;
    }
}

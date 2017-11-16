package lab4;
import java.io.Serializable;

public class OR extends Element implements Serializable{
    
    @Override
    public boolean getOutput() {
        boolean result =false;
        if (inputs.isEmpty()) {
            result= false;
        } else {
            for (Element e : inputs) {
                if (e.getOutput()) {
                    result =true;
                }
            }
        }
        return result;
    }
}

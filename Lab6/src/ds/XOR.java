package ds;
import java.io.Serializable;

public class XOR extends Element implements Serializable{
    
    @Override
    public boolean getOutput() {
        boolean result = false;
        int howManyOnes= 0;
        if (inputs.isEmpty()) return false;
        else {
            for (Element e : inputs) 
                if (!e.getOutput()) howManyOnes++;
                
            if(howManyOnes%2==1) return true; 
        }
        return false;
    }
}

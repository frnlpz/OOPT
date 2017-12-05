package ds;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Element implements Serializable{

    int id;
    static int NUMBER_OF_ELEMENTS = 1;
    ArrayList<Element> inputs = new ArrayList();
    boolean output = false;
    int x, y;

    public int getLevel(){
        int level = 0;
        for (Element e : inputs){
            level = Math.max(level, e.getLevel());
        }
        return level + 1;
    }
    
    public void addInput(Element in) {
        inputs.add(in);

    }

    public boolean getOutput() {
        return output;
    }

    public Element() {
        id = NUMBER_OF_ELEMENTS++;
        x = (int) (Math.random() * 300);
        y = (int) (Math.random() * 300);
    }

    public static int getNUMBER_OF_ELEMENTS() {
        return NUMBER_OF_ELEMENTS;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Element> getInputs() {
        return inputs;
    }

    public boolean isOutput() {
        return output;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.getClass() + " " + id;
    }

    public void toString2(String tab) {
        System.out.println(tab + "" + this.getClass() + " " + id + " " + getOutput());
        for (Element e : inputs) {
            e.toString2(tab + "\t");
        }
    }

    public boolean hasAChild(Element e) {
        boolean result = false;
        if (inputs.contains(e)) {
            result = true;
        } else {
            for (Element ch : inputs) {
                if (ch.hasAChild(e)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.inputs);
        hash = 97 * hash + (this.output ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element other = (Element) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.output != other.output) {
            return false;
        }
        if (!Objects.equals(this.inputs, other.inputs)) {
            return false;
        }
        return true;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }


}

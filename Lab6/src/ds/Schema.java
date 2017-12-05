package ds;
import java.io.Serializable;
import java.util.ArrayList;

public class Schema implements Serializable{

    ArrayList<Element> listOfElements = new ArrayList();

    public ArrayList<Element> getListOfElements() {
        return listOfElements;
    }
    
    public void addInput() {
        listOfElements.add(new Input());
    }

    public void addAND() {
        listOfElements.add(new AND());
    }

    public void addNOT() {
        listOfElements.add(new NOT());
    }

    public void addOR() {
        listOfElements.add(new OR());
    }

    public void addXOR() {
        listOfElements.add(new XOR());
    }

    public boolean isItALoop(int from, int to) {
        Element el1 = getElementById(from);
        Element el2 = getElementById(to);
        return isItALoop(el1, el2);
    }

    public boolean isItALoop(Element from, Element to) {
        if (from.equals(to)) {
            return false;
        }
        return from.hasAChild(to);
    }

    public void connectElements(int from, int to) {
        if (from != to) {
            Element first = getElementById(from);
            Element second = getElementById(to);
            if (first != null && second != null)
                if (!isItALoop(first, second))
                    second.addInput(first);
                else
                    System.out.println("Error.......");              
            else
                System.out.println("I am not able to connect both elements!");
        }
    }

    public boolean getResult(int id) {
        Element current = getElementById(id);
        if (current != null) {
            current.getOutput();
        }
        return false;
    }

    public void printSchema() {
        for (Element e : listOfElements) {
            System.out.println(e);
            for (Element inputs : e.inputs) {
                System.out.println("\t" + inputs);
            }
        }
    }

    public void printElement(int id) {
        Element current = getElementById(id);
        current.toString2("");
    }

    public void setResult(int id, boolean value) {
        Element current = getElementById(id);
        if (current != null) {
            if (current.getClass().equals(Input.class)) {
                current.output = value;
            } else {
                System.out.println("We can not set value to not Input element!");
            }
        }
    }

    public void setTrue(int id) {
        setResult(id, true);
    }

    public void setFalse(int id) {
        setResult(id, false);
    }

    public void deleteElement(int id) {
        Element deleted = getElementById(id);
        for (Element e : listOfElements) {
            e.inputs.remove(deleted);

        }
        listOfElements.remove(deleted);
    }

    public void deleteConnection(int from, int to) {
        Element el1 = getElementById(from);
        Element el2 = getElementById(to);
        if (el1 != null && el2 != null) {
            el2.inputs.remove(el1);
        }
    }

    public Element getElementById(int id) {
        for (Element e : listOfElements) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }
}

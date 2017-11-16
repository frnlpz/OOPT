package Lab4;

public class Or extends Gate {
    public Or(boolean[] inputs) {
        super(inputs);
    }

    public Or() {}

    @Override
    public boolean getOutput() {

        boolean res = false;
        for (int i = 0; i < getInputs().length; i++)
            res = res || getInputs()[i];
        System.out.println("OR  output: " + res);
        return res;

    }
}
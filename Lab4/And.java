package Lab4;

public class And extends Gate {
    public And(boolean[] inputs) {
        super(inputs);
    }

    public And(){}

    @Override
    public boolean getOutput() {

        boolean res = true;
        for (int i = 0; i < getInputs().length; i++)
            res = res && getInputs()[i];
        System.out.println("AND  output: " + res);
        return res;

    }
}
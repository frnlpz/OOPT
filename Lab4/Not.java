package Lab4;

public class Not extends Gate {

    public Not(boolean[] inputs) {
        super(inputs);
    }

    public Not(){}

    @Override
    public boolean getOutput(){
        System.out.println("Not output: "+!getInputs()[0]);
        return !getInputs()[0];
    }
}

package Lab4;

public class Xor extends Gate {
    public Xor(boolean [] inputs){
        super(inputs);
    }

    public Xor(){}

    @Override
    public boolean getOutput(){

        boolean res = getInputs()[0];
        for (int i = 1; i < getInputs().length; i++)
            res = res ^ getInputs()[i];
        System.out.println("XOR output: "+res);
        return res;

    }
}

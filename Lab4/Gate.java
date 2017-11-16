package Lab4;

public class Gate {
    private boolean [] inputs;
    private boolean output;


    public Gate(boolean[] inputs){
        this.inputs = inputs;
    }

    public Gate(){
        this.inputs = new boolean[]{};
        this.output = false;
    }

    public boolean[] getInputs() {
        return inputs;
    }

    public void setInput(boolean input, int index) {
        this.inputs[index] = input;
    }

    public boolean getOutput() {
        return output;
    }
}

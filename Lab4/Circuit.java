package Lab4;

public class Circuit {

    private static int MAX = 999;

    private boolean[] inputs;
    private Gate[] gates = new Gate[MAX];
    private boolean output;

    public boolean getOutput() {
        return output;
    }

    public Gate[] getGates() {
        return gates;
    }

    public boolean[] getInputs() {
        return inputs;
    }

    public void setGate(Gate gate, int index) {
        this.gates[index] = gate;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public void setInput(boolean input, int index) {
        this.inputs[index] = input;
    }
}

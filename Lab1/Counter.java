package Lab1;

public class Counter {
    private int result = 0;
    public int getResult() {
        return result;
    }
    public void count(int iki) {
        for (int i = 0; i < iki; i=i*2+1) {
            result = i;
        }
    }
    public void generate(int iki){
        result = (int)(Math.random()*iki)+1;
    }
}
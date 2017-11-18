package lab6;

public class PaintingThread extends Thread {
    
    Drawing draw = null;
    int number   = 0;
    int seconds  = 1;
    
    public PaintingThread(Drawing draw, int number, int seconds){
        this.draw    = draw;
        this.number  = number;
        this.seconds = seconds;
    }
    
    @Override
    public void run() {
        try{
            for (int i = 1; i <= number; i++){
                draw.level = i;
                draw.repaint();
                Thread.sleep(seconds*1000);
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted!");
        }
        draw.level = 0;
        draw.repaint();
    }
}

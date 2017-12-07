package lab6;

import java.util.ArrayList;
import ds.Element;

public class MovingThread extends Thread {
    
    Drawing draw = null;
    static int MAX_NUM_OF_ITERATIONS = 9999;
    
    public MovingThread(Drawing draw){
        this.draw    = draw;
    }
    
    @Override
    public void run() {
        try{
            for (int i = 1; i <= MAX_NUM_OF_ITERATIONS; i++){
                ArrayList<Element> elements = draw.forDrawing.getListOfElements();
                int elementIndex = (int) (Math.random()*elements.size());
                Element moving = elements.get(elementIndex);
                int newX = moving.getX()+ (int) (Math.random()*30 - 15);
                int newY = moving.getY()+ (int) (Math.random()*30 - 15);
                
                if (newX < 0)                newX += 30;
                if (newX > draw.getWidth())  newX -= 30;
                if (newY < 0)                newY += 30;
                if (newY > draw.getHeight()) newY -= 30;
                
                moving.setX(newX);
                moving.setY(newY);
                draw.repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted!");
        }
        draw.level = 0;
        draw.repaint();
    }
}

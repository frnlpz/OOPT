package lab6;

import lab4.AND;
import lab4.OR;
import lab4.Element;
import lab4.NOT;
import lab4.Schema;
import lab4.XOR;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Drawing extends javax.swing.JPanel {

    /*
     * Creates new form Drawing
     */
    Schema forDrawing                       = null;
    BufferedImage img_OR, img_AND, img_XOR  = null;
    Element separate, selected              = null;
    Color color                             = Color.red;
    int zoom                                = 50;
    boolean toShowOutput                    = true;
    int level                               = 0;

    public Drawing() {
        initComponents();
        try {
            img_OR  = ImageIO.read(new File("img/OR.png"));
            img_AND = ImageIO.read(new File("img/AND.png"));
            img_XOR = ImageIO.read(new File("img/XOR.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setForDrawing(Schema forDrawing) {
        this.forDrawing = forDrawing;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(level + "", this.getWidth() - 30, 30);
        if (forDrawing == null) {
            g.drawString("You need to create a new schema.", 10, 20);
        } else {
            //g.drawString("I will paint the schema soon..............", 10, 20);
            for (Element e : forDrawing.getListOfElements()) {
                paintElement(e, g);
            }
            if (separate != null) {
                paintElement(separate, g);
            }
        }
    }

    public void paintElement(Element e, Graphics g) {
        if (e.getClass().equals(NOT.class)) {
            //print not element
            g.drawLine(e.getX(), e.getY(), e.getX(), e.getY() + zoom);
            g.drawLine(e.getX(), e.getY(), e.getX() + 3 * zoom / 4, e.getY() + zoom / 2);
            g.drawLine(e.getX(), e.getY() + zoom, e.getX() + 3 * zoom / 4, e.getY() + zoom / 2);
            g.drawOval(e.getX() + 3 * zoom / 4, e.getY() + 3 * zoom / 8, zoom / 4, zoom / 4);
        } else if (e.getClass().equals(OR.class)) {
            g.drawImage(resize(img_OR, zoom, zoom), e.getX(), e.getY(), this);
        } else if (e.getClass().equals(AND.class)) {
            g.drawImage(resize(img_AND, zoom, zoom), e.getX(), e.getY(), this);
        } else if (e.getClass().equals(XOR.class)) {
            g.drawImage(resize(img_XOR, zoom, zoom), e.getX(), e.getY(), this);
        } else {
            g.drawRect(e.getX(), e.getY(), zoom, zoom);
        }
        
        g.drawString(e.getLevel() + "", e.getX(), e.getY());
        /*if (e.getLevel() <= level){
            g.drawRect(e.getX() - 2, e.getY() -2, zoom + 4, zoom + 4);
        }*/
        
        if (selected != null && e.getId() == selected.getId()) {
            g.setColor(color);
            g.drawRect(e.getX() - 1, e.getY() - 1, zoom + 2, zoom + 2);
            g.setColor(Color.black);
        }
        if (toShowOutput) {
            g.setColor(Color.RED);
            if (e.getOutput()) {
                g.setColor(Color.green);
            }
            if (e.getLevel() <= level){
                g.drawString(e.getOutput() + "", e.getX() + zoom + 2, e.getY() + zoom / 2);

            }
            g.setColor(Color.BLACK);
        }
        int i = 0;
        for (Element in : e.getInputs()) {
            ++i;
            g.drawLine(e.getX(), e.getY() + i*zoom / (e.getInputs().size()+1), in.getX() + zoom, in.getY() + zoom / 2);
        }
    }

//
//    g.drawRect (e.getX
//
//    (), e.getY(), zoom, zoom);
//    g.drawString (e.getOutput
//    () + "", e.getX() + zoom + 2, e.getY() + zoom / 2);
//    for (Element in
//
//    : e.getInputs () 
//        ) {
//                g.drawLine(e.getX(), e.getY() + zoom / 2, in.getX() + zoom, in.getY() + zoom / 2);
//    }
//}
//}
    //https://stackoverflow.com/questions/9417356/bufferedimage-resize
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

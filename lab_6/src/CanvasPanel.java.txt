import  javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel{
    private int a = 20;
    private int b = 20;
    private int color1 = 0;
    private int color2= 0;
    private int color3 = 0;
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.BLACK);
        //g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        //g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor(Color.getHSBColor((float)(color1*0.1),(float)(color2*0.1),(float)(color3*0.1)));
        g.drawPolygon(new int[] {xCenter, xCenter, xCenter+b}, new int[] {yCenter - a, yCenter, yCenter}, 3);
        g.fillPolygon(new int[] {xCenter, xCenter, xCenter+b}, new int[] {yCenter - a, yCenter, yCenter}, 3);
        int radius = (int) (Math.sqrt(a*a + b*b) / 2);
        g.setColor(Color.BLUE);
        g.drawOval((int)(xCenter+b/2-radius),(int)(yCenter-a/2-radius),radius*2,radius*2);
    }

    protected void setA(int a){
        this.a = a;
        repaint();
    }
    protected void setB(int b){
        this.b = b;
        repaint();
    }
    protected void setColor1(int color){
        this.color1 = color;
        repaint();
    }
    protected void setColor2(int color){
        this.color2 = color;
        repaint();
    }
    protected void setColor3(int color){
        this.color3 = color;
        repaint();
    }
}

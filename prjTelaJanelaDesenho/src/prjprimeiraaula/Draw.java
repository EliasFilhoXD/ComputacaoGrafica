package prjprimeiraaula;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Draw extends JComponent { //criação dos desenhos e movimento dos desenhos

    int px, py;
            
    public Draw(int px, int py){
        this.px = px;
        this.py = py;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(px, py, 60, 90);
    }
    
    public void setRight(){
        px+=10;
        repaint();
    }
    
    public void setLeft(){
        px-=10;
        repaint();
    }
    
    public void setDown(){
        py+=10;
        repaint();
    }
    public void setUP(){
        py-=10;
        repaint();
    }

}

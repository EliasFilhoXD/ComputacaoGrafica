package algdigitaldifferenceanalythic;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class AlgDDA extends JFrame{

    public AlgDDA() {
        this.setTitle("Algorhtm DDA");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        algDDA(g,50,50,250,50);
        g.setColor(Color.blue);
        algDDA(g,50,50,50,250);
        g.setColor(Color.BLACK); // 45 graus
        algDDA(g,50,50,250,250);
        g.setColor(Color.GREEN); // 90 graus
        algDDA(g,50,50,250,150);
        g.setColor(Color.GRAY);
        algDDA(g,50,50,150,250); // 90 graus
    }
    
    public void algDDA(Graphics g, int x1, int y1, int x2, int y2){
        int steps, dx, dy;
        float x=x1, y=y1;
        float incX, incY; // incremento de X e Y
        
        dx = (x2 - x1); // diferença de x
        dy = (y2 - y1); // diferença de y
        
        if (Math.abs(dx) > Math.abs(dy)) {
           incX = 1;
           incY = ((float)dy/dx);
           
           steps = Math.abs(dx);
        } else {
           incX = ((float)dx/dy);
           incY = 1;
           
           steps = Math.abs(dy);
        }
        
        for (int i=0; i<steps; i++){
           x = x + incX;
           y = y + incY;
           putPixel(g, Math.round(x),Math.round(y));
        }
        
    }
    
    public void putPixel(Graphics g, int x, int y){
        g.drawLine(x, y, x, y);
    }
}

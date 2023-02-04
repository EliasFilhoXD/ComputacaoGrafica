package alganalitico;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class AlgAnalytic extends JFrame {

    public AlgAnalytic() {
        this.setTitle("Analytic Algorithm");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        algAnalytic(g,50,50,250,50);
        g.setColor(Color.blue);
        algAnalytic(g,50,50,50,250);
        g.setColor(Color.BLACK);
        algAnalytic(g,50,50,250,250);
        g.setColor(Color.GREEN);
        algAnalytic(g,50,50,250,150);
        g.setColor(Color.GRAY);
        algAnalytic(g,50,50,150,250);
    }
    
    public void putPixel(Graphics g, int x, int y){
        g.drawLine(x, y, x, y);
    }
    
    public void algAnalytic(Graphics g, int x1, int y1, int x2, int y2){
        float m, b, dy, dx;
        
        int x, y;
        
        dy = (y2 - y1);
        dx = (x2 - x1);
        
        m = dy / dx; //coef angular
        
        b = y1 - m*x1; //coef linear
        
        for(x=x1; x<x2; x++){
            y = (int)(m*x + b);
            putPixel(g,x,y);
        }
    }
    
}

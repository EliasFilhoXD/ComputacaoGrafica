
package alglinesall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class Draw extends JFrame implements Runnable {
    
    private int option=1;

    public Draw() {
        new Thread(this).start();
        this.setTitle("Algoritmo de Linhas Retas - Todos");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void drawAnalytic(Graphics g) {
        g.drawString("Analitico", 50, 45);
        g.setColor(Color.red);
        algAnalytic(g,50,50,250,250);
        g.setColor(Color.blue);
        algAnalytic(g,50,50,250,50);
        g.setColor(Color.green);
        algAnalytic(g,50,50,50,250);
        g.setColor(Color.gray);
        algAnalytic(g,50,50,250,150);
        g.setColor(Color.black);
        algAnalytic(g,50,50,150,250);
    }
    
    private void drawDDA(Graphics g) {
        g.drawString("DDA", 50, 45);
        g.setColor(Color.red);
        algDDA(g,50,50,250,250);
        g.setColor(Color.blue);
        algDDA(g,50,50,250,50);
        g.setColor(Color.green);
        algDDA(g,50,50,50,250);
        g.setColor(Color.gray);
        algDDA(g,50,50,250,150);
        g.setColor(Color.black);
        algDDA(g,50,50,150,250);
    }
    
    private void drawBreseham(Graphics g) {
        g.drawString("Breseham", 50, 45);
        g.setColor(Color.red);
        algBres(g,50,50,250,250);
        g.setColor(Color.blue);
        algBres(g,50,50,250,50);
        g.setColor(Color.green);
        algBres(g,50,50,50,250);
        g.setColor(Color.gray);
        algBres(g,50,50,250,150);
        g.setColor(Color.black);
        algBres(g,50,50,150,250);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        switch (option) {
            case 1:
                drawAnalytic(g);
                break;
            case 2:
                drawDDA(g); 
                break;
            case 3:
                drawBreseham(g);
                break;
            default:
                break;
        }
       
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
     
      private void algBres(Graphics g, int x1, int y1, int x2, int y2) {
        int x = x1;
        int y = y1;
        int dx = (x2-x1);
        int dy = (y2-y1);
        int dec = 0;
        
        if(dy <= dx){
            while(true){
               putPixel(g, x, y);
               if(x == x2){
                   break;
               }
               x++;
               dec = dec + dy;
               if(dec >= dx){
                   y++;
                   dec = dec - dx;
               }
           } 
        } else {
            while(true){
                putPixel(g, x, y);
                    if (y == y2){
                        break;
                    }
                    y++;
                    dec = dec + dx;
                    if (dec >= dy){
                        x++;
                        dec = dec - dy;
                    }
            }
        }
        
                
    }
    
    
    public void putPixel(Graphics g, int x, int y){ //pinta pixel
        g.drawLine(x, y, x, y);
    }

    @Override
    public void run() {
        while(true) {
            try {
                if (option>3){
                    option = 0;
                    option++;
                    repaint();
                } else {
                    Thread.sleep(3000);
                    option++;
                    repaint();
                }
            } catch (InterruptedException ex) {
                
            }
        }
    }

    
}

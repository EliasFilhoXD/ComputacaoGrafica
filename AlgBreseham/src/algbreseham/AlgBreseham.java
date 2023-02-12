package algbreseham;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class AlgBreseham extends JFrame {

    public AlgBreseham() {
        this.setTitle("Lines Algorithm - Breseham");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
      
    }
    
    @Override
    public void paint(Graphics g){//papel
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
}

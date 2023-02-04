package prjprimeiraaula;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener { //criação e parte de escutar as ações feitas na janela
    
    Draw draw = new Draw(10,10);
    
    public Window() {
        
        this.add(draw);
        
        this.addKeyListener(this);
        
        this.setTitle("First Graph");
        this.setSize(300, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Alguma coisa");
            draw.setRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Alguma coisa");
            draw.setLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("Alguma coisa");
            draw.setDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Alguma coisa");
            draw.setUP();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
}

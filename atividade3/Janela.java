import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Janela extends JFrame {
    private StringBuilder texto;
    private boolean onFocus;
    public Janela() {
        super("Atividade 3");
        
        texto = new StringBuilder("");

        Panel panel = new Panel();
        add(panel);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent event){
                if (onFocus) {
                    if (event.getKeyChar() == event.VK_BACK_SPACE) {
                        if (texto.length() != 0) {
                           texto.setLength(texto.length() - 1);
                        }
                    } else {
                        texto.append(event.getKeyChar());
                    }
                    panel.revalidate();
                    panel.repaint();
                }

              }
        });
        this.setSize(600, 500);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }   
    public class Panel extends JPanel {
        public Panel() {

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if ((event.getX() > 50 && event.getX() < 550) && (event.getY() > 30 && event.getY() < 80)) {
                        onFocus = true;
                    } else {
                        texto.setLength(0);
                        onFocus = false;
                    }
                }
            });
           
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("SansSerif", Font.PLAIN, 14));
            g.drawRect(10, 10, 575, 449);
            g.drawRect(50, 30, 500, 50);
            g.drawString(texto.toString(), 51, 60);
        }
    }   
}



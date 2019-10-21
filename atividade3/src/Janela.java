import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Janela frame = new Janela();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.paint(null);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

     public void paint(Graphics g)
      {
             g.setColor(Color.BLACK);
             g.drawRect(175, 225, 400, 300);
             g.drawRect(200, 250, 350, 50);

             //botao
             g.setColor(Color.BLUE);
             g.drawRect(435, 450, 100, 50);
      }

    /**
     * Create the frame.
     */
    public Janela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1000, 100, 1000, 1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 592, 410);
        contentPane.add(panel);

        panel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                System.out.println(e.getX() + " " + e.getY());

               if( (e.getY() > 435 && e.getY()<535) && (e.getX() > 450 && e.getX() < 500))
                System.out.println("funcionou");

            }

        });
    }
}
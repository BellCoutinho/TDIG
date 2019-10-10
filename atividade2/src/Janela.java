import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Janela extends JFrame {
    public Janela() {
        super("Atividade 2");
        setLayout(new GridLayout(1, 2, 1, 1));

        JPanel imagePanel = null;
        try {
            BufferedImage image = ImageIO.read(new File("Panic.jpg"));
            imagePanel = new JPanel() {
                @Override
                public void paintComponent (Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, this);
                }
            };
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JButton botao = new JButton("Restore");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (getExtendedState() == NORMAL) {
                    setExtendedState(MAXIMIZED_BOTH);
                } else {
                    setExtendedState(NORMAL);
                }
            }
        });

        add(botao);
        add(imagePanel);


        
        pack();
        setSize(350, 280);
        setMinimumSize(new Dimension(350, 280)); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
    }
}

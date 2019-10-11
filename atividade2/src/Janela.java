import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Janela extends JFrame {
    public Janela() {
        super("Atividade 2");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        this.setContentPane(getPrincipalPanel());
        this.setSize(400, 300);
        this.setMinimumSize(new Dimension(400, 280));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }


    private JPanel getPrincipalPanel() {
        JPanel principalPanel = new JPanel(new BorderLayout());
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(95, 95, 95));
        container.add(getImagePanel(), BorderLayout.EAST);
        container.add(getButtonPanel(), BorderLayout.LINE_START);
        principalPanel.setBackground(new Color(95, 95, 95));
        principalPanel.add(container, BorderLayout.SOUTH);

        return principalPanel;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton button = new JButton("Restore");
        buttonPanel.setBackground(new Color(95, 95, 95));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(175, 5, 10, 5));
        button.setToolTipText("Clique para Maximizar");
        button.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        button.setBackground(new Color(95, 95, 95));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (getExtendedState() == NORMAL) {
                    setExtendedState(MAXIMIZED_BOTH);
                    button.setToolTipText("Clique para restaurar tamanho original");
                } else {
                    setExtendedState(NORMAL);
                    button.setToolTipText("Clique para Maximizar");
                }
            }
        });
        buttonPanel.add(button, BorderLayout.CENTER);
        return buttonPanel;
    }

    private JPanel getImagePanel() {
        JPanel imagePanel = null;
        try {
            BufferedImage image = ImageIO.read(new File("./images/Panic.jpg"));
            imagePanel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, this);
                }
            };
            imagePanel.setPreferredSize(new Dimension(320, 240));
            imagePanel.setMinimumSize(new Dimension(320, 240));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return imagePanel;
    }
}

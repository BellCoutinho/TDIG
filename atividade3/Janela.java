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
import javax.swing.JOptionPane;

public class Janela extends JFrame {
    private StringBuilder texto;
    private boolean onFocus;
    private boolean checkBoxEstado;
    private boolean submit;

    public Janela() {
        super("Atividade 3");

        texto = new StringBuilder("");

        Panel panel = new Panel();
        add(panel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (onFocus) {
                    if (event.getKeyChar() == event.VK_BACK_SPACE) {
                        if (texto.length() != 0) {
                            texto.setLength(texto.length() - 1);
                        }
                    } else {
                        if (texto.length() <= 21)
                            texto.append(event.getKeyChar());
                    }
                    panel.revalidate();
                    panel.repaint();
                }

            }
        });
        // this.setSize(300,300 );
        this.setMinimumSize(new Dimension(400, 400));
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
                    if ((event.getX() > 20 && event.getX() < 380) && (event.getY() > 20 && event.getY() < 80)) {
                        onFocus = true;
                    }

                    else
                        onFocus = false;

                    // checkbox
                    if ((event.getX() > 50 && event.getX() < 70) && (event.getY() > 120 && event.getY() < 140)) {
                        checkBoxEstado = !checkBoxEstado;
                        revalidate();
                        repaint();
                    }

                    if ((event.getX() > 260 && event.getX() < 360) && (event.getY() > 250 && event.getY() < 290)) {
                        StringBuilder mensagem = new StringBuilder("");
                        mensagem.append("TextField: " + ( (texto.length()==0)?"nada foi digitado": texto.toString()) + " ");
                        if (checkBoxEstado) {
                            mensagem.append("\nCheckBox: " + "Marcado");
                        } else {
                            mensagem.append("\nCheckBox: " + "Nao marcado");
                        }
                        JOptionPane.showMessageDialog(null, mensagem.toString(), "Aviso",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            });

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Retangulo externo
            g.drawRect(10, 10, 380, 350);
            // TextField
            g.drawRect(20, 20, 360, 60);

            // CheckBox
            g.drawRect(50, 120, 20, 20);

            if (checkBoxEstado) {
                g.setColor(Color.BLACK);
                g.fillRect(50, 120, 20, 20);
            }

            // botao submit
            g.drawRect(260, 250, 100, 40);
            g.setFont(new Font("SansSerif", Font.PLAIN, 14));
            g.drawString("Submit", 285, 275);

            g.setFont(new Font("SansSerif", Font.PLAIN, 30));
            g.drawString(texto.toString(), 33, 70);

            g.setFont(new Font("SansSerif", Font.PLAIN, 20));
            g.drawString("Confirma texto", 80, 137);
        }
    }
}
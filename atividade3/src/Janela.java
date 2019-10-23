import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela extends JFrame {

    private TextField textField;
    private CheckBox checkBox;

    public Janela() {
        super("Atividade 3");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (textField.isSelected()) {
                    textField.addText(event.getKeyChar());
                    textField.revalidate();
                    textField.repaint();
                }
            }
        });
        this.setSize(300, 450);
        this.setPreferredSize(new Dimension(300, 400));
        this.setContentPane(getPrincipalPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    private JPanel getPrincipalPanel() {
        JPanel principalPanel = new JPanel(new FlowLayout());

        principalPanel.setPreferredSize(new Dimension(300, 400));
        principalPanel.setBackground(new Color(250, 250, 250));

        principalPanel.add(getTextPanel());
        principalPanel.add(getCheckPanel());
        principalPanel.add(getButtonPanel());

        return principalPanel;
    }

    private JPanel getButtonPanel() {
        Button button = new Button("Login");
        JPanel buttonPanel = new JPanel();

        buttonPanel.setPreferredSize(new Dimension(200, 150));
        buttonPanel.setBackground(new Color(250, 250, 250));

        button.setBackground(new Color(208, 208, 208));
        button.setPreferredSize(new Dimension(100, 50));
        button.setToolTipText("Fazer Login");
        button.setButtonSize(100, 50);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel alert = new JPanel(new BorderLayout());
                JLabel label1 = new JLabel("Login: " + textField.getText());
                String manterLogin;

                textField.setSelected(false);

                if (checkBox.isSelected()) {
                    manterLogin = "Sim";
                } else {
                    manterLogin = "Não";
                }
                JLabel label2 = new JLabel("Manter conectado: " + manterLogin);
                alert.add(label1, BorderLayout.NORTH);
                alert.add(label2, BorderLayout.SOUTH);
                JOptionPane.showMessageDialog(null, alert, "Confirmar", JOptionPane.PLAIN_MESSAGE);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIsOnOver(true);
                button.revalidate();
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIsOnOver(false);
                button.revalidate();
                button.repaint();
            }
        });
        buttonPanel.add(button);

        return buttonPanel;
    }

    private JPanel getCheckPanel() {
        JPanel checkPanel = new JPanel(new BorderLayout());

        checkBox = new CheckBox(25, 25);
        checkBox.setBackground(new Color(250, 250, 250));
        checkBox.setText("Manter conectado");
        checkBox.setToolTipText("Continuar Logado");
        checkBox.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkBox.setSelected(!checkBox.isSelected());
                checkBox.revalidate();
                checkBox.repaint();
                textField.setSelected(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        checkPanel.setPreferredSize(new Dimension(200, 150));
        checkPanel.setBackground(new Color(255, 255, 255));

        checkPanel.add(checkBox);

        return checkPanel;
    }

    private JPanel getTextPanel() {
        JPanel textPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Label label = new Label("User");
        label.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));
        label.setBackground(new Color(250, 250, 250));
        label.setFontSize(15);


        textPanel.setBackground(new Color(250, 250, 250));

        textField = new TextField();
        textField.setPreferredSize(new Dimension(200, 50));
        textField.setToolTipText("Insira username");
        textField.setBackground(new Color(250, 250, 250));
        textField.setSize(200, 50);
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setSelected(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("oi");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("oi");
            }
        });

        c.gridheight = 2;
        textPanel.add(label);
        c.gridy = 4;
        textPanel.add(textField, c);

        return textPanel;

    }
}
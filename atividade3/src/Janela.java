import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {

    private JPanel principalPanel;
    private JTextField textField;
    private JCheckBox checkBox;

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

        this.setSize(300, 450);
        this.setPreferredSize(new Dimension(300, 400));
        this.setContentPane(getPrincipalPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    private JPanel getPrincipalPanel() {
        principalPanel = new JPanel(new FlowLayout());

        principalPanel.setPreferredSize(new Dimension(300, 400));
        principalPanel.setBackground(new Color(255, 255, 255));

        principalPanel.add(getTextPanel());
        principalPanel.add(getCheckPanel());
        principalPanel.add(getButtonPanel());

        return principalPanel;
    }

    private JPanel getButtonPanel() {
        JButton button = new JButton("Login");
        ButtonHandler handler = new ButtonHandler();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setPreferredSize(new Dimension(200, 150));
        buttonPanel.setBackground(new Color(255, 255, 255));

        button.setBackground(new Color(208, 208, 208));
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(handler);
        button.setToolTipText("Fazer Login");
        buttonPanel.add(button);

        return buttonPanel;
    }

    private JPanel getCheckPanel() {
        JPanel checkPanel = new JPanel(new BorderLayout());

        checkBox = new JCheckBox();
        checkBox.setText("Manter conectado");
        checkBox.setToolTipText("Continuar Logado");

        checkPanel.setPreferredSize(new Dimension(200, 150));
        checkPanel.setBackground(new Color(255, 255, 255));

        checkPanel.add(checkBox);

        return checkPanel;
    }

    private JPanel getTextPanel() {
        JPanel textPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("User ");
        label.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));
        textPanel.setBackground(new Color(255, 255, 255));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 50));
        textField.setToolTipText("Insira username");

        c.gridheight = 2;
        textPanel.add(label);
        c.gridy = 4;
        textPanel.add(textField, c);

        return textPanel;

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel alert = new JPanel(new BorderLayout());
            JLabel label1 = new JLabel("Login: " + textField.getText());
            String manterLogin;
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
    }


}

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;



public class Janela extends JFrame {
    /**
     * Array com os JButtons utilizados
     */
    private JButton[] buttons;
    /**
     * Array com as JTextFields utilizadas
     */
    private JTextField[] textFields;

    public Janela() {
        super("Atividade 1");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        this.setContentPane(getPrincipalPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
        this.pack();
    }

    /**
     * Criar painel com todos os componentes da interface
     *
     * @return JPanel com painel de botões e text fields
     */
    private JPanel getPrincipalPanel() {
        JPanel principalPanel = new JPanel(new FlowLayout());
        principalPanel.setSize(400, 400);
        principalPanel.setBackground(new Color(64, 64, 63));
        principalPanel.add(getTextFieldsPanel()); // adicionar text fields
        principalPanel.add(getButtonsPanel()); // adicionar botões

        return principalPanel;
    }

    /**
     * Criar painel com todas as text fields da interface
     *
     * @return JPanel com todas as text fields
     */
    private JPanel getTextFieldsPanel() {
        JPanel textFieldPanel = new JPanel(new GridLayout(5, 1, 0, 3));
        textFieldPanel.setBackground(new Color(64, 64, 63));
        textFieldPanel.setPreferredSize(new Dimension(250, 300));
        textFields = new JTextField[4];

        for (int i = 0; i < 4; i++) {
            textFields[i] = new JTextField(20);
            textFields[i].setBackground(new Color(164, 165, 166));
            textFields[i].setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
            textFieldPanel.add(textFields[i]);
        }

        return textFieldPanel;
    }

    /**
     * Criar todos os botões da interface
     *
     * @return JPanel com todos os botões
     */
    private JPanel getButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 1, 2, 2));
        buttonsPanel.setPreferredSize(new Dimension(100, 300));
        buttonsPanel.setBackground(new Color(64, 64, 63));
        buttons = new JButton[5];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton("Aplicar");
            buttons[i].setToolTipText("Digite um texto para ser aplicado ao botão");
            buttons[i].setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
            buttons[i].setBackground(new Color(89, 89, 89));

            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!textFields[finalI].getText().equals(""))
                        buttons[finalI].setText(textFields[finalI].getText());
                    else
                        buttons[finalI].setText("Aplicar");
                    }
            });

            buttonsPanel.add(buttons[i]);
        }

        JButton button5 = new JButton("Aplicar");
        button5.setToolTipText("Aplica em todos os botões os textos dos seus respectivos campos");
        button5.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
        button5.setBackground(new Color(89, 89, 89));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (int i = 0; i < 4; i++) {
                    if (!textFields[i].getText().equals(""))
                        buttons[i].setText(textFields[i].getText());
                    else
                        buttons[i].setText("Aplicar");
                }
            }
        });
        buttonsPanel.add(button5);

        return buttonsPanel;
    }
}

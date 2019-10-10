import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {
    public Janela() {
        super("Atividade 1");
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e){}

        final JTextField textField1 = new JTextField(20);
        final JTextField textField2 = new JTextField(20);
        final JTextField textField3 = new JTextField(20);
        final JTextField textField4 = new JTextField(20);
        final JButton button1 = new JButton("Aplicar");
        final JButton button2 = new JButton("Aplicar");
        final JButton button3 = new JButton("Aplicar");
        final JButton button4 = new JButton("Aplicar");
        final JButton button5 = new JButton("Aplicar");
        setLayout(new FlowLayout());
        
        button1.setToolTipText("Digite um texto para ser aplicado ao botão");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField1.getText().equals(""))
                    button1.setText(textField1.getText());
                else
                    button1.setText("Aplicar");
            }
        });
        add(textField1);
        add(button1);

        button2.setToolTipText("Digite um texto para ser aplicado ao botão");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField2.getText().equals(""))
                    button2.setText(textField2.getText());
                else
                    button2.setText("Aplicar");
            }
        });
        add(textField2);
        add(button2);

        button3.setToolTipText("Digite um texto para ser aplicado ao botão");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField3.getText().equals(""))
                    button3.setText(textField3.getText());
                else
                    button3.setText("Aplicar");
            }
        });
        add(textField3);
        add(button3);

        button4.setToolTipText("Digite um texto para ser aplicado ao botão");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField4.getText().equals(""))
                    button4.setText(textField4.getText());
                else
                    button4.setText("Aplicar");
            }
        });
        add(textField4);
        add(button4);

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField1.getText().equals(""))
                    button1.setText(textField1.getText());
                else
                    button1.setText("Aplicar");

                if (!textField2.getText().equals(""))
                    button2.setText(textField2.getText());
                else
                    button2.setText("Aplicar");

                if (!textField3.getText().equals(""))
                    button3.setText(textField3.getText());
                else
                    button3.setText("Aplicar");

                if (!textField4.getText().equals(""))
                    button4.setText(textField4.getText());
                else
                    button4.setText("Aplicar");
            }
        });
        add(button5);

        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}

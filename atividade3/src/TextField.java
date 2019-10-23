import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TextField extends JPanel {
    private StringBuilder text;
    private int width;
    private int height;
    private Color fontColor = Color.BLACK;
    private boolean selected;

    public TextField() {
        selected = false;
        text = new StringBuilder("login");
        width = 10;
        height = 10;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setText(String text) {
        this.text = new StringBuilder(text);
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean status) {
        this.selected = status;
    }

    public String getText() {
        return text.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 2, height - 2);
        g.setColor(fontColor);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        if (text.length() > 30) {
            g.drawString(text.substring(text.length() - 30), 2, 25);
        } else {
            g.drawString(text.toString(), 2, 25);
        }


    }

    public void addText(char keyChar) {
        if (text.toString().equals("login")) {
            text.delete(0, text.length());
        }
        if (keyChar == KeyEvent.VK_BACK_SPACE) {
            if (text.length() != 0) {
                text.setLength(text.length() - 1);
            }
        } else {
            text.append(keyChar);
        }
    }
}
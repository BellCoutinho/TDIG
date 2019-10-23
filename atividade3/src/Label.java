import javax.swing.*;
import java.awt.*;

public class Label extends JPanel {

    private String text;
    private int width;
    private int height;
    private int fontSize = 25;
    private Color fontColor = Color.BLACK;

    public Label() {
        this.text = "text";
        this.width = 10;
        this.height = 10;
    }

    public Label(String text) {
        this.text = text;
        this.width = 10;
        this.height = 10;

    }

    public Label(int width, int height) {
        this.text = "text";
        this.width = width;
        this.height = height;

    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
    }

    public void setFontSize(int size) {
        this.fontSize = size;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(fontColor);
        g.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        g.drawString(text, 0, 25);

    }
}

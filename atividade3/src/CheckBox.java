import javax.swing.*;
import java.awt.*;

public class CheckBox extends JPanel {
    private String text;
    private int width;
    private int height;
    private Color fontColor = Color.BLACK;
    private boolean selected = false;

    public CheckBox() {
        this.text = "text";
        this.width = 10;
        this.height = 10;
    }

    public CheckBox(String text) {
        this.text = text;
        this.width = 10;
        this.height = 10;

    }

    public CheckBox(int width, int height) {
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

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean status) {
        this.selected = status;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 2, height - 2);
        if(selected){
            g.setColor(Color.BLACK);
            g.fillRect(2, 2, width - 5, height - 5);
        }
        g.setColor(fontColor);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString(text, width + 2, height - 5);


    }


}

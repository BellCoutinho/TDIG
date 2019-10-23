import javax.swing.*;
import java.awt.*;

public class Button extends JPanel {
    private int width;
    private int height;
    private String tittle;
    private Color fontColor = Color.BLACK;
    private boolean onOver = false;

    public Button(String tittle) {
        this.tittle = tittle;
        this.width = 10;
        this.height = 10;

    }

    public Button(int width, int height) {
        this.tittle = "button";
        this.width = width;
        this.height = height;

    }

    public void setButtonSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setFontColor(Color color) {
        this.fontColor = color;
    }

    public boolean isOnOver() {
        return onOver;
    }

    public void setIsOnOver(boolean status) {
        this.onOver = status;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        if (onOver) {
            g.setColor(new Color(125, 125, 125));
        }
        g.fillRect(1, 0, width - 2, height - 2);
        g.setColor(fontColor);
        if (onOver) {
            g.setColor(Color.WHITE);
        }
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString(tittle, 33, 25);

    }


}

package Animations.First;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image icon;
    Image icon2;
    Timer timer;
    int xVelocity = 3;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    Panel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.white);
        icon = new ImageIcon("Animations/images/apple.png").getImage();
        icon2 = new ImageIcon("Animations/images/android.png").getImage();
        timer = new Timer(20, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(icon, x, y, null);
        g2D.drawImage(icon2, PANEL_WIDTH - icon2.getWidth(null), PANEL_HEIGHT - icon2.getHeight(null), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH - icon.getWidth(null) || x < 0) {
            xVelocity *= -1;
        }
        x += xVelocity;
        if (y >= PANEL_HEIGHT - icon.getHeight(null) || y < 0) {
            yVelocity *= -1;
        }
        y += yVelocity;
        repaint();

        /* if (x >= PANEL_WIDTH - icon2.getWidth(null) || x < 0) {
            xVelocity *= -1;
        }
        x -= xVelocity;
        if (y >= PANEL_HEIGHT - icon2.getHeight(null) || y < 0) {
            yVelocity *= -1;
        }
        y -= yVelocity;
        repaint(); */
    }

}

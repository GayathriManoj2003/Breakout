package Breakout;

import javax.swing.*;
import java.awt.event.KeyEvent;


import java.awt.*;

class GameStatePanel extends JPanel {
    private String message;

    public void setMessage(String message) {
        this.message = message;
        repaint(); // Repaint the panel to update the message
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, 50, 50);
    }
}

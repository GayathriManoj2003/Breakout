// BrickView.java
package Breakout;

import java.awt.*;

public class BrickView {

    public void drawBrick(Graphics2D g2d, int x, int y, int width, int height, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(x, y, width, height);
    }
}

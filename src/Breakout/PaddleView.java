package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;

public class PaddleView{
    public void drawPaddle(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, w, h);
    }
}

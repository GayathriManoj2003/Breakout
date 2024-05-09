package main.views;

import java.awt.Color;
import java.awt.Graphics2D;

public class PaddleView{
    public void drawPaddle(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
//        g.fillRect(300, 600, 100, 100);
    }
}
